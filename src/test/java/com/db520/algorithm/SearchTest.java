package com.db520.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

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
    public void depthFirstSearch() throws Exception {
        String[] points = {"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(8);
        for(String point : points) {
            graph.insertPoint(point);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(2, 0, 1);
        graph.insertEdge(3, 1, 1);
        graph.insertEdge(4, 1, 1);
        graph.insertEdge(7, 3, 1);
        graph.insertEdge(7, 4, 1);
        graph.insertEdge(6, 2, 1);
        graph.insertEdge(5, 2, 1);
        graph.insertEdge(6, 5, 1);

        Search.depthFirstSearch(graph);
    }

    @Test
    public void breadthFirstSearch() throws Exception {
        String[] points = {"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(8);
        for(String point : points) {
            graph.insertPoint(point);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(2, 0, 1);
        graph.insertEdge(3, 1, 1);
        graph.insertEdge(4, 1, 1);
        graph.insertEdge(7, 3, 1);
        graph.insertEdge(7, 4, 1);
        graph.insertEdge(6, 2, 1);
        graph.insertEdge(5, 2, 1);
        graph.insertEdge(6, 5, 1);

        Search.breadthFirstSearch(graph);
    }

    @Test
    public void bellmanFord() throws Exception {
        String[] points = {"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(8);
        for(String point : points) {
            graph.insertPoint(point);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 2);
        graph.insertEdge(1, 3, 3);
        graph.insertEdge(1, 4, 4);
        graph.insertEdge(3, 7, 5);
        graph.insertEdge(4, 7, 6);
        graph.insertEdge(2, 5, 7);
        graph.insertEdge(2, 6, 8);
        graph.insertEdge(5, 6, 9);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(2, 0, 2);
        graph.insertEdge(3, 1, 3);
        graph.insertEdge(4, 1, 4);
        graph.insertEdge(7, 3, 5);
        graph.insertEdge(7, 4, 6);
        graph.insertEdge(6, 2, 8);
        graph.insertEdge(5, 2, 7);
        graph.insertEdge(6, 5, 9);

        Search.bellmanFord(graph);
    }

    @Test
    public void dijkstra() throws Exception {
        String[] points = {"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(8);
        for(String point : points) {
            graph.insertPoint(point);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 2);
        graph.insertEdge(1, 3, 3);
        graph.insertEdge(1, 4, 4);
        graph.insertEdge(3, 7, 5);
        graph.insertEdge(4, 7, 6);
        graph.insertEdge(2, 5, 7);
        graph.insertEdge(2, 6, 8);
        graph.insertEdge(5, 6, 9);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(2, 0, 2);
        graph.insertEdge(3, 1, 3);
        graph.insertEdge(4, 1, 4);
        graph.insertEdge(7, 3, 5);
        graph.insertEdge(7, 4, 6);
        graph.insertEdge(6, 2, 8);
        graph.insertEdge(5, 2, 7);
        graph.insertEdge(6, 5, 9);

        Search.dijkstra(graph);
    }

    @Test
    public void floyd() throws Exception {
        String[] points = {"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(8);
        for(String point : points) {
            graph.insertPoint(point);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 2);
        graph.insertEdge(1, 3, 3);
        graph.insertEdge(1, 4, 4);
        graph.insertEdge(3, 7, 5);
        graph.insertEdge(4, 7, 6);
        graph.insertEdge(2, 5, 7);
        graph.insertEdge(2, 6, 8);
        graph.insertEdge(5, 6, 9);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(2, 0, 2);
        graph.insertEdge(3, 1, 3);
        graph.insertEdge(4, 1, 4);
        graph.insertEdge(7, 3, 5);
        graph.insertEdge(7, 4, 6);
        graph.insertEdge(6, 2, 8);
        graph.insertEdge(5, 2, 7);
        graph.insertEdge(6, 5, 9);

        Search.floyd(graph);
    }

}