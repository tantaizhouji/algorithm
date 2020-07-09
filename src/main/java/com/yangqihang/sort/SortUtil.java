package com.yangqihang.sort;

import java.util.Arrays;

/**
 * 排序工具类,选择排序,冒泡排序,插入排序
 */
public final class SortUtil {
    private SortUtil() {
    }

    /**
     * jdk提供的数组排序功能
     *
     * @param arr
     */
    public static void baseSort(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 选择排序
     * 从头元素开始确定顺序
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            // 如果数组为空或者数组长度小于2,不需要排序,直接返回
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            // 前面的都排好序,最后一个不需要排序,i表示需要确定元素的位置

            int minIndex = i; // 最小元素索引位置,初始为i,当前元素
            for (int j = i + 1; j < arr.length; j++) {
                // 遍历剩下的元素,找出最小值 i ~ N ,j表示非确定元素的位置

                minIndex = arr[j] < arr[minIndex] ? j : minIndex; // 比较当前元素和之前记录的最小位置元素,更新最小索引位置
            }

            if (i != minIndex) {
                // 最小位置和初始位置发生变化

                swap(arr, i, minIndex); // 将最小位置的元素和初始位置元素交换
            }

        }
    }

    /**
     * 冒泡排序
     * 从尾元素开始确定排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            // 由于元素要和+1的元素比较,所以比较的范围开始需要-1,i表示比较元素的范围

            for (int j = 0; j < i; j++) {
                // 从第0个元素开始比较,j表示当前比较的元素

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1); // 下一个元素小于当前元素,交换
                }
            }
        }
    }

    /**
     * 插入排序
     * 往有序的数组中插入元素
     * 只有一个元素的数组一定是有序到的,插入元素就和有序数组中的元素做比较,插入进去
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            // i表示需要插入元素在数组中的索引,不需要从0开始,直接从1开始插入,0 ~ i 是有序的

            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                // j表示有有序数组中元素的索引,从插入元素的前一位开始,插入元素比前一位元素小且前一位元素索引不为负数

                swap(arr, j + 1, j); // 交换元素
            }
        }
    }

    /**
     * 数组中两个元素交互,数组中两个索引a,b不能相同
     * a = a ^ b
     * b = a ^ b
     * a = a ^ b
     * 不需要额外空间就可以交换两个元素
     *
     * @param arr 数组
     * @param i   第一个元素的索引
     * @param j   第二个元素的索引
     */
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
