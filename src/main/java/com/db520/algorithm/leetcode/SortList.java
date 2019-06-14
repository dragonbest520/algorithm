package com.db520.algorithm.leetcode;

/**
 * 148. Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * @author zhuyl
 * @version 2019-06-14
 */
public class SortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(new SortList().sortList(n1));
    }


    public ListNode sortList(ListNode head) {
        if (head == null
                || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        // 找到中间结点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        // 注意置空，分为两个链表
        // 第一个链表的长度大于（+1）等于第二个链表长度
        slow.next = null;

        head = sortList(head);
        second = sortList(second);

        ListNode head0 = new ListNode(-1);
        ListNode first = null;
        head0.next = first;
        while(head != null || second != null) {
            if(head == null && second != null) {
                if(first == null) {
                    first = second;
                    head0.next = first;
                } else {
                    first.next = second;
                    first = first.next;
                }
                second = second.next;
            }
            if(head != null && second == null) {
                if(first == null) {
                    first = head;
                    head0.next = first;
                } else {
                    first.next = head;
                    first = first.next;
                }
                head = head.next;
            }
            if(head != null && second != null) {
                if(head.val < second.val) {
                    if(first == null) {
                        first = head;
                        head0.next = first;
                    } else {
                        first.next = head;
                        first = first.next;
                    }
                    head = head.next;
                } else {
                    if(first == null) {
                        first = second;
                        head0.next = first;
                    } else {
                        first.next = second;
                        first = first.next;
                    }
                    second = second.next;
                }
            }
        }
        return head0.next;
    }

}
