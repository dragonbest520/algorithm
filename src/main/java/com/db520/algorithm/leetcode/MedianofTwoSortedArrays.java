package com.db520.algorithm.leetcode;

/**
 * 4. Median of Two Sorted Arrays
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * @author zhuyl
 * @version 2019-06-14
 */
public class MedianofTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int begin1 = 0;
        int end1 = nums1.length;
        int begin2 = 0;
        int end2 = nums2.length;
        return findMedianSortedArrays(nums1, nums2, begin1, end1, begin2, end2);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2, int begin1, int end1, int begin2, int end2) {
        if(end1 - begin1 + end2 - begin2 <= 2) {
            double sum = 0;
            for (int i = begin1; i < end1; i++) {
                sum += nums1[i];
            }
            for (int i = begin2; i < end2; i++) {
                sum += nums2[i];
            }
            return sum / (end1 - begin1 + end2 - begin2);
        }
        if(begin1 < end1 && begin2 < end2) {
            if(nums1[begin1] > nums2[begin2]) {
                begin2++;
            } else {
                begin1++;
            }
            if(nums1[end1 - 1] > nums2[end2 - 1]) {
                end1--;
            } else {
                end2--;
            }
            return findMedianSortedArrays(nums1, nums2, begin1, end1, begin2, end2);
        }
        if(begin1 >= end1 && begin2 < end2) {
            begin2++;
            end2--;
            return findMedianSortedArrays(nums1, nums2, begin1, end1, begin2, end2);
        }
        if(begin1 < end1 && begin2 >= end2) {
            begin1++;
            end1--;
            return findMedianSortedArrays(nums1, nums2, begin1, end1, begin2, end2);
        }
        return 0;
    }
}
