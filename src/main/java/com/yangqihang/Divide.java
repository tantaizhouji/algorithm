package com.yangqihang;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor.将两数相除，要求不使用乘法、除法和 mod 运算符.
 * 返回被除数 dividend 除以除数 divisor 得到的商
 * 整数除法的结果应当截去其小数部分
 */
public class Divide {

    /**
     * 递减除数,慢
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        // 结果值,初始为0
        int result;

        if (divisor == 0) {
            throw new ArithmeticException("/ by zero"); // 如果除数为0,抛出异常
        }
        if (dividend == 0) {
            return 0; // 被除数为0,直接返回结果0
        }
        if (divisor == 1) {
            return dividend; // 除数为1,返回被除数
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE; // 除数为-1,被除数为int最小值,相反数超出int界限,返回int最大数
            }

            return -dividend; // 除数为-1,返回被除数相反数
        }

        if (dividend > 0) {
            // 被除数是正数

            if (divisor > 0) {
                // 被除数,除数都大于0

                int sum = 0; // 存放累计和
                for (int i = 1; ; i++) {
                    // i表示除数累加的次数,从1开始,带符号

                    sum += divisor; // 累加
                    int diff = dividend - sum; // 累加和与被除数的差值
                    if (diff < 0) {
                        return i - 1; // 差小于0,需要返回上一次的次数
                    }
                    if (diff < divisor) {
                        return i; // 差值小于除数,返回累加的次数
                    }
                }

            } else {
                // 被除数大于0,除数小于0

                int sum = 0; // 存放累加和
                for (int i = -1; ; i--) {
                    // i表示除数累加的次数,由于除数小于0,次数也要带符号,从-1开始

                    sum -= divisor; // 除数小于0,需要变换符号
                    int diff = dividend - sum;
                    if (diff < 0) {
                        return i - (-1); // 差值小于0,需要返回上一步的次数
                    }
                    if (diff < -divisor) {
                        return i; // 差值小于除数的相反数,返回累加的次数
                    }
                }

            }

        } else {
            // 被除数是负数

            if (divisor > 0) {
                // 被除数是负数,除数是正数

                int sum = 0;
                for (int i = -1; ; i--) {

                    sum += divisor; // 累加和
                    int diff = dividend + sum;
                    if (diff > 0) {
                        result = i + 1;
                        break;
                    }
                    if (-diff < divisor) {
                        result = i;
                        break;
                    }

                }

            } else {
                // 被除数是负数,除数是负数

                int sum = 0;
                for (int i = 1; ; i++) {
                    sum += divisor;
                    int diff = dividend - sum;
                    if (diff > 0) {
                        result = i - 1;
                        break;
                    }
                    if (diff > divisor) {
                        result = i;
                        break;
                    }
                }

            }
        }

        return result;
    }

}
