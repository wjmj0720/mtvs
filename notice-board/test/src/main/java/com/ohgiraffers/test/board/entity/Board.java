package com.ohgiraffers.test.board.entity;

import jakarta.persistence.*;

@Entity //클래스를 엔티티라고 선언 <-- jpa에서 관리하겠다 java persistence api, orm -> 객체 -> 객체를 테이블과 매칭
@Table(name = "boards")

public class Board {
    @Id //테이블에 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 : row의 식별단위 -> 자동증가 : 중복 피하기, 기본키는 중복 허용x
    @Column(name = "board_id") //컬럼명을 매칭시키기 위해
    private Integer boardId;//테이블과 매핑

    @Column(name = "board_content")
    private String boarContent;//그냥 있으면 자바 코드 ->  @Column을 써야되는 이유

    @Column(name = "board_title")
    private String boardTitle;

    public Board() {}//기본생성자 있어야됨

    public Board(String boardTitle, String boarContent) {
        this.boardTitle = boardTitle;
        this.boarContent = boarContent;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getBoarContent() {
        return boarContent;
    }

    public void setBoarContent(String boarContent) {
        this.boarContent = boarContent;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", boarContent='" + boarContent + '\'' +
                ", boardTitle='" + boardTitle + '\'' +
                '}';
    }
}
