package com.yangqihang;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 */
public class TwoSum {

    /**
     * 思路:
     * 从数组第一个数开始,遍历数组每一个数,判断该数和数组中其它数的和是否是目标值,是就返回他们的数组下标
     * 最简单的方法,但是速度最慢,时间复杂度O(N^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
