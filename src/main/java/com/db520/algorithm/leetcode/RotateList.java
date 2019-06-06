package com.db520.algorithm.leetcode;

/**
 * 61. Rotate List
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * @author zhuyl
 * @version 2019-06-06
 */
public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        int k = 2;

        System.out.println(new RotateList().rotateRight(n1, k));
    }


    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head;

        int count = 1;
        while(cur.next != null) {
            count++;
            cur = cur.next;
        }

        k = k % count;
        cur = head;

        for (int i = 0; i < k; i++) {
            if(cur.next != null) {
                cur = cur.next;
            } else {
                cur = head;
            }
        }
        if(cur == null) {
            return head;
        }
        while(cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        cur.next = head;
        ListNode result = pre.next;
        pre.next = null;
        return result;
    }
}
