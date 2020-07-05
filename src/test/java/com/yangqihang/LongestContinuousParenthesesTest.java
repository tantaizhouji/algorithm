package com.yangqihang;

import org.junit.Test;

public class LongestContinuousParenthesesTest {

    @Test
    public void longestValidParentheses() {
        String s1 = "(()";
        String s2 = ")()())";
        String s3 = "()()()())))))))(((((()(())(()(";
        int length1 = LongestContinuousParentheses.longestContinuousParentheses(s1);
        int length2 = LongestContinuousParentheses.longestContinuousParentheses(s2);
        int length3 = LongestContinuousParentheses.longestContinuousParentheses(s3);
        if (!(length1 == 2 && length2 == 4 && length3 == 8)) {
            throw new RuntimeException("测试不通过");
        }
    }
}