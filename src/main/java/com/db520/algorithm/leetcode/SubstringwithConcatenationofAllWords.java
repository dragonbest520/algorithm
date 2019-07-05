package com.db520.algorithm.leetcode;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that
 * is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * @Description SubstringwithConcatenationofAllWords
 * @Author zhuyl
 * @Date 2019/7/2 11:24
 **/
public class SubstringwithConcatenationofAllWords {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        //String s = "barfoobarthefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(new SubstringwithConcatenationofAllWords().findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        // 用于记录词表中每个词的数目
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            int cnt = wordCount.getOrDefault(word, 0);
            wordCount.put(word, cnt + 1);
        }

        // 用于记录每个词的长度，所有词长度一样
        int len = words[0].length();

        for (int i = 0; i < len; i++) {
            // 用于记录当前已匹配到词表中的各个词的个数, 当作一个滑动窗口的作用
            Map<String, Integer> curWordCount = new HashMap<>();
            // 记录移动窗口的起始位置
            int start = i;
            // 记录已匹配词的个数
            int count = 0;
            for (int j = i; j <= s.length() - len; j += len) {
                String curWord = s.substring(j, j + len);

                // 表示当前词不在词表中，清空窗口，重新开始
                if (!wordCount.containsKey(curWord)) {
                    curWordCount.clear();
                    count = 0;
                    start = j + len;
                    continue;
                }

                int curCnt = curWordCount.getOrDefault(curWord, 0);
                curWordCount.put(curWord, curCnt + 1);
                count++;

                // 如果当前的词多匹配了，此时需要不断将最左边的词清理出去，直到当前词的数目满足条件
                while (curWordCount.get(curWord) > wordCount.get(curWord)) {
                    String leftWord = s.substring(start, start + len);
                    curWordCount.put(leftWord, curWordCount.get(leftWord) - 1);
                    count--;
                    start += len;
                }

                // 表示一次匹配成功，存入结果中
                if (count == words.length) {
                    result.add(start);
                    String lefWord = s.substring(start, start + len);
                    curWordCount.put(lefWord, curWordCount.get(lefWord) - 1);
                    count--;
                    start += len;
                }
            }
        }
        return result;
    }

}
