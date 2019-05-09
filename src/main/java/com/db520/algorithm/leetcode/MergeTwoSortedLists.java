package com.db520.algorithm.leetcode;


import java.util.Iterator;

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * @author zhuyl
 * @version 2019-05-09
 */
public class MergeTwoSortedLists {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l1.next = l11;
        l11.next = l12;
        l2.next = l21;
        l21.next = l22;

        System.out.println(new MergeTwoSortedLists().mergeTwoLists(l1, l2));

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode tempList = new ListNode(-2);
        tempList.next = newList;

        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                newList.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                newList.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            newList = newList.next;
        }
        while(l1 != null) {
            newList.next = new ListNode(l1.val);
            l1 = l1.next;
            newList = newList.next;
        }
        while(l2 != null) {
            newList.next = new ListNode(l2.val);
            l2 = l2.next;
            newList = newList.next;
        }

        return tempList.next.next;
    }
}
