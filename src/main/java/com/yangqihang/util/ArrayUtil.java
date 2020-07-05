package com.yangqihang.util;

/**
 * 数组工具类
 */
public final class ArrayUtil {

    private ArrayUtil() {
    }

    /**
     * 使用二分法判断数组中是否存在指定的数
     * 技巧:
     * (L + R)/2 可能会越界,例如L=10亿,R=18亿,(L+R)就会越界
     * 改进 L + (R - L)/2 ,前提,R > L
     * 更快 L + ((R - L)>>1)
     * N * 2 -> N << 1
     * N * 2 + 1 -> ((N << 1) | 1)
     *
     * @param sortedArr
     * @param num
     * @return
     */
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0; // 左边界,初始为0
        int R = sortedArr.length - 1; // 右边界,初始为数组最后一个元素的索引
        int mid = 0; // 初始中间位置
        while (L < R) { // 左边界小于右边界,循环
            mid = L + ((R - L) >> 1); // 中间位置
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1; // 中间位置大于指定数,更新右边界为mid前一位
            } else {
                L = mid + 1; // 中间位置小于于指定数,更新右边界为mid后一位
            }
        }
        return sortedArr[mid] == num; // 循环结束后,最终位置是否为指定数字
    }

    /**
     * 拷贝数组
     *
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

        return result;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
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

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }

        }
    }

}
