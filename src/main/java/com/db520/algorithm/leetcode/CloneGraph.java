package com.db520.algorithm.leetcode;

import java.util.*;

/**
 * 133. Clone Graph
 *
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * @author zhuyl
 * @version 2019-06-06
 */
public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;

        n1.neighbors = new ArrayList<>();
        n2.neighbors = new ArrayList<>();
        n3.neighbors = new ArrayList<>();
        n4.neighbors = new ArrayList<>();
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        new CloneGraph().cloneGraph(n1);
    }

    private HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    private Node clone(Node node) {
        if(node == null) {
            return null;
        }

        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node clone = new Node();
        clone.val = node.val;
        clone.neighbors = new ArrayList<>();
        map.put(clone.val, clone);
        for(Node neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }

        return clone;
    }


    public Node cloneGraph2(Node node) {
        if(node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node head = new Node();
        head.val = node.val;
        map.put(node, head);

        Stack<Node> stack = new Stack();
        stack.push(node);
        while(!stack.isEmpty()) {
            Node root = stack.pop();
            List<Node> list = new ArrayList<>();
            for (Node n : root.neighbors) {
                if(map.containsKey(n)) {
                    list.add(map.get(n));
                } else {
                    Node node1 = new Node();
                    node1.val = n.val;
                    stack.push(n);
                    map.put(n, node1);
                    list.add(node1);
                }
            }
            map.get(root).neighbors = list;
        }

        return head;
    }
}
