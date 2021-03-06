package com.db520.algorithm.leetcode;

import java.util.LinkedList;

/**
 * 117. Populating Next Right Pointers in Each Node II
 *
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * @author zhuyl
 * @version 2019-06-05
 */
public class PopulatingNextRightPointersinEachNode2 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        /*Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n7 = new Node();
        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;
        n5.val = 5;
        n7.val = 7;
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n7;*/

        /*Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        Node n7 = new Node();
        Node n8 = new Node();
        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;
        n5.val = 5;
        n6.val = 6;
        n7.val = 7;
        n8.val = 8;
        n1.left = n2;
        n1.right = n5;
        n2.right = n3;
        n5.left = n6;
        n5.right = n8;
        n3.left = n4;
        n6.left = n7;*/

        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        Node n7 = new Node();
        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;
        n5.val = 5;
        n6.val = 6;
        n7.val = 7;
        n1.left = n2;
        n1.right = n7;
        n2.left = n3;
        n2.right = n6;
        n3.left = n4;
        n3.right = n5;

        new PopulatingNextRightPointersinEachNode2().connect2(n1);
    }

    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<Node>();
        if (root == null) {
            return root;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
//            for (int i = 0; i < num; i++) {
//                if(i + 1 < num) {
//                    queue.get(i).next = queue.get(i + 1);
//                }
//            }

            for (int i = 0; i < num; i++) {
                if (i + 1 < num) {
                    queue.get(0).next = queue.get(1);
                }
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                if (queue.peek().left == null && queue.peek().right == null) {
                }
                queue.poll();
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        Node level_start = root;
        while (level_start != null) {
            Node cur = level_start;
            Node last = null;
            boolean flag = true;
            while (cur != null) {
                if (cur.left != null)  {
                    if(last == null) {
                        last = cur.left;
                    } else {
                        last.next = cur.left;
                        last = cur.left;
                    }
                    if(flag) {
                        level_start = cur.left;
                        flag = false;
                    }
                }
                if (cur.right != null)  {
                    if(last == null) {
                        last = cur.right;
                    } else {
                        last.next = cur.right;
                        last = cur.right;
                    }
                    if(flag) {
                        level_start = cur.right;
                        flag = false;
                    }
                }
                if (flag == true && cur.next == null && cur.left == null && cur.right == null)  {
                    level_start = null;
                }
                cur = cur.next;
            }
        }
        return root;
    }
}
