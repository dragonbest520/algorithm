package com.db520.algorithm.leetcode;

/**
 * 147. Insertion Sort List
 *
 * Sort a linked list using insertion sort.
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * @author zhuyl
 * @version 2019-06-14
 */
public class InsertionSortList {

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
        System.out.println(new InsertionSortList().insertionSortList(n1));
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode head0 = new ListNode(-1);
        ListNode first = head;
        head0.next = first;
        while(head.next != null) {
            first = head0.next;
            ListNode pre = first;
            while(first.next != null) {
                if(head.next.val > first.next.val) {

                }
            }


            head = head.next;
        }
        return head;
    }
}
