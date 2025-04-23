package com.ohgiraffers.noticeboard.service;

import com.ohgiraffers.noticeboard.dto.NoticeBoardDTO;
import com.ohgiraffers.noticeboard.entity.NoticeBoard;
import com.ohgiraffers.noticeboard.repository.NoticeBoardRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class NoticeBoardService {

    private static final Logger logger = Logger.getLogger(NoticeBoardService.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(NoticeBoardService.class);
    private final NoticeBoardRepository noticeBoardRepository;

    @Autowired
    public NoticeBoardService(NoticeBoardRepository noticeBoardRepository) {
       this.noticeBoardRepository = noticeBoardRepository;
    }

    public List<NoticeBoardDTO> getPostAll() {
        logger.info("게시판 전체조회");
    //findall -> 전체 조회기에 파라미터를 받을 필요가 없음 -> findAll() 안에 값 넣기x
        List<NoticeBoard> noticeBoards = noticeBoardRepository.findAll();

        return new NoticeBoardDTO()
    }
}
