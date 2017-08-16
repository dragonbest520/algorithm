package com.db520.algorithm.huffman;

/**
 * @Description
 * @Author db520 [dragonbest520@gmail.com]
 * @Date 2017/8/16 16:09
 */
public class Node {
    private String data;
    private Node leftNode;
    private Node rightNode;
    private double weight;

    public Node(String data, double weight) {
        this.data = data;
        this.weight = weight;
    }

    public Node(String data, double weight, Node leftNode, Node rightNode) {
        this.data = data;
        this.weight = weight;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", weight=" + weight +
                '}';
    }
}
