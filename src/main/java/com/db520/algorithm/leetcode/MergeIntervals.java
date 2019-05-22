package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 56. Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * @author zhuyl
 * @version 2019-05-22
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals2 = {{1,4},{0,4}};
        int[][] intervals3 = {{1,4},{0,2},{3,5}};
        int[][] intervals4 = {{4,5},{1,4},{0,1}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(intervals4)));
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }

        // 先排序
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - i - 1; j++) {
                if(intervals[j][0] > intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }

        List<int[]> templist = Arrays.asList(intervals);
        List<int[]> list = new ArrayList(templist);
        int lastNum = list.get(0)[1];
        int nextIndex = 1;
        int index = 0;
        while (index < list.size() && nextIndex < list.size()) {
            if(list.get(index)[1] >= list.get(nextIndex)[1]) {
                list.remove(list.get(nextIndex));
            } else if (list.get(index)[1] < list.get(nextIndex)[1] && list.get(index)[1] >= list.get(nextIndex)[0]) {
                list.get(index)[1] = list.get(nextIndex)[1];
                list.remove(list.get(nextIndex));
            } else {
                index++;
                nextIndex++;
            }
        }

        int[][] newArray = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            newArray[i] = list.get(i);
        }
        return newArray;
    }
}
