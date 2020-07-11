package com.yangqihang;

/**
 * 快排基础
 * partition
 */
public class Partition {

    /**
     * 在arr[left ... right]玩荷兰国旗问题的划分,以arr[right]做划分值
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int[] netherlandsFlag(int[] arr, int left, int right) {
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

    /**
     * 交换数组中 i, j 两位置的值
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
