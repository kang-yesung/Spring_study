package org.scoula.board.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.dto.BoardDTO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void getList() {
    }

    @Test
    void get() {
    }

    @Test
    void create() {

        BoardDTO boardDTO = BoardDTO.builder()
                .title("새로운 테스트 제목")
                .content("새로운 테스트 내용")
                .writer("testUser")
                .build();

        boardService.create(boardDTO);

        assertNotNull(boardDTO.getNo());
        log.info("생성된 게시글 번호 {}", boardDTO.getNo());
    }

    @Test
    void update() {

        // 수정할 데이터 조회
        BoardDTO board = boardService.get(1L);

        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");

        boolean result = boardService.update(board);

        assertTrue(result);
    }

    @Test
    void delete() {

        // 테스트 대상
        long testNo = 2L;

        //삭제전 확인
        assertDoesNotThrow(()->boardService.get(testNo));

        boolean result = boardService.delete(testNo);
        assertTrue(result);


        // 삭제된 데이터를 조회했을때
        // 데이터가 없어서 발생하는 예외를 확인
        assertThrows(NoSuchElementException.class, ()-> boardService.get(testNo));
    }
}