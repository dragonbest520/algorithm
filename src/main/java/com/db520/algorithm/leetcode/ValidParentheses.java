package com.db520.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * @Author zhuyl
 * @Version 2019-04-25
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "([)]";
        String s2 = "{[]}";
        System.out.println(new ValidParentheses().isValid2(s2));
    }

    public boolean isValid(String s) {
        if(s.length() == 0) {
            return true;
        }
        if(s.charAt(0) == ']' || s.charAt(0) == ')' || s.charAt(0) == '}') {
            return false;
        }
        List<Character> list = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                list.add(s.charAt(i));
            }
            if(s.charAt(i) == ')') {
                if(list.size() == 0 || list.get(list.size() - 1) != '(') {
                    return false;
                } else {
                    list.remove(list.size() - 1);
                }
            }
            if(s.charAt(i) == '}') {
                if(list.size() == 0 || list.get(list.size() - 1) != '{') {
                    return false;
                } else {
                    list.remove(list.size() - 1);
                }
            }
            if(s.charAt(i) == ']') {
                if(list.size() == 0 || list.get(list.size() - 1) != '[') {
                    return false;
                } else {
                    list.remove(list.size() - 1);
                }
            }
        }
        if(list.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValid2(String s) {
        if(s.length() == 0) {
            return true;
        }
        if(s.charAt(0) == ']' || s.charAt(0) == ')' || s.charAt(0) == '}') {
            return false;
        }
        Stack<Character> list = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                list.add(s.charAt(i));
            }
            if(s.charAt(i) == ')') {
                if(list.size() == 0 || list.pop() != '(') {
                    return false;
                }
            }
            if(s.charAt(i) == '}') {
                if(list.size() == 0 || list.pop() != '{') {
                    return false;
                }
            }
            if(s.charAt(i) == ']') {
                if(list.size() == 0 || list.pop() != '[') {
                    return false;
                }
            }
        }
        if(list.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
