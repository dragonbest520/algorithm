package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *  Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *  For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * @Description TextJustification
 * @Author zhuyl
 * @Date 2019/7/12 9:06
 **/
public class TextJustification {

    public static void main(String[] args) {
        /*String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;*/
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        /*String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;*/
        System.out.println(new TextJustification().fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> resultList = new ArrayList<>();
        helper(words, 0, maxWidth, resultList);
        return resultList;
    }

    private void helper(String[] words, int start, int maxWidth, List<String> resultList) {
        if(start >= words.length) {
            return;
        }

        int count = 0;
        int totalLength = 0;
        String temp = "";
        while(start + count < words.length && totalLength + words[start + count].length() <= maxWidth) {
            totalLength += words[start + count].length() + 1;
            count++;
        }
        if(count == 1) {
            int len = maxWidth - words[start].length();
            temp = words[start];
            for (int i = 0; i < len; i++) {
                temp += " ";
            }
        } else if(count + start == words.length) {
            int len = maxWidth - totalLength + 1;
            for (int j = 0; j < count; j++) {
                temp += words[start + j];
                if(j != count - 1) {
                    temp += " ";
                }
            }
            for (int i = 0; i < len; i++) {
                temp += " ";
            }
        } else {
            int len = maxWidth - totalLength + count;
            int len1 = len / (count - 1);
            int len2 = len - len1 * (count - 1);
            for (int j = 0; j < count; j++) {
                temp += words[start + j];
                if(j != count - 1) {
                    for (int i = 0; i < len1; i++) {
                        temp += " ";
                    }
                    if(len2 > 0) {
                        temp += " ";
                        len2--;
                    }
                }
            }
        }
        resultList.add(temp);
        helper(words,  count + start, maxWidth, resultList);
    }
}
