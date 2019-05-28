package com.db520.algorithm.leetcode;

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
        System.out.println(new SimplifyPath().simplifyPath(path));
    }


    public String simplifyPath(String path) {
        return "";
    }
}
