package com.db520.algorithm.avltree;

/**
 * @author zhuyl
 * @version 2019-05-07
 */
public class Node {

    private Node parent;
    private Node left;
    private Node right;
    //节点的值
    private int item;
    //平衡因子
    private int bf;

    public Node(int item) {
        this.item = item;
        this.bf = 0;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getBf() {
        return bf;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public int subBf(){
        bf -= 1;
        return bf;
    }

    public int addBf(){
        bf += 1;
        return bf;
    }

    public Node getBrother(){
        if(parent == null)
            return null;
        else if(this == parent.getLeft())
            return parent.getRight();
        else
            return parent.getLeft();
    }

    public boolean hasBrother(){
        if(parent == null)
            return false;
        else if(this == parent.getLeft() && parent.getRight() != null)
            return true;
        else if(this == parent.getRight() && parent.getLeft() != null)
            return true;
        else
            return false;
    }

    public boolean hasChild(){
        if(left != null || right != null)
            return true;
        else
            return false;
    }

    public void deleteChildNode(Node child){
        if(child == null)
            return;
        else if(child == left)
            left = null;
        else if(child == right)
            right = null;
    }
}
