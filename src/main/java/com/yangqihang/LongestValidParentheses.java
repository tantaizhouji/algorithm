package com.yangqihang;

import java.util.*;

/**
 * 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串,找出最长的包含有效括号的子串的长度
 */
public class LongestValidParentheses {

    //  ()()(
    //       ()(        )(
    //          ()(  )()  (  )(  )(  )(  )()()
    //             ()      ()  ()  ()  ()

    /**
     * 思路:
     * 模型化,分层次,每次 '(' 层次会 +1 ,每次 ')' 层次会 -1,起始记录的是有意义的 '(' 不会记录开头没有意义的的 ')'
     * 在层次模型中,开头必定是 '(',层次用 depth 记录,'(' 会 +1 , ‘)’ 会 -1,当 depth 大于 1 时,会将信息放入到 map 中
     * 将 '(', ')' 分开存放在对应层次的 Map 中,key 是depth,value是索引位置
     * 所有都分层完成后,计算每层最大的长度
     * 1.通过2个集合计算出同层次下每一对 '()' 的长度 , ')'的集合一定小于'('的集合
     * 2.将相邻的长度整合
     * 3.求出最大的长度
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        char[] chars = s.toCharArray(); // 将字符串转换为字符数组
        Map<Integer, List<Integer>> left = new HashMap<>(); //  记录'('信息
        Map<Integer, List<Integer>> right = new HashMap<>(); // 记录')'信息
        int depth = 0; // 深度
        for (int i = 0; i < chars.length; i++) {
            // 遍历字符数组

            if (chars[i] == '(') {
                // 字符为'('
                depth++; // 指针先移动到下一层,再进行操作
                List<Integer> integers = left.get(depth); // 获取map中的set
                if (integers == null) {
                    // set为null
                    integers = new ArrayList<>(); // 初始化set
                }
                integers.add(i); // 将当前元素的下标索引放入set中
                left.put(depth, integers); // 放入到该depth的map中
            } else if (chars[i] == ')') {
                if (depth > 0) {
                    // 层次大于0的时候才放入到map中
                    List<Integer> integers = right.get(depth); // 获取map中该层次的set
                    if (integers == null) {
                        // set为null的时候
                        integers = new ArrayList<>(); // 初始化set
                    }
                    integers.add(i);
                    right.put(depth, integers);
                    depth--; // 操作完成,指针指向上一层
                } else {
                    // 层次小于0
                    depth = 0; // 将层次置为0,其它不用做
                }
            }
        }

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>(); // key是depth,value是key为左边的索引,value为长度的map
        // ')'的集合一定小于等于'('的集合,所以从')'的集合取
        Set<Integer> keys = right.keySet();
        for (Integer key : keys) {
            List<Integer> leftIntegers = left.get(key);   // 获取当前深度的'('集合
            List<Integer> rightIntegers = right.get(key); // 获取当前深度的')'集合
            List<Integer> leftWrapper = new ArrayList<>();  // 整理好后的'('集合
            List<Integer> rightWrapper = new ArrayList<>(); // 整理好后的')'集合
            leftWrapper.add(leftIntegers.get(0)); // 添加第一个'('
            for (int i = 0; i < rightIntegers.size() - 1; i++) {
                // ')'集合是决定闭合的,所以')'集合一定小于'('集合,按照')'集合大小来取
                // 相邻的')('这种类型的括号抵消

                if (rightIntegers.get(i) + 1 != leftIntegers.get(i + 1)) {
                    // ')'的索引+1是'('的索引,表示2个括号连续,可以抵消
                    leftWrapper.add(leftIntegers.get(i + 1));
                    rightWrapper.add(rightIntegers.get(i));
                }
            }
            rightWrapper.add(rightIntegers.get(rightIntegers.size() - 1)); // 添加最后一个 ')'
            for (int i = 0; i < rightWrapper.size(); i++) {
                Map<Integer, Integer> innerMap = map.get(key); // 获取该层次的map
                if (innerMap == null) {
                    // map为null
                    innerMap = new HashMap<>(); // 初始化map
                }
                // map中放入key为'('的索引,value为长度
                innerMap.put(leftWrapper.get(i), rightWrapper.get(i) - leftWrapper.get(i) + 1);
                map.put(key, innerMap);
            }
        }

        int max = 0; // 最大长度
        Set<Integer> depths = map.keySet(); // 获取map中depth集合
        for (Integer curDepth : depths) {
            // 遍历map

            Map<Integer, Integer> innerMap = map.get(curDepth); // 获取当前depth的map
            Set<Map.Entry<Integer, Integer>> entries = innerMap.entrySet(); // 获取map的entries
            Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator(); // 获取迭代器
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next(); // 获取元素
                max = Math.max(max, next.getValue()); // 获取元素的长度并更新最大值
            }
        }
        return max;
    }
}
