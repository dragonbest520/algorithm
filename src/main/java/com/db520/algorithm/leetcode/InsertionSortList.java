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
        /*ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;*/

        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(0);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;



        System.out.println(new InsertionSortList().insertionSortList(n1));
    }

    //Too Slow
    public ListNode insertionSortList2(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode head0 = new ListNode(-1);
        ListNode resultNode = null;
        while(head != null) {
            if(resultNode == null) {
                resultNode = new ListNode(head.val);
                head0.next = resultNode;
            } else {
                resultNode = head0.next;
                ListNode pre = head0;
                while(resultNode != null) {
                    if(head.val < resultNode.val) {
                        ListNode tmp = new ListNode(head.val);
                        pre.next = tmp;
                        tmp.next = resultNode;
                        resultNode = head0.next;
                        break;
                    } else {
                        if(resultNode.next == null) {
                            ListNode tmp = new ListNode(head.val);
                            resultNode.next = tmp;
                            break;
                        } else {
                            pre = resultNode;
                            resultNode = resultNode.next;
                        }
                    }
                }
            }
            head = head.next;
        }
        return head0.next;
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode head0 = new ListNode(-1);
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            ListNode pre = head0;
            while (pre.next != null && cur.val > pre.next.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return head0.next;
    }
}
