package com.yangqihang.generate;

/**
 * 生产工具类,有各种生成器
 */
public final class GenerateUtil {
    private GenerateUtil() {
    }

    /**
     * 随机数组生成器
     *
     * @param maxSize  数组最大长度
     * @param maxValue 数组元素最大值
     * @return 随机数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {

        // Math.random() [0,1) 等概率产生之间的小数
        // Math.random() * N [0,N)
        // (int)(Math.random() * N) [0,N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // 一个随机值减另外一个随机值
            arr[i] = (int) (((maxSize + 1) * Math.random()) - ((maxSize) * Math.random()));
        }
        return arr;
    }
}
