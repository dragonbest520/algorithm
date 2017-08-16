package com.db520.algorithm;

import com.db520.algorithm.huffman.HuffmanCoding;
import com.db520.algorithm.huffman.HuffmanTree;
import com.db520.algorithm.huffman.Node;
import org.junit.Test;

import java.util.*;

/**
 * @Description
 * @Author db520 [dragonbest520@gmail.com]
 * @Date 2017/8/16 17:29
 */
public class HuffmanTest {

    @Test
    public void huffmanCoding() throws Exception {
        HuffmanTree tree=new HuffmanTree();
        tree.addNode(new Node("A",40.0))
                .addNode(new Node("B",8.0))
                .addNode(new Node("C",10.0))
                .addNode(new Node("D",30.0))
                .addNode(new Node("E",10.0))
                .addNode(new Node("F",2.0));
        Node root=tree.createHuffmanTree();

        //广度遍历
//      List<Node> lists=tree.breadthFirst(root);
//      for(Node node:lists){
//          System.out.println(node);
//      }

        HuffmanCoding coding=new HuffmanCoding();
        Map<String,String> map=coding.coding(root);
        Set<String> mapSet=map.keySet();
        //TreeSet实现排序
        TreeSet<String> set=new TreeSet<String>(mapSet);
        Iterator<String> iterator=set.iterator();
        while(iterator.hasNext()){
            String str=iterator.next();
            System.out.println(str+":"+map.get(str));
        }
    }
}
