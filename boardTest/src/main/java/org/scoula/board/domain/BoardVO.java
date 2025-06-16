package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
    private long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;
}
