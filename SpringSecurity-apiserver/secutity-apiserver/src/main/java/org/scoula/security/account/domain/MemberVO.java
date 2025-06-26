package org.scoula.security.account.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class MemberVO {

    private String username;
    private String password;
    private String email;
    private Date regDate;
    private Date updateDate;


    private List<AuthVO> authList; //권한 목록
}
