package com.db520.algorithm.leetcode;

/**
 * 143. Reorder List
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * @author zhuyl
 * @version 2019-06-10
 */
public class ReorderList {


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

        new ReorderList().reorderList(n1);

    }


    public void reorderList(ListNode head) {
        if (head == null
                || head.next == null
                || head.next.next == null)
            return;

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
        // 反转后半链表
        second = reverseList(second);

        ListNode first = head;
        // 合并两个链表，画图模拟
        // 把第二个链表插在第一个链表中
        while (second != null) {
            // 暂存第一个后续结点
            ListNode next = first.next;
            first.next = second;
            second = second.next;
            first = first.next;
            first.next = next;
            first = first.next;
        }
    }

    // 就地翻转链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
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
