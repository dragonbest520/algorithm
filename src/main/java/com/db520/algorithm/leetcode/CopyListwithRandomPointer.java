package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * @author zhuyl
 * @version 2019/6/3
 */
public class CopyListwithRandomPointer {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public static void main(String[] args) {
        Node head = new Node();
        Node node2 = new Node();
        head.val = 1;
        head.next = node2;
        head.random = node2;
        node2.val = 2;
        node2.random = node2;

        new CopyListwithRandomPointer().copyRandomList(head);
    }


    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node clone = copyRandomList(head, nodeMap);

        return clone;
    }


    public Node copyRandomList(Node head, Map<Node, Node> nodeMap) {
        Node clone = new Node();
        clone.val = head.val;
        nodeMap.put(head, clone);

        if(head.next != null) {
            clone.next = copyRandomList(head.next, nodeMap);
        }
        if(head.random != null) {
            if(nodeMap.containsKey(head.random)) {
                clone.random = nodeMap.get(head.random);
            } else {
                clone.random = copyRandomList(head.random, nodeMap);
            }
        }
        return clone;
    }
}
