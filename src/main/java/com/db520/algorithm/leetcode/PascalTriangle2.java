package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * @Author zhuyl
 * @Version 2019-04-22
 */
public class PascalTriangle2 {

    public static void main(String[] args) {
        List<Integer> list = new PascalTriangle2().getRow2(4);
        System.out.println(list);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0) {
            return list;
        }
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> addedList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    addedList.add(1);
                } else {
                    addedList.add(list.get(j - 1) + list.get(j));
                }
            }
            list = addedList;
        }
        return list;
    }

    public List<Integer> getRowRecursion(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if(rowIndex == 0) {
            list.add(1);
            return list;
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            if(i == 0 || i == rowIndex) {
                list.add(1);
            } else {
                list.add(getRowRecursion(rowIndex - 1).get(i - 1) + getRowRecursion(rowIndex - 1).get(i));
            }
        }
        return list;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0) {
            return list;
        }
        for (int i = 0; i < rowIndex; i++) {
            list.add(0);
        }
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j < rowIndex; j++) {
                list.set(rowIndex - j, list.get(rowIndex - j) + list.get(rowIndex - j - 1));
            }
        }
        return list;
    }
}
