package org.scoula.sample.service;

import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Log4j2
public class SampleServiceImpl implements SampleService {
    @Override
    public Integer doAdd(String str1, String str2) throws Exception {
        return Integer.parseInt(str1) + Integer.parseInt(str2);
        //do add("100", "200") ==> 100 + 200
        //do add("aaa" + "200") --> exception
    }

}

