package com.db520.algorithm.leetcode;

import java.util.List;

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

    public Node cloneGraph(Node node) {
        Node newNode = new Node();
        return newNode;
    }
}
