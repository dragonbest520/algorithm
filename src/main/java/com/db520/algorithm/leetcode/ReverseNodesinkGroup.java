package com.db520.algorithm.leetcode;

import java.util.List;

/**
 * 25. Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *  k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * @Description ReverseNodesinkGroup
 * @Author zhuyl
 * @Date 2019/7/2 11:23
 **/
public class ReverseNodesinkGroup {

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
        int k = 3;
        System.out.println(new ReverseNodesinkGroup().reverseKGroup(n1, k));
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) {
            return head;
        }
        ListNode head0 = new ListNode(-1);
        head0.next = head;
        int i = 1;
        ListNode pre = head0;
        ListNode tail = null;
        while(head != null) {
            if(i % k == 0) {
                tail = head.next;
                head.next = null;
                ListNode newPre = pre.next;
                ListNode nodeTmp = reverseList(pre.next, tail);
                pre.next = nodeTmp;
                pre = newPre;
                head = newPre.next;
            } else {
                head = head.next;
            }
            i++;
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
