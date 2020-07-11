package com.yangqihang.sort;

import com.yangqihang.generate.GenerateUtil;
import com.yangqihang.util.ArrayUtil;

/**
 * 快速排序
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int left, int right) {
        if (left >= right)
            return;
        swap(arr, left + (int) (Math.random() * (right - left + 1)), right); // arr[right]和left到right中随机一个数交换
        int[] equalArea = partition(arr, left, right); // 经过分区之后得到相等区域的区间
        process(arr, left, equalArea[0] - 1); // 左部分分区
        process(arr, equalArea[1] + 1, right); // 右部分分区
    }

    private static int[] partition(int[] arr, int left, int right) {
        if (left > right)
            return new int[]{-1, -1}; // 左边界大于右边界,划分值不存在
        if (left == right)
            return new int[]{left, right}; // 左边界等于右边界,划分值就是本身
        int less = left - 1; // 小于划分值的边界
        int more = right; // 大于划分值的边界,初始包括了划分值arr[right]
        int index = left; // 当前指向的位置
        while (index < more) { // 当前指向的位置小于大于划分值的边界的时候
            if (arr[index] == arr[right]) {
                index++; // 当前指向的值等于划分值,指针指向下一个
            } else if (arr[index] < arr[right]) {
                swap(arr, index++, ++less); // 当前值小于划分值,当前数和小于边界后的第一个数交换,小于边界扩大,指针指向下一个
            } else {
                swap(arr, index, --more); // 当前值大于划分值,当前数和大于边界前的第一个数交换,大于边界扩大,指针不动
            }
        }
        swap(arr, right, more); // 和处于大于边界的值交换初始的arr[right],
        return new int[]{less + 1, more}; // 返回等于边界 less+1, more
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
            QuickSort.quickSort(arr1);
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
