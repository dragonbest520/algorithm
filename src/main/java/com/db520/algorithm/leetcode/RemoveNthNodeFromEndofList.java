package com.db520.algorithm.leetcode;

/**
 * 19. Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * @author zhuyl
 * @version 2019-06-06
 */
public class RemoveNthNodeFromEndofList {

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

        int n = 2;

        System.out.println(new RemoveNthNodeFromEndofList().removeNthFromEnd(n1, n));

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        if(cur == null) {
            head = head.next;
            return head;
        }

        while(cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {

        int count = 1;
        ListNode temp = head;
        while(temp.next != null) {
            count++;
            temp = temp.next;
        }

        if(count - n == 0) {
            head = head.next;
        } else {
            temp = head;
            for (int i = 1; i < count - n; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

        return head;

    }

}
