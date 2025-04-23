package com.ohgiraffers.test.board.service;

import com.ohgiraffers.test.board.DTO.BoardDTO;
import com.ohgiraffers.test.board.entity.Board;
import com.ohgiraffers.test.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service //빈으로 등록-> Spring이 서비스라고 인식하고 실행할 수 있게 해줌
public class BoardService {

    private final BoardRepository boardRepository; //생성자 -> 객체 만들기 위해서 만듦
    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    //비즈니스 로직 작성, 전체 조회에서는 쓸게 딱히 없음
    public List<Board> findAllBoards() {
        //1. board 리스트를 데이터베이스에서 꺼내오기
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    public boolean save(BoardDTO boardDTO) {
        // 1. 등록
        Board boardEntity = new Board(boardDTO.getBoardName(),boardDTO.getBoardContent());
        Board result = boardRepository.save(boardEntity);

        //반환
        if (result == null) {
            return false;
        }else{
            return true;
        }

    }

    //상세조회
    public BoardDTO findBoardById(int boardId) {
      Optional<Board> boardEntity = boardRepository.findById(boardId); //레퍼지토리에서 findById에 boardID를 담아서 엔티티로 담아줌(with 옵셔널)
        //엔티티 값을 담아줄 dto를 만들어줌
        BoardDTO boardDTO = new BoardDTO();
        //dto의 제목에 엔티티에서 꺼내온 제목을 담아줌  .get~ String boardName
        boardDTO.setBoardName(boardEntity.get().getBoardTitle());
        //dto의 내용에 엔티티에서 꺼내온 내용을 담아줌
        boardDTO.setBoardContent(boardEntity.get().getBoarContent());
        //dto 반환해줌
      return boardDTO;
    }

    /*상세 조회
    //데이터 베이스에서 리스트 꺼내오기
        public Board findBoardsById(Integer boardId) {
            List<Board> boards = boardRepository.findAll(); //Repository의 findAll로 전체 조회한 값을 리스트에 담음
            for (Board board : boards) { //리스트를 순회해서
                if(board.getBoardId().equals(boardId)){ //받은 ID값과 비교
                    return board; //똑같을 시 반환
                }
            }
        throw  new NoSuchElementException("해당 ID의 게시글을 찾을 수 없습니다: " + boardId); //아니면 에외처리

        }
    // 2. 해당 게시글을 찾을 수 없음 -> 받은 id 값이 db에 없음

    // 3. 존재한다면 값 반환
*/
        /*삭제*/

        public boolean deleteBoardById(int boardId) {
        //원하는 id값 찾아 삭제하기 -> id로 찾는 이유 entity의 Board클래스에 전략이 자동증가 상태 -> 중복값이 없음
        /*Optional<Board> boardEntity =*/
           boardRepository.deleteById(boardId); //deleteById -> 반환값이 void
        //엔티티 값을 담아줄 dto 생성
           // BoardDTO boardDTO = new BoardDTO();
            boolean result = !boardRepository.existsById(boardId); //exist의 반환값은 boolean


            //엔티티 값을 DTO에 넣어줌 -> 보여주고 삭제
          //  boardDTO.setBoardName(boardEntity.get().getBoardTitle());
          //  boardDTO.setBoardContent(boardEntity.get().getBoarContent());
        //return boardDTO;
        //
        return result;
       }

       /*수정
    public BoardDTO updateBoardById(int boardId) {
        BoardDTO boardDTO = new BoardDTO();
        Optional<Board> boardEntity = boardRepository.findById(boardId);
        return boardDTO;
    }*/

    public boolean updateBoard(BoardDTO boardDTO) {
        // ID로 기존 게시글 조회
        if (!boardRepository.existsById(boardDTO.getBoardId())) {
            return false; // 게시글이 존재하지 않으면 실패 반환
        }

        // 기존 게시글 가져오기
        Optional<Board> existingBoardOpt = boardRepository.findById(boardDTO.getBoardId());
        if (!existingBoardOpt.isPresent()) { //옵셔널 객체가 없을시 false 반환
            return false;
        }

        Board existingBoard = existingBoardOpt.get();//게시글이 있다면 get( )으로 옵셔널 안에 든 값들을 추출

        // 게시글 내용 업데이트
        existingBoard.setBoardTitle(boardDTO.getBoardName()); //사용자가 작성한 값들로 업데이트
        existingBoard.setBoarContent(boardDTO.getBoardContent());
        
        // 업데이트된 게시글 저장
        Board updatedBoard = boardRepository.save(existingBoard); //업데이트된 값 save로 저장
        System.out.println(updatedBoard);

        // 저장 성공 여부 반환
        return updatedBoard != null; //null이라면 false 반환
    }
}
