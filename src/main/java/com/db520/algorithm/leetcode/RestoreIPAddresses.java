package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * @author zhuyl
 * @version 2019-05-30
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(new RestoreIPAddresses().restoreIpAddresses(s));
    }


    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) {
            return list;
        }
        dfs(s, "", list, 0);
        return list;
    }

    public void dfs(String s, String temp, List<String> list, int count) {
        if(count == 3 && isValid(s)) {
            list.add(temp + s);
            return;
        }
        for (int i = 1; i < 4 && i < s.length(); i++) {
            String subStr = s.substring(0, i);
            if(isValid(subStr)) {
                dfs(s.substring(i), temp + subStr + '.', list, count + 1);
            }
        }
    }

    public boolean isValid(String s) {
        if(s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        return num <= 255 && num > 0;
    }
}
