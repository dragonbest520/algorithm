package com.db520.algorithm.leetcode;

/**
 * 58. Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * @author zhuyl
 * @version 2019-05-28
 */
public class LengthofLastWord {

    public static void main(String[] args) {
        String s = "Hello World";
        String s2 = " ";
        String s3 = "a";
        System.out.println(new LengthofLastWord().lengthOfLastWord(s3));
    }


    public int lengthOfLastWord(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int start = -1;
        int end = -1;
        int i = s.length() - 1;

        boolean wordStart = false;
        while(i >= 0) {
            if(s.charAt(i) == ' ') {
                if(wordStart == false) {
                } else {
                    start = i;
                    break;
                }
            } else {
                if(wordStart == false) {
                    end = i;
                    wordStart = true;
                }
            }
            i--;
        }

        return end -start;
    }
}
