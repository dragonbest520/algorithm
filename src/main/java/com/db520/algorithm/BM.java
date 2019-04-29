package com.db520.algorithm;

/**
 * @author zhuyl
 * @version 2019-04-29
 */
public class BM {

    public static int pattern(String pattern, String target) {
        int tLength = target.length();
        int pLength = pattern.length();


        if(pattern.equals("")) {
            return 0;
        }

        if(pattern.length() > target.length()) {
            return -1;
        }

        int[] bad_table = build_bad_table(pattern);
        int[] good_table = build_good_table(pattern);

        for (int i = pLength - 1, j; i < tLength;) {
            for (j = pLength - 1; target.charAt(i) == pattern.charAt(j); i--, j--) {
                if(j == 0) {
                    return i;
                }
            }
            i += Math.max(good_table[pLength - j - 1], bad_table[target.charAt(i)]);
        }
        return -1;
    }

    public static int[] build_bad_table(String pattern) {
        final int table_size = 256;
        int[] bad_table = new int[table_size];
        int pLen = pattern.length();

        for (int i = 0; i < bad_table.length; i++) {
            bad_table[i] = pLen;
        }
        for (int i = 0; i < pLen - 1; i++) {
            int k = pattern.charAt(i);
            bad_table[k] = pLen - 1 - i;
        }
        return bad_table;
    }

    /**
     * 匹配偏移表。
     *
     * @param pattern
     *            模式串
     * @return
     */
    public static int[] build_good_table(String pattern) {
        int pLen = pattern.length();
        int[] good_table = new int[pLen];
        int lastPrefixPosition = pLen;

        for (int i = pLen - 1; i >= 0; --i) {
            if (isPrefix(pattern, i + 1)) {
                lastPrefixPosition = i + 1;
            }
            good_table[pLen - 1 - i] = lastPrefixPosition - i + pLen - 1;
        }

        for (int i = 0; i < pLen - 1; ++i) {
            int slen = suffixLength(pattern, i);
            good_table[slen] = pLen - 1 - i + slen;
        }
        return good_table;
    }

    /**
     * 前缀匹配
     */
    private static boolean isPrefix(String pattern, int p) {
        int patternLength = pattern.length();
        for (int i = p, j = 0; i < patternLength; ++i, ++j) {
            if (pattern.charAt(i) != pattern.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 后缀匹配
     */
    private static int suffixLength(String pattern, int p) {
        int pLen = pattern.length();
        int len = 0;
        for (int i = p, j = pLen - 1; i >= 0 && pattern.charAt(i) == pattern.charAt(j); i--, j--) {
            len += 1;
        }
        return len;
    }

}
