package org.scoula.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DisplayName("리스트 출력")
    void getList() {
        List<BoardVO> list = boardMapper.getList();

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    @DisplayName("단일 출력")
    void get() {
        long no = 1L;

        BoardVO boardVO = boardMapper.get(no);

        System.out.println(boardVO);
    }

    @Test
    void create() {

        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("새로운 제목 test1");
        boardVO.setContent("새로운 내용 test1");
        boardVO.setWriter("userTest");


        int count = boardMapper.create(boardVO);

        assertEquals(1, count);
    }

    @Test
    void delete(){
        long no = 12L;
        int count = boardMapper.delete(no);

        assertEquals(1, count);
    }

    @Test
    void update() {

        BoardVO board = boardMapper.get(1L);

        board.setTitle("업데이트 제목");
        board.setContent("업데이트 내용");

        int count = boardMapper.update(board);

        assertEquals(1, count);

    }
}