package com.github.supermoonie.util;

/**
 * @author supermoonie
 * @date 2018/11/29
 */
public final class StringUtils {

    private StringUtils() {

    }

    public static boolean isEmpty(String str) {
        return null == str || str.length() == 0 || "".equals(str.trim());
    }

    public static boolean isAnyEmpty(String... strings) {
        for (String str : strings) {
            if (isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAllEmpty(String... strings) {
        for (String str : strings) {
            if (!isEmpty(str)) {
                return false;
            }
        }
        return true;
    }
}
