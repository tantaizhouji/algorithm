package com.yangqihang;


public class EvenTimesOddTimes {

    /**
     * arr中,有两种数出现奇数次,求这两种数
     *
     * @param arr
     */
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; // eor异或数组中每个数,偶数个的数会请除掉
        }
        // 最终eor = a^b,且ero!=0,eor其中某位上一定是1
        int rightOne = eor & (~eor + 1); // 此操作可以获得二进制最右边为1的位置标示的数
        int onlyOne = 0; // eor'用来存a,b其中一个
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                // 选出数组中在rightOne位置为1的数
                onlyOne ^= arr[i]; // 获取2个奇数次数的其中一个数
            }
        }

        System.out.println("One Odd is: " + onlyOne + " Another one Odd is: " + (eor ^ onlyOne));
    }
}
