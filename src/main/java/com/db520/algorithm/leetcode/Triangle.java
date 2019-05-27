package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. Triangle
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * @author zhuyl
 * @version 2019-05-27
 */
public class Triangle {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(new Triangle().minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        int[] min = new int[N];
        List<Integer> lastRow = triangle.get(N - 1);
        for(int i = 0; i < N; i++)
            min[i] = lastRow.get(i);

        for(int row = N - 2; row >= 0; row--){
            List<Integer> currentRow = triangle.get(row);
            for(int i = 0; i < row + 1; i++){
                min[i] = currentRow.get(i) + Math.min(min[i], min[i+1]);
            }
        }
        return min[0];
    }

//    public int minimumTotal(List<List<Integer>> triangle) {
//        int min = minimum(triangle, 0, 0);
//        return min;
//    }
//
//    public int minimum(List<List<Integer>> triangle, int level, int index) {
//        int min = triangle.get(level).get(index);
//        if(level != triangle.size() - 1) {
//            min += Math.min(minimum(triangle, level + 1, index), minimum(triangle, level + 1, index + 1));
//        }
//        return min;
//    }


}
