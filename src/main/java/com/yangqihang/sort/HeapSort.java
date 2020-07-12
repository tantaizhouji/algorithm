package com.yangqihang.sort;

import com.yangqihang.generate.GenerateUtil;
import com.yangqihang.util.ArrayUtil;

import java.util.PriorityQueue;

public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        /*// 将数组整个变成堆,这是一个个的给数
        // 总时间复杂度O(N*logN)
        for (int i = 0; i < arr.length; i++) { // O(N)
            heapInsert(arr, i); //O(logN)
        }*/
        for (int i = arr.length - 1; i >= 0; i--) { // 总时间复杂度O(N)
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length; // 得到堆的大小
        swap(arr, 0, --heapSize); // 数组最后一个和第一个位置交换,交换之后数组最后一个位置最大,需要排序的大小heapSize - 1
        // 总时间复杂度O(N*logN)
        while (heapSize > 0) { // O(N)
            heapify(arr, 0, heapSize); // 交换之后需要排序的大小进行堆化 O(logN)
            swap(arr, 0, --heapSize); // 重复交换 O(1)
        }
    }

    /**
     * 大根堆方式插入数据
     *
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) { // 当前位置值大于当前位置的父节点的值,值需要和当前父进行交换,如果到了根节点或者小于父节点值,结束
            swap(arr, index, ((index - 1) / 2));
            index = (index - 1) / 2; // 指针指向交换之后的位置
        }
    }

    /**
     * 堆化
     *
     * @param arr      需要堆化的数组
     * @param index    堆的起始指针
     * @param heapSize 堆的大小,也是堆的边界指针
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = (index << 1) | 1; // 左子节点的位置
        while (left < heapSize) { // 左子节点是否越界
            // 获得左右子节点中最大的节点位置,判断右子节点不越界的同时,右子节点的值大于左子节点
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index; // 判断最大子节点的值是否大于父节点
            if (largest == index)
                break; // 最大节点的位置就是当前位置,跳出循环
            swap(arr, index, largest);
            index = largest; // 当前指针移动到最大子节点的位置
            left = (index << 1) | 1; // 更新左子节点
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        long start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = GenerateUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            HeapSort.heapSort(arr1);
            SortUtil.baseSort(arr2);
            if (!ArrayUtil.isEquals(arr1, arr2)) {
                succeed = false;
                ArrayUtil.printArray(arr1);
                ArrayUtil.printArray(arr2);
            }
            if (!succeed) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
