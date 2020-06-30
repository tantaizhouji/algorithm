package com.yangqihang;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor.将两数相除，要求不使用乘法、除法和 mod 运算符.
 * 返回被除数 dividend 除以除数 divisor 得到的商
 * 整数除法的结果应当截去其小数部分
 */
public class Divide {

    public static int divide(int dividend, int divisor) {
        // 结果值,初始为0
        int result = 0;

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
        if (dividend == divisor) {
            return 1; // 被除数等于除数,返回1
        }

        if (dividend > 0) {
            // 被除数是正数

            if (divisor > 0) {
                // 被除数,除数都大于0

                if (dividend < divisor) {
                    return 0; // 被除数小于除数,返回0
                }

                int sum = 0; // 存放累计和
                for (int i = 0; ; i++) {
                    sum += divisor;
                    if (sum == dividend) {
                        result = i+1;
                        break;
                    }
                    if (sum > dividend) {
                        result = i;
                        break;
                    }
                }

            } else {
                // 被除数大于0,除数小于0

                if (divisor == Integer.MIN_VALUE) {
                    return 0; // 除数是int最小值,直接返回0
                }

                divisor = -divisor; // 将负数转换成正数
                if (dividend < divisor) {
                    return 0; // 被除数相反数大于除数
                }

                for (int i = 0; ; i++) {

                    int sum = 0;
                    int j = 0;
                    for (; j < divisor; j++) {
                        sum += i;
                    }

                    if (sum == dividend || ((sum < dividend) && ((sum + i) > dividend))) {
                        result = -i;
                        break;
                    }
                }

            }

        } else {
            // 被除数是负数

            if (divisor > 0) {
                // 被除数是负数,除数是正数

                if (dividend > -divisor) {
                    return 0; // 除数的相反数小于被除数,返回0
                }

                for (int i = 0; ; i--) {

                    int sum = 0;
                    int j = 0;
                    for (; j < divisor; j++) {
                        sum += i;
                    }

                    if (sum == dividend || ((sum > dividend) && ((sum + i) < dividend))) {
                        result = i;
                        break;
                    }
                }

            } else {
                // 被除数是负数,除数是负数

                if (divisor == Integer.MIN_VALUE) {
                    return 0; // 除数为int最小值,返回0
                }
                if (dividend > dividend) {
                    return 0; // 被除数大于除数,返回0
                }

                divisor = -divisor;
                for (int i = 0; ; i--) {

                    int sum = 0;
                    int j = 0;
                    for (; j < divisor; j++) {
                        sum += i;
                    }

                    if (sum == dividend || ((sum > dividend) && ((sum + i) < dividend))) {
                        result = -i; // 返回基数的绝对值
                        break;
                    }
                }
            }
        }

        return result;
    }

}
