package com.yangqihang.sort;

/**
 * 计数排序
 * 桶排序的一种,桶排序必须和样本的数据状况强相关
 */
public class CountSort {

    /**
     * 年龄0~100之间排序
     *
     * @param arr
     */
    public static void countSort(int arr[]) {
        if (arr == null || arr.length < 2)
            return;
        // 数组的长度,其实为年龄最小值
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            // 获取样本中最大年龄
            length = Math.max(length, arr[i]);
        }
        // 每个年龄准备一个桶
        int[] bucket = new int[length + 1];
        for (int i = 0; i < arr.length; i++) {
            // 将对应的年龄段放入桶中,arr[i]是年龄
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                // 当前年龄段桶大于0,数组中放入桶中个数的年龄
                arr[i++] = j;
            }
        }
    }
}
