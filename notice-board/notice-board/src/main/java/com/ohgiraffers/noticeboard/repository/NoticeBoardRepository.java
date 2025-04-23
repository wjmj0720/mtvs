package com.ohgiraffers.noticeboard.repository;

import com.ohgiraffers.noticeboard.dto.NoticeBoardDTO;
import com.ohgiraffers.noticeboard.entity.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Integer> {//Integer대신 long은?

}
