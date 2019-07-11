package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. Insert Interval
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * @Description InsertInterval
 * @Author zhuyl
 * @Date 2019/7/9 11:31
 **/
public class InsertInterval {

    public static void main(String[] args) {
        //int[][] intervals = {{1, 3}, {6, 9}};
        //int[] newInterval = {2, 5};
        //int[][] intervals = {};
        //int[] newInterval = {5, 7};
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};
        System.out.println(Arrays.deepToString(new InsertInterval().insert(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList(intervals.length + 1);
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // add the union of intervals we got
        result.add(newInterval);
        // add all the rest
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }
        int[][] newArray = new int[result.size()][2];
        for (int j = 0; j < result.size(); j++) {
            newArray[j] = result.get(j);
        }
        return newArray;
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        int p = 0;
        boolean flag = false;
        for (int i = 0; i <= intervals.length; i++) {
            if(intervals.length == 0) {
                newIntervals[i] = newInterval;
                return newIntervals;
            }

            if(flag == false && (i == intervals.length || (i < intervals.length && newInterval[0] < intervals[i][0]))) {
                newIntervals[i] = newInterval;
                p = -1;
                flag = true;
                i++;
                if(i > intervals.length) {
                    break;
                }
            }
            newIntervals[i] = intervals[i + p];
        }
        int[][] result = merge(newIntervals);
        return result;
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }

        // 先排序
        /*for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - i - 1; j++) {
                if(intervals[j][0] > intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }*/

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
