package com.yangqihang;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestValidParenthesesTest {

    @Test
    public void longestValidParentheses() {
        String s1 = "((()(()";
        String s2 = "()()(()(()(())())((())(())(())(())()()";
        int max1 = LongestValidParentheses.longestValidParentheses(s1);
        int max2 = LongestValidParentheses.longestValidParentheses(s2);
        System.out.println(max1);
        System.out.println(max2);
    }
}