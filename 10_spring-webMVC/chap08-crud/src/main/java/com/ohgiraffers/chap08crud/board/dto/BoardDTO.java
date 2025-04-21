package com.ohgiraffers.chap08crud.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BoardDTO {

    private Integer id;

    @NotBlank(message = "제목은 필수 입력 값입니다.") //클라이언트가 응답값을 아무것도 주지 않았을 때 message 반환
    @Size(min = 2, max = 100, message = "제목은 2글자 이상 또는 100글자 미만입니다.")
    private String title; //키값 , title에 들어간 값이 밸류값이됨

    @NotBlank(message = "내용은 필수 입력 항목입니다.")
    @Size(min = 10, max = 2000, message = "내용은 10자 이상 2000자 이하로 입력해주세요.")
    private String content; // -> Json 타입으로 넘어감

    public BoardDTO() {
    }

    public BoardDTO(Integer id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
        }

        public Integer getId () {
            return id;
        }

        public void setId (Integer id){
            this.id = id;
        }

        public String getTitle () {
            return title;
        }

        public void setTitle (String title){
            this.title = title;
        }

        public String getContent () {
            return content;
        }

        public void setContent (String content){
            this.content = content;
        }

        @Override
        public String toString () {
            return "BoardDTO{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }

