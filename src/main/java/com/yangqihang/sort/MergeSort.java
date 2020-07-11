package com.yangqihang.sort;

import com.yangqihang.generate.GenerateUtil;
import com.yangqihang.util.ArrayUtil;

/**
 * 归并排序
 */
public class MergeSort {

    /**
     * 使用递归的方法实现归并排序
     */
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1); // 获取中间位置
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * 合并数组的左右两部分
     *
     * @param arr   数组
     * @param left  最左边界
     * @param mid   中心位置
     * @param right 最右边界
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1]; // 辅助数组
        int pl = left; // 左部分指针初始位置
        int pr = mid + 1; //右部分指针初始位置
        int i = 0; // 新数组的指针
        while (pl <= mid && pr <= right) {
            help[i++] = arr[pl] <= arr[pr] ? arr[pl++] : arr[pr++];
        }
        // 经过上面的循环之后,剩下的要么全在左半部分,要么全在右半部分,下面两种情况只会进入其中一种
        while (pl <= mid) {
            help[i++] = arr[pl++];
        }
        while (pr <= right) {
            help[i++] = arr[pr++];
        }
        // 上面处理之后,help数组就是arr中L~R部分的有序
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i]; // 从arr的left开始替换成help中有序的
        }
    }

    /**
     * 非递归方法实现归并排序
     *
     * @param arr
     */
    public static void mergeSort2(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        int mergeSize = 1; // 当前有序的左组长度,初始为1
        while (mergeSize < length) {
            int left = 0; // 当前组的左边界,初始为0
            while (left < length) {
                int mid = left + mergeSize - 1; // 获得当前小组的中心位置
                if (mid >= length) {
                    break; // 中心位置越界就结束循环
                }
                int right = Math.min(mid + mergeSize, length - 1); // 右边界取中心位置+mergeSize,如果是超出长度,就去到最后一个
                merge(arr, left, mid, right);
                left = right + 1; // 移动到下组的左边界
            }
            if (mergeSize > length / 2)
                break; // 有序的左组长度超过总长度的一半,前面处理之后整个数组已经有序,不需要再*2,防止可能的超出Integer.MAX_VALUE
            mergeSize <<= 1; // 大小翻倍
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        long start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = GenerateUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            MergeSort.mergeSort2(arr1);
            SortUtil.baseSort(arr2);
            if (!ArrayUtil.isEquals(arr1, arr2)) {
                succeed = false;
                ArrayUtil.printArray(arr1);
                ArrayUtil.printArray(arr2);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
