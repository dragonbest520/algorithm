package com.db520.algorithm.rbtree;

/**
 * @author zhuyl
 * @version 2019-05-07
 */
public class RBTNode <T extends Comparable<T>> {
    private static final boolean RED   = false;
    private static final boolean BLACK = true;
    boolean color;        // 颜色
    T key;                // 关键字(键值)
    RBTNode<T> left;    // 左孩子
    RBTNode<T> right;    // 右孩子
    RBTNode<T> parent;    // 父结点

    public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
        this.key = key;
        this.color = color;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    @Override
    public String toString() {
        return ""+key+(this.color==RED?"(R)":"B");
    }
}
