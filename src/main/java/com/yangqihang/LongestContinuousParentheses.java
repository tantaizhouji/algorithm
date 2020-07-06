package com.yangqihang;

/**
 * 最长连续括号
 * 给定一个只包含 '(' 和 ')' 的字符串,找出最长的包含连续括号的子串的长度
 */
public class LongestContinuousParentheses {

    /**
     * 思路:
     * 1.将字符串转化为 true 表示 '(' , false 表示 ')' 的布尔数组
     * 2.设置标志位 flag 初始为 false,数组中每个元素对 flag 进行 ^ 运算,
     * 3.使用 count 记录 ^ 运算结果为 true 的次数 , false 的时候,count 清 0,如果是true,赋值给 flag 重新计数
     * 4.当 count 为偶数次时, flag 置为 false,更新 max 值
     *
     * @param s
     * @return
     */
    public static int longestContinuousParentheses(String s) {
        int max = 0; // 记录连续括号长度的最大值
        char[] chars = s.toCharArray(); // 将字符串转换为字符数组
        boolean[] items = new boolean[chars.length]; // 新建长度和字符数组等长的布尔数组用来对应括号
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                items[i] = true; // 将布尔数组中 true 表示 '(', false 表示 ')'
            }
        }

        int count = 0; // 用来记录每一次有效括号的长度
        boolean flag = false; // 匹配括号标志位
        for (int i = 0; i < items.length; i++) {
            // 遍历布尔数组

            if (flag = flag ^ items[i]) {
                // 标志位 ^ 当前布尔值为true,表示检测到有效括号

                count++; // 有效括号长度+1
                if (count % 2 == 0) {
                    // 有效括号长度为偶数的时候,表示完整的'{}'

                    max = Math.max(max, count); // 更新最大值
                    flag = false; // 标志位置 false
                }
            } else {
                // 标志位 ^ 当前布尔值为false,表示不是有效括号

                count = 0; // 有效长度置0
                if (flag = items[i]) {
                    // '(' 的需要重新开始计算
                    count++;
                }
            }
        }

        return max;
    }
}
