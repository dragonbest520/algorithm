package com.db520.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author db520 [dragonbest520@gmail.com]
 * @Date 2017/8/10 9:03
 */
public class SearchTest {
    @Test
    public void linearSearch() throws Exception {
        double[] array = {8, 5, 4, 1, 9, 6, 7, 3, 2};
        double target = 7;
        Search.linearSearch(array, target);
    }

    @Test
    public void binarySearch() throws Exception {
        double[] array = {4, 7, 9, 18, 63, 96, 125, 321, 2232};
        double target = 125;
        Search.binarySearch(array, target);
    }

    @Test
    public void aStar() throws Exception {
        AStar aStar = new AStar();
        int width = 15;
        int height = 7;
        AStar.Node startNode = new AStar.Node(2, 4);
        AStar.Node endNode = new AStar.Node(13,6);
        int[][] maps = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}
        };

        AStar.MapInfo mapInfo = new AStar.MapInfo(maps, width, height, startNode, endNode);
        aStar.start(mapInfo);
    }

    @Test
    public void runLength() throws Exception {
        String src = "11111TTTUUUUUUTTTREABCDTTTTT";
        System.out.println("Source string is: " + src);
        String encodeResult = Compression.runLengthEncoding(src);
        System.out.println("run length encoding result is: " + encodeResult);
        String decodeResult = Compression.runLengthDecoding(encodeResult);
        System.out.println("run length decoding result is: " + decodeResult);
        Assert.assertEquals("source string equals run length decoding result!", src, decodeResult);
    }

}