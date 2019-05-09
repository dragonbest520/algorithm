package com.db520.algorithm.leetcode;

/**
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 *
 * @author zhuyl
 * @version 2019-05-09
 */
public class LinkedListCycle {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        return false;
    }
}
