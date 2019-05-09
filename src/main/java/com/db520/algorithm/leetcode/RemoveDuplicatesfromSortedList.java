package com.db520.algorithm.leetcode;

/**
 * 83. Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * @author zhuyl
 * @version 2019-05-09
 */
public class RemoveDuplicatesfromSortedList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println(new RemoveDuplicatesfromSortedList().deleteDuplicates(l1));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode tempNode = new ListNode(-1);
        tempNode.next = head;
        int digit = head.val;
        while(head.next != null) {
            if(head.next.val == digit) {
                head.next = head.next.next;
            } else {
                digit = head.next.val;
                head = head.next;
            }
        }

        return tempNode.next;
    }
}
