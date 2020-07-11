package com.yangqihang;

/**
 * 在一个数组中,一个数的左边比它的小的数的总和,叫做数的小和,所有有数的小和累加起来,叫数组小和,求数组小和
 */
public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0; // 只有一个数,没有小和
        }
        int mid = left + ((right - left) >> 1);
        int leftSum = process(arr, left, mid); // 左组的小和
        int rightSum = process(arr, mid + 1, right); // 右组的小和
        return leftSum + rightSum + merge(arr, left, mid, right); // 合并之后的总小和
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int sum = 0; // 最小和
        int pl = left;
        int pr = mid + 1;
        int i = 0;
        while (pl <= mid && pr <= right) {
            if (arr[pl] < arr[pr]) { // 左组的元素小于右组的元素
                sum += arr[pl] * (right - pr + 1); // 小和加上佐助元素*右组元素的个数,将左组元素放入到help中
            }
            help[i++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++]; // 左组小的放入到help中,不小的右组放入help中
        }
        while (pl <= mid) {
            help[i++] = arr[pl++];
        }
        while (pr <= right) {
            help[i++] = arr[pr++];
        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 7, 4, 3};
        System.out.println(smallSum(arr));
    }
}
