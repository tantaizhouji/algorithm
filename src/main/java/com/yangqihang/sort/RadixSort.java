package com.yangqihang.sort;

import java.util.Arrays;

/**
 * 基数排序
 * 桶排序的一种
 */
public class RadixSort {

    /**
     * 只适用于非负正整数
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    /**
     * 在数组得left和right进行基数排序
     *
     * @param arr   数组
     * @param left  左边界
     * @param right 右边界
     * @param digit 位数
     */
    private static void radixSort(int[] arr, int left, int right, int digit) {
        // 以10为底
        final int radix = 10;
        int i, j;
        // 辅助数组,和要排序的数组等长
        int[] help = new int[right - left + 1];
        for (int d = 1; d <= digit; d++) {
            // 从个位开始排序,直到最高位
            // 用来记录当前位的数字的个数
            int[] count = new int[radix];
            for (i = left; i <= right; i++) {
                // 获取当前位的值
                j = getDigit(arr[i], d);
                // 当前位对应的count数组+1
                count[j]++;
            }
            for (i = 1; i < radix; i++)
                // 修改count数组,变为记录<=当前位置的总数
                count[i] = count[i] + count[i - 1];
            for (i = right; i >= left; i--) {
                // 从右往左获取数组中的元素
                // 获取元素的当前位的值
                j = getDigit(arr[i], d);
                // 找到对应位置放入到help数组中
                help[count[j] - 1] = arr[i];
                // 当前位记录的总数-1
                count[j]--;
            }
            for (i = left; i <= right; i++)
                // 更新数组
                arr[i] = help[i];
        }
    }

    /**
     * 计算正整数数组中的最大位数
     *
     * @param arr
     * @return
     */
    private static int maxBits(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            // 获取数组中的最大值
            max = Math.max(max, arr[i]);
        }
        // 位数记录,初始为0
        int bits = 0;
        while (max != 0) {
            // max不为0,位数+1
            bits++;
            // max去掉最低位
            max /= 10;
        }
        return bits;
    }

    /**
     * 从给定值获取指定位的值
     *
     * @param value 给定值
     * @param digit 指定的位
     * @return
     */
    private static int getDigit(int value, int digit) {
        return ((value / (int) Math.pow(10, digit - 1)) % 10);
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            radixSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
