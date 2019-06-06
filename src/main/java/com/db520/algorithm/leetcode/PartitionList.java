package com.db520.algorithm.leetcode;

/**
 * 86. Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * @author zhuyl
 * @version 2019-06-06
 */
public class PartitionList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        int x = 3;

        System.out.println(new PartitionList().partition(n1, x));
    }


    public ListNode partition(ListNode head, int x) {
        ListNode head0 = new ListNode(0);
        ListNode head1 = new ListNode(0);
        head0.next = head;
        ListNode temp = head0;
        ListNode newNode = null;
        while(temp.next != null) {
            if(temp.next.val >= x) {
                if(newNode == null) {
                    newNode = new ListNode(temp.next.val);
                    head1.next = newNode;
                } else {
                    newNode.next = new ListNode(temp.next.val);
                    newNode = newNode.next;
                }
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        temp.next = head1.next;
        return head0.next;
    }
}
