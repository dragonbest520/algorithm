package com.db520.algorithm.leetcode;

/**
 * 41. First Missing Positive
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * @Description FirstMissingPositive
 * @Author zhuyl
 * @Date 2019/7/6 14:27
 **/
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
        int[] nums2 = {1,2,0};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums2));
    }

    //时间复杂度O(n)
    public int firstMissingPositive2(int[] nums) {
        if(nums.length == 0)
            return 1;
        //第i位存放i+1的数值
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > 0){//nums[i]为正数，放在i+1位置
                //假设交换的数据还是大于0且<i+1，则放在合适的位置,且数据不相等，避免死循环
                //这个while是关键，其它都是没有难度的
                while(nums[i] > 0 && nums[i] < i+1 && nums[i] != nums[nums[i] -1]){
                    int temp = nums[nums[i]-1];//交换数据
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        //循环寻找不符合要求的数据，返回
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        //假设都符合要求，则返回长度+1的值
        return nums.length + 1;
    }

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 1;
        }
        if(nums.length == 1) {
            if(nums[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }
        bubbleSort(nums);
        int res = -1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) {
                continue;
            } else {
                if(!flag) {
                    if(nums[i] != 1) {
                        return 1;
                    } else {
                        res = 2;
                    }
                    flag = true;
                } else {
                    if(nums[i] > res) {
                        return res;
                    } else if(nums[i] == res) {
                        res++;
                    }
                }
            }
        }
        if(res == -1) {
            return 1;
        }

        return res;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return (array);
    }

    public static void swap(int[] array, int x, int y) {
        if(x != y) {
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
    }
}
