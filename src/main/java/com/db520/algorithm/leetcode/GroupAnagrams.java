package com.db520.algorithm.leetcode;

import java.util.*;

/**
 * 49. Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 *
 * @author zhuyl
 * @version 2019-05-28
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {"", ""};
        System.out.println(new GroupAnagrams().groupAnagrams(strs2));
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        if(strs.length == 0) {
            return resultList;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chs = strs[i].toCharArray();
            bubbleSort(chs);

            String result = new String(chs);
            if(map.containsKey(result)) {
                map.get(result).add(strs[i]);
            } else {
                List tempList = new ArrayList();
                tempList.add(strs[i]);
                map.put(result, tempList);
                resultList.add(tempList);
            }
        }

        return resultList;
    }

    public static void bubbleSort(char[] chs) {
        for (int x = 0; x < chs.length - 1; x++) {
            for (int y = 0; y < chs.length - 1 - x; y++) {
                if (chs[y] > chs[y + 1]) {
                    char ch = chs[y];
                    chs[y] = chs[y + 1];
                    chs[y + 1] = ch;
                }
            }
        }
    }
}
