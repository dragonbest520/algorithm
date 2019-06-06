package com.db520.algorithm.leetcode;

/**
 * 142. Linked List Cycle II
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * @author zhuyl
 * @version 2019-06-06
 */
public class LinkedListCycle2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
           val = x;
           next = null;
        }
    }

    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;*/
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = l1;

        System.out.println(new LinkedListCycle2().detectCycle(l1));
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while(true) {
                    if(head == slow) {
                        return head;
                    }
                    head = head.next;
                    slow = slow.next;
                }
            }
        }
        return null;

    }

}
