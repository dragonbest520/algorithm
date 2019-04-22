package com.db520.algorithm.leetcode;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * @author zhuyl
 * @version 2019-04-22
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        int m = 3;
        int n = 3;

        new MergeSortedArray().merge(nums1, m, nums2, n);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0 && n != 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
        }

        int i = m - 1;
        int j = n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[i + j + 1] = nums1[i];
                i--;
            } else {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }
        while(j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
