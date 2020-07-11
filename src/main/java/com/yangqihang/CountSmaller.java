package com.yangqihang;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组nums,按要求返回一个新数组counts数组
 * counts 有该性质:counts[i]的值是nums[i]右侧小于nums[i]的元素的数量
 */
public class CountSmaller {

    /**
     * 时间复杂度 O(N^2)
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    num++;
            }
            list.add(num);
        }
   
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(countSmaller(nums));
    }
}
