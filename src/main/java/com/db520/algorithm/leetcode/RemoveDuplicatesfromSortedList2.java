package com.db520.algorithm.leetcode;

/**
 * 82. Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * @author zhuyl
 * @version 2019-06-13
 */
public class RemoveDuplicatesfromSortedList2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        System.out.println(new RemoveDuplicatesfromSortedList2().deleteDuplicates(l1));
    }


    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode tempNode = new ListNode(-1);
        tempNode.next = head;
        int digit = head.val;
        ListNode pre = tempNode;
        while(head.next != null) {
            if(head.next.val == digit) {
                pre.next = head.next.next;
                head = pre;
            } else {
                pre = head;
                digit = head.next.val;
                head = head.next;
            }
        }

        return tempNode.next;
    }
}
