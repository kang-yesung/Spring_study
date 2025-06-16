package org.scoula.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;
}
