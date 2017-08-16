package com.db520.algorithm.huffman;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author db520 [dragonbest520@gmail.com]
 * @Date 2017/8/16 16:07
 */
public class HuffmanTree {

    private List<Node> nodes = new ArrayList<Node>();

    public HuffmanTree addNode(Node node) {
        nodes.add(node);
        return this;
    }

    private void quickSort() {
        sort(0, nodes.size() - 1);
    }

    private void sort(int start, int end) {
        if(start < end) {
            double base = nodes.get(start).getWeight();
            String baseData = nodes.get(start).getData();
            Node baseNode = new Node(baseData, base);
            int left = start;
            int right = end;
            while (end > start) {
                while (right > left && nodes.get(right).getWeight() > base) {
                    right--;
                }

                if(right > left) {
                    nodes.set(left, nodes.get(right));
                    left++;
                }

                while (right > left && nodes.get(left).getWeight() < base) {
                    left++;
                }

                if(right > left) {
                    nodes.set(right, nodes.get(left));
                    right--;
                }
            }
            nodes.set(right, baseNode);
            sort(start, right - 1);
            sort(right + 1, end);
        }
    }

    public Node createHuffmanTree() {
        while (nodes.size() > 1) {
            quickSort();
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node newNode = new Node(null, left.getWeight() + right.getWeight(), left, right);

            nodes.remove(0);
            nodes.remove(0);

            nodes.add(newNode);
        }
        return  nodes.get(0);
    }

    public List<Node> breadthFirst(Node root) {

        List<Node> lists = new ArrayList<Node>();
        Queue<Node> queue = new ArrayDeque<Node>();
        if(root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            lists.add(queue.peek());
            Node p = queue.poll();
            if(p.getLeftNode() != null) {
                queue.offer(p.getLeftNode());
            }
            if(p.getRightNode() != null) {
                queue.offer(p.getRightNode());
            }
        }
        return lists;
    }

}
