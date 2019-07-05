package com.db520.algorithm.leetcode;

/**
 * 23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * @Description MergekSortedLists
 * @Author zhuyl
 * @Date 2019/7/2 11:22
 **/
public class MergekSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(5);
        n11.next = n12;
        n12.next = n13;
        ListNode n21 = new ListNode(1);
        ListNode n22 = new ListNode(3);
        ListNode n23 = new ListNode(4);
        n21.next = n22;
        n22.next = n23;
        ListNode n31 = new ListNode(2);
        ListNode n32 = new ListNode(6);
        n31.next = n32;
        ListNode[] lists = {n11, n21, n31};
        System.out.println(new MergekSortedLists().mergeKLists2(lists));
    }

    //Time Linit Exceeded
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        int pre = 0;
        for (int i = 1; i < lists.length; i++) {
            ListNode newNode = mergeTwoLists(lists[pre], lists[i]);
            lists[i] = newNode;
            pre = i;
        }
        return lists[lists.length - 1];
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        int n = lists.length;
        while (n > 1) {
            int k = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++)
                lists[i] = mergeTwoLists(lists[i], lists[i + k]);
            n = k;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode tempList = new ListNode(-2);
        tempList.next = newList;

        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                newList.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                newList.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            newList = newList.next;
        }
        while(l1 != null) {
            newList.next = new ListNode(l1.val);
            l1 = l1.next;
            newList = newList.next;
        }
        while(l2 != null) {
            newList.next = new ListNode(l2.val);
            l2 = l2.next;
            newList = newList.next;
        }

        return tempList.next.next;
    }
}
