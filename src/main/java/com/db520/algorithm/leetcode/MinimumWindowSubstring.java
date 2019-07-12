package com.db520.algorithm.leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * @Description MinimumWindowSubstring
 * @Author zhuyl
 * @Date 2019/7/12 9:09
 **/
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        //String s = "ADOBECODEBANC";
        //String t = "ABC";
        String s = "aa";
        String t = "aa";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        //hashmap来统计t字符串中各个字母需要出现的次数
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put( c, map.containsKey(c) ? map.get(c)+1 : 1);
        //用来计数 判断当前子字符串中是否包含了t中全部字符
        int count = 0;
        //记录当前子字符串的左右下标值
        int left = 0;
        int right = 0;
        //记录当前最小子字符串的大小以及第一最后字符的下标值
        int min = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        for (; right < s.length() ; right++) {
            char temp = s.charAt(right);
            if (map.containsKey(temp)){//向后遍历出所包含t的字符串
                count = map.get(temp) > 0 ? count+1 : count;
                map.put(temp,map.get(temp)-1);
            }
            while (count == t.length()){//得出一个符合条件的子字符串
                if (right-left < min){//更新min minLeft minRight 信息
                    min = right - left;
                    minLeft = left;
                    minRight = right;
                }
                char c = s.charAt(left);
                if (map.containsKey(c)){//向左收缩 判断所删减的字符是否在map中
                    if (map.get(c) >= 0)count --;//count--时需要判断一下是否需要--
                    map.put(c,map.get(c)+1);
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ?  "" : s.substring(minLeft,minRight+1);
    }

    //error
    public String minWindow2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int flag = 0;
        int min = -1;
        String result = "";
        for (int i = 0; i < t.length(); i++) {
            map.putIfAbsent(t.charAt(i), -1);
            flag += -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                int val = map.get(s.charAt(i));
                if(val == -1) {
                    flag += 1;
                }
                map.put(s.charAt(i), i);
                if(flag >= 0) {
                    int start = getMinValue(map);
                    if(min == -1) {
                        result = s.substring(start, i +1);
                        min = i - start;
                    } else {
                        if(i - start < min) {
                            result = s.substring(start, i + 1);
                            min = i - start;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static Integer getMinValue(Map<Character, Integer> map) {
        if (map == null) return null;
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return (Integer)obj[0];
    }
}
