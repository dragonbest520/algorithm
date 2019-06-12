package com.db520.algorithm.leetcode;

/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * @author zhuyl
 * @version 2019-06-12
 */
public class SwapNodesinPairs {

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
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode newNode = new SwapNodesinPairs().swapPairs(n1);
        System.out.println(newNode);
    }


    public ListNode swapPairs(ListNode head) {
        if(head != null && head.next != null) {

            ListNode newHead = head.next;
            ListNode next = head.next.next;
            head.next.next = head;
            head.next = swapPairs(next);

            return newHead;
        } else {
            return head;
        }
    }

}
