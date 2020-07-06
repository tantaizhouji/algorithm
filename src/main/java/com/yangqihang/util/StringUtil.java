package com.yangqihang.util;

/**
 * String字符串工具类
 */
public final class StringUtil {
    private StringUtil() {
    }

    /**
     * 将给定字符串进行驼峰命名转换
     * 将 '_'字符去除,且 '_'字符右边的字符一定转换为大写字母
     * 例: my_hobby -> myHobby, My_hobby -> MyHobby, my_Hobby -> myHobby -> my___hobby -> myHobby
     *
     * @param s
     * @return
     */
    public static String humpName(String s) {
        if (s != null) {
            String[] split = s.split("_"); // 按照'_'切割字符串
            StringBuilder stringBuilder = new StringBuilder(split[0]); // 将头串直接放入到字符串构建器中
            for (int i = 1; i < split.length; i++) {
                // 遍历剩下的子字符串

                if (!split[i].isEmpty()) {
                    // 子串不为空

                    // 构建器添加,子串第一个字符大写,剩余字符不变的字符串
                    stringBuilder.append(split[i].substring(0, 1).toUpperCase()).append(split[i], 1, split[i].length());
                }
            }

            // 返回
            s = stringBuilder.toString();
        }

        return s;
    }
}
