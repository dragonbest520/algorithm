package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code
 *
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * @author zhuyl
 * @version 2019-06-13
 */
public class GrayCode {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new GrayCode().grayCode5(n));
    }


    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if(n == 0) {
            return list;
        }
        dfs(0, n, list);
        return list;
    }

    public void dfs(int start, int n, List<Integer> list) {
        if(list.size() == Math.pow(2, n)) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int temp = (int)Math.pow(2, i) ^ start;
            if(!list.contains(temp)) {
                list.add(temp);
                dfs(temp, n, list);
                break;
            }
        }
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if(n == 0) {
            return list;
        }

        int start = 0;
        for (int i = 0; i < n && list.size() < Math.pow(2, n); i++) {
            int temp = (int)Math.pow(2, i) ^ start;
            if(!list.contains(temp)) {
                list.add(temp);
                start = temp;
                i = -1;
            }
        }

        return list;
    }


    public List<Integer> grayCode3(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if(n == 0) {
            return list;
        }

        for (int i = 0; i < n; i++) {
            List<Integer> newList = new ArrayList<>();
            for(Integer num : list) {
                newList.add(0,(1<<i) ^ num);
            }
            list.addAll(newList);
        }

        return list;
    }

    public List<Integer> grayCode4(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        System.out.println(1<<n);
        for(int i = 0 ; i < 1<<n ; i++) {
            int temp = i>>1;
            gray.add(i^temp);
        }
        return gray;
    }

    public List<Integer> grayCode5(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if(n == 0) {
            return list;
        }
        for(int i = 1 ; i < 1<<n ; i++) {
            list.add((1<<cal2(i)) ^ list.get(cal(i)));
        }
        return list;
    }

    public int cal(int i) {
        i = i + 1;
        int origin = i;
        int tmp = -1;
        while(i > 0) {
            i = i >> 1;
            tmp++;
        }
        if((1 << tmp) == origin) {
            return 0;
        } else {
            int result = (1 << tmp) - origin + (1 << tmp);
            return result;
        }
    }

    //大于i的最小2的幂次方
    public int cal2(int i) {
        int tmp = -1;
        while(i > 0) {
            i = i >> 1;
            tmp++;
        }
        return tmp;
    }
}
