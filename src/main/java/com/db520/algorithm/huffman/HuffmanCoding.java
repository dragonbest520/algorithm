package com.db520.algorithm.huffman;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author db520 [dragonbest520@gmail.com]
 * @Date 2017/8/16 17:26
 */
public class HuffmanCoding {
    Map<String, String> map = new HashMap<String, String>();
    public Map<String, String> coding(Node root) {
        process(root, "");
        return map;
    }

    private void process(Node node, String content) {
        if(node.getLeftNode() == null) {
            map.put(node.getData(), content);
            return;
        }
        process(node.getLeftNode(), content + "0");
        process(node.getRightNode(), content + "1");
    }
}
