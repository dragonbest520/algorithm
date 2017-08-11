package com.db520.algorithm;

/**
 * @Author db520 [dragonbest520@gmail.com]
 * @Date 2017/8/10 8:39
 */
public class Search {

    public static void linearSearch(double[] array, double target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                System.out.println("index = " + i + ", target = " + target + "");
                break;
            }
        }
    }

    public static void binarySearch(double[] array, double target) {
        int low = 0;
        int high = array.length - 1;
        int midIndex = 0;
        while (low < high) {
            midIndex = (low + high) / 2;
            if (target == array[midIndex]) {
                break;
            }
            if (target > array[midIndex]) {
                low = midIndex + 1;
            } else {
                high = midIndex - 1;
            }
        }
        System.out.println("index = " + midIndex + ", target = " + target + "");
    }

    public static void breadthFirstSearch(Graph graph) {
        System.out.print("breadthFirstSearch result：");
        graph.breadthFirstSearch();
    }

    public static void depthFirstSearch(Graph graph) {
        System.out.print("depthFirstSearch result：");
        graph.depthFirstSearch();
    }

    public static void bellmanFord(Graph graph) {
        graph.bellmanFord();
    }

    public static void dijkstra(Graph graph) {
        graph.dijkstra();
    }

    public static void floyd(Graph graph) {
        graph.floyd();
    }

    public static void spfa(Graph graph) {
        graph.spfa();
    }

}
