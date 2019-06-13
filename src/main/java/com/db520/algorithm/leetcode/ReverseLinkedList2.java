package com.db520.algorithm.leetcode;

/**
 * 92. Reverse Linked List II
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * @author zhuyl
 * @version 2019-06-13
 */
public class ReverseLinkedList2 {

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
        int m = 1;
        int n = 2;
        System.out.println(new ReverseLinkedList2().reverseBetween(n1, m, n));
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode head0 = new ListNode(-1);
        head0.next = head;
        head = head0;
        int i = 0;
        while(head.next != null) {
            i++;
            if(i == m) {
                ListNode tail = head;
                ListNode newHead = head.next;
                head = head.next;
                while(i < n) {
                    i++;
                    head = head.next;
                }

                ListNode newHead2 = head.next;
                head.next = null;

                tail.next = reverseList(newHead, newHead2);
                break;
            }
            head = head.next;
        }
        return head0.next;
    }

    // 就地翻转链表
    private ListNode reverseList(ListNode head, ListNode prev) {
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
