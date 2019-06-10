package com.db520.algorithm.leetcode;

/**
 * 134. Gas Station
 *
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 *
 * Note:
 *
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 *
 * @author zhuyl
 * @version 2019-06-06
 */
public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int gasTotal = 0;
            boolean flag = true;
            for (int j = i; j < i + gas.length && flag == true; j++) {
                int index = j;
                if(j >= gas.length) {
                    index = j - gas.length;
                }
                if(gasTotal + gas[index] >= cost[index]) {
                    gasTotal = gasTotal + gas[index] - cost[index];
                } else {
                    flag = false;
                }
            }
            if(flag) {
                return i;
            }
        }
        return -1;
    }


    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int start = 0;
        int remain = 0;
        int debt = 0;

        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if(remain < 0) {
                debt += remain;
                start = i + 1;
                remain = 0;
            }

        }
        return remain + debt >= 0 ? start : -1;
    }
}
