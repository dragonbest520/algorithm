package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * @Author zhuyl
 * @Version 2019-04-22
 */
public class PascalTriangle {

    public static void main(String[] args) {
        List<List<Integer>> list = new PascalTriangle().generate(5);
        for(List<Integer> integerList : list) {
            System.out.println(integerList);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows == 0) {
            return list;
        }
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        list.add(firstList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> addedList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    addedList.add(1);
                } else {
                    addedList.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(addedList);

        }
        return list;
    }
}
