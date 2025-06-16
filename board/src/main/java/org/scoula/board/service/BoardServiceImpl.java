package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
//@Service //@Component + 서비스역할의 클래스라는 것이 스프링에 등록
public class BoardServiceImpl implements BoardService {

    //전처리해서 dao의 메서드를 불러서 db처리해달라고 해야함.
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getList() {
        //List<BoardVO> list =  boardMapper.getList();
        //vo, vo, vo, vo, vo, vo
        //dto, dto, dto, dto, dto
        return boardMapper.getList().stream() // BoardVO의 스트림
                .map(BoardDTO::of)
                // BoardDTO의 스트림
                .toList();
    // List<BoardDTO> 변환
    }

    @Override
    public BoardDTO get(Long no) {
        BoardVO vo = boardMapper.get(no);
        //다른 곳으로 넘길 때는 dto로 만들어서 넘기자.
        BoardDTO dto = BoardDTO.of(vo);
        return Optional.ofNullable(dto)
                .orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public void create(BoardDTO board) {
        log.info("create ............!");

        //전달받은 BoardDTO를 vo로 변환
        BoardVO boardVO = board.toVo();

        //db
        boardMapper.create(boardVO);

        //vo에 생성된 pk값을
        //DTO에 전달 -> 후속 작업이 필요할떄만
        board.setNo(boardVO.getNo());

    }

    @Override
    public boolean update(BoardDTO board) {
        // 요청보낸사람 -> 게시글의 주인인지 확인하는 로직
        // 추가 로직
        int result = boardMapper.update(board.toVo());

        return result == 1;
    }

    @Override
    public boolean delete(Long no) {

     int result = boardMapper.delete(no);

     return result == 1;
    }
}
