package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;
import org.scoula.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

    List<BoardVO> selectAllByMapper();

    @Select("""
    SELECT *
    from tbl_board
    """)
    List<BoardVO> selectAllByAnnotation();


}
