package com.yangqihang;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivideTest {

    @Test
    public void divide() {
        int result = Divide.divide(Integer.MAX_VALUE, 2);
        System.out.println(result);
    }
}