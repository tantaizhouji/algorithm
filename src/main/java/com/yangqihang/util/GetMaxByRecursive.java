package com.yangqihang.util;

/**
 * 使用递归方法求数组中的最大值
 */
public class GetMaxByRecursive {

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1); //获取中点位置
        int leftMax = process(arr, left, mid); // 左半部分的最大值
        int rightMax = process(arr, mid + 1, right); // 右半部分的最大值
        return Math.max(leftMax, rightMax);
    }
    
}
