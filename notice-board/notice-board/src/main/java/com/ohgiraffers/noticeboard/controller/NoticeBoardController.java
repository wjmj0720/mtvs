package com.ohgiraffers.noticeboard.controller;

import com.ohgiraffers.noticeboard.dto.NoticeBoardDTO;
import com.ohgiraffers.noticeboard.entity.NoticeBoard;
import com.ohgiraffers.noticeboard.service.NoticeBoardService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController //뷰 이름 받고 랜더링 하는 부분 없이
@RequestMapping("/notices") //notices로 매핑
@Validated //유효성 검사하는 어노테이션
public class NoticeBoardController {

    private static final Logger logger = LoggerFactory.getLogger(NoticeBoardController.class.getName());

    private final NoticeBoardService noticeBoardService;

    @Autowired
    public NoticeBoardController(NoticeBoardService noticeBoardService) {
        this.noticeBoardService = noticeBoardService;
    }

    //전체 조회
    @GetMapping("/all")
    public <NoticeBoardDTO> getPostAll() {
        logger.info("GET /api/notices/{}");
        NoticeBoard noticeBoards = NoticeBoardService.getPostAll();

    }

}
