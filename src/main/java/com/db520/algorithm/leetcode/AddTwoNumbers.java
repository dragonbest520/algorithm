package com.db520.algorithm.leetcode;

/**
 * 2. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * @author zhuyl
 * @version 2019-05-30
 */
public class AddTwoNumbers {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(0);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(3);
        node11.next = node12;
        node12.next = node13;
        ListNode node21 = new ListNode(0);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        new AddTwoNumbers().addTwoNumbers(node11, node21);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val == 0 && l2.val == 0 && l1.next == null && l2.next == null) {
            ListNode node = new ListNode(0);
            return node;
        }
        return addTwoNumbers(l1, l2, 0);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int add) {
        int l1v = 0;
        int l2v = 0;
        if(l1 != null) {
            l1v = l1.val;
        }
        if(l2 != null) {
            l2v = l2.val;
        }

        int temp = l1v + l2v + add;
        if(temp >= 10) {
            add = 1;
            temp = temp % 10;
        } else {
            add = 0;
        }

        if(temp ==0 && add == 0) {
            if((l1 == null && l2 == null) || (l1 != null && l1.next == null && l2 != null && l2.next == null)) {
                return null;
            }
        }

        ListNode node = new ListNode(temp);
        node.next = addTwoNumbers(l1 == null ? null: l1.next, l2 == null ? null: l2.next, add);
        return node;
    }

}
