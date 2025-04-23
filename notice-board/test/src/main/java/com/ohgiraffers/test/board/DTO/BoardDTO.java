package com.ohgiraffers.test.board.DTO;

public class BoardDTO {

    private Integer boardId;
    private String boardName;
    private String boardContent;

    public BoardDTO() {
    }

    public BoardDTO(String boardName, String boardContent) {
        this.boardName = boardName;
        this.boardContent = boardContent;
    }

    public BoardDTO(Integer boardId, String boardName, String boardContent) {
        this.boardId = boardId;
        this.boardName = boardName;
        this.boardContent = boardContent;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "boardId=" + boardId +
                ", boardName='" + boardName + '\'' +
                ", boardContent='" + boardContent + '\'' +
                '}';
    }
}