package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 71. Simplify Path
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 *
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 *
 * @author zhuyl
 * @version 2019-05-28
 */
public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/home/";
        String path2 = "/a//b////c/d//././/..";
        String path3 = "/a/../../b/../c//.//";
        String path4 = "/...";
        String path5 = "/.";
        String path6 = "/../";
        String path7 = "/..";
        String path8 = "/.....hidden";
        System.out.println(new SimplifyPath().simplifyPath(path8));
    }

    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] p = path.split("/");
        for (String t : p) {
            if (!s.isEmpty() && t.equals("..")) {
                s.pop();
            } else if (!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> list = new ArrayList(s);
        return "/" + String.join("/", list);
    }


}
