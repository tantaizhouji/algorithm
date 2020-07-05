package com.yangqihang.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void humpName() {
        String s = "my_Hobby";
        System.out.println(StringUtil.humpName(s));
    }
}