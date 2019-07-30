package com.db520.algorithm.leetcode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * @Description MaxPointsonaLine
 * @Author zhuyl
 * @Date 2019/7/23 10:09
 **/
public class MaxPointsonaLine {

    public static void main(String[] args) {
        //int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        //int[][] points = {{0, 0}, {1, 1}, {0, 0}};
        int[][] points = {{1, 1}, {1, 1}, {1, 1}};
        //int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        //int[][] points = {{0,0},{94911151,94911150},{94911152,94911151}};
        System.out.println(new MaxPointsonaLine().maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        if(points.length <= 2) {
            return points.length;
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Long, Integer> map = new HashMap<>();
            int samex = 1;
            int samexy = 0;

            for (int j = 0; j < points.length; j++) {
                if(j != i) {
                    if(points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
                        samexy++;
                    }
                    if(points[j][0] == points[i][0]) {
                        samex++;
                        continue;
                    }
                    int gcd = getGcd(points[j][0] - points[i][0], points[j][1] - points[i][1]);
                    long k = ((long)((points[j][1] - points[i][1]) / gcd) << 32) + ((points[j][0] - points[i][0]) / gcd);
                    if(map.containsKey(k)) {
                        map.put(k, map.get(k) + 1);
                    } else {
                        map.put(k, 2);
                    }
                    result = Math.max(result, map.get(k) + samexy);
                }
            }
            result = Math.max(result, samex);
        }

        return result;
    }

    int getGcd(int a, int b) {
        return b == 0 ? a : getGcd(b, a % b);
    }

    //too slow
    public int maxPoints2(int[][] points) {
        if(points.length <= 2) {
            return points.length;
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<BigDecimal, Integer> map = new HashMap<>();
            int samex = 1;
            int samexy = 0;

            for (int j = 0; j < points.length; j++) {
                if(j != i) {
                    if(points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
                        samexy++;
                    }
                    if(points[j][0] == points[i][0]) {
                        samex++;
                        continue;
                    }
                    //这里是考虑到了Java的Double的精度问题，所以才是用BigDecimal的问题
                    BigDecimal fenziBigDecimal=new BigDecimal(points[i][1]-points[j][1]);
                    BigDecimal fenmuBigDecimal=new BigDecimal(points[i][0]-points[j][0]);
                    BigDecimal k = fenziBigDecimal.divide(fenmuBigDecimal,20, BigDecimal.ROUND_HALF_DOWN);
                    if(map.containsKey(k)) {
                        map.put(k, map.get(k) + 1);
                    } else {
                        map.put(k, 2);
                    }
                    result = Math.max(result, map.get(k) + samexy);
                }
            }
            result = Math.max(result, samex);
        }

        return result;
    }
}
