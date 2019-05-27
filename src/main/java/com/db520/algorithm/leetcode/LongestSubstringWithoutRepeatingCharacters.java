package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * @author zhuyl
 * @version 2019-05-27
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = " ";
        String s3 = "au";
        String s4 = "pwwkew";
        String s5 = "abba";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2(s4));
    }


    public int lengthOfLongestSubstring(String s) {

        int count = 0;
        List<Character> listTemp = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(listTemp.contains(s.charAt(j))) {
                    count = Math.max(count, listTemp.size());
                    break;
                } else {
                    listTemp.add(s.charAt(j));
                    count = Math.max(count, listTemp.size());
                }
            }
            listTemp.clear();
        }

        return count;
    }


    public int lengthOfLongestSubstring2(String s) {
        if(s.length() < 1) {
            return s.length();
        }

        int count = 1;
        int i = 0;
        int j = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(i), i);
        while(j < s.length()) {
            if(map.containsKey(s.charAt(j))) {
                map.remove(s.charAt(i++));
            } else {
                map.put(s.charAt(j), j);
                j++;
                count = Math.max(count, j - i );
            }
        }
        return count;
    }
}
