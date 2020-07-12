package com.yangqihang;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 一个给定的数组,元素排序完改变距离最大不超过K,选择使用最适合的排序方法
 */
public class SortArrayDistanceLessK {

    /**
     * 使用堆完成排序
     *
     * @param arr 需要排序的数组
     * @param k   排序完成后元素移动位置的最大距离
     */
    public static void sortArrayDistanceLessK(int arr[], int k) {
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0; // 数组指针,初始为0
        for (; index <= Math.min(arr.length - 1, k); index++) {
            heap.add(arr[index]); // 先将数组中的前K个元素加入到堆中
        }
        int i = 0; // 记录排好序的位置
        for (; index < arr.length; i++, index++) { // 数组中的元素都添加到堆中结束
            arr[i] = heap.poll(); // 堆弹出最小的数,放到排好序的位置
            heap.add(arr[index]); // 堆中继续添加一个元素
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll(); // 将堆中剩下的元素按最小弹出到数组中
        }
    }

}
