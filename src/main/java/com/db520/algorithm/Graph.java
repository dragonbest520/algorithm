package com.db520.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description Model of Graph by Adjacency Matrix
 * @Author db520 [dragonbest520@gmail.com]
 * @Date 2017/8/10 9:33
 */
public class Graph {
    private ArrayList pointList;
    private int[][] edges;
    private int edgeNum = 0;
    private static int MAX_WEIGHT = Integer.MAX_VALUE / 10;

    public Graph(int n) {
        edges = new int[n][n];
        pointList = new ArrayList(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edges[i][j] = MAX_WEIGHT;
            }
        }
    }

    public void insertPoint(Object point) {
        pointList.add(point);
    }

    public void insertEdge(int i, int j, int weight) {
        edges[i][j] = weight;
        edgeNum++;
    }

    public Object getValueByIndex(int i) {
        return pointList.get(i);
    }

    public int getNumOfPoint() {
        return pointList.size();
    }

    public int getNumOfEdges() {
        return edgeNum;
    }

    public int getFirstNeighbor(int i) {
        for (int j = 0; j < getNumOfPoint(); j++) {
            if(getEdgeWeight(i, j) != MAX_WEIGHT) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int i, int first) {
        for (int j = first + 1; j < getNumOfPoint(); j++) {
            if(getEdgeWeight(i, j) != MAX_WEIGHT) {
                return j;
            }
        }
        return -1;
    }

    public int getEdgeWeight(int i, int j) {
        return edges[i][j];
    }

    public void setEdgeWeight(int i, int j, int weight) {
        edges[i][j] = weight;
    }

    public void depthFirstSearch() {
        boolean[] isVisited = new boolean[getNumOfPoint()];
        for (int i = 0; i < getNumOfPoint(); i++) {
            depthFirstSearch(isVisited, i);
        }
    }

    public void breadthFirstSearch() {
        boolean[] isVisited = new boolean[getNumOfPoint()];
        for (int i = 0; i < getNumOfPoint(); i++) {
            breadthFirstSearch(isVisited, i);
        }
    }

    public boolean bellmanFord() {
        boolean notNegativeCycle = true;
        int[] result = new int[getNumOfPoint()];
        for (int i = 1; i < getNumOfPoint(); i++) {
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < getNumOfPoint(); i++) {
            for (int j = 0; j < getNumOfPoint(); j++) {
                for (int k = 0; k < getNumOfPoint(); k++) {
                    if(getEdgeWeight(j, k) != MAX_WEIGHT) {
                        if(result[k] > result[j] + getEdgeWeight(j, k)) {
                            result[k] = result[j] + getEdgeWeight(j, k);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < getNumOfPoint(); i++) {
            for (int j = 0; j < getNumOfPoint(); j++) {
                for (int k = 0; k < getNumOfPoint(); k++) {
                    if (getEdgeWeight(j, k) != MAX_WEIGHT) {
                        if(result[k] > result[j] + getEdgeWeight(j, k)) {
                            System.out.println("There is a negative cycle in the graph.");
                            return false;
                        }
                    }
                }
            }
        }

        System.out.println("bellmanFord result: " + Arrays.toString(result));

        return notNegativeCycle;
    }

    public void dijkstra() {
        int candidateNum = getNumOfPoint();
        double[] result = new double[getNumOfPoint()];
        boolean[] isVisited = new boolean[getNumOfPoint()];
        for (int i = 1; i < getNumOfPoint(); i++) {
            result[i] = Integer.MAX_VALUE;
        }

        while(candidateNum > 0) {
            int minIndex = 0;
            for (int i = 0; i < result.length; i++) {
                if(!isVisited[i]) {
                    minIndex = i;
                    break;
                }
            }
            for (int i = 0; i < result.length; i++) {
                if(!isVisited[i] && result[minIndex] > result[i]) {
                    minIndex = i;
                }
            }
            isVisited[minIndex] = true;
            candidateNum--;

            for (int i = 0; i < edges[minIndex].length; i++) {
                if (getEdgeWeight(minIndex, i) != MAX_WEIGHT && !isVisited[i]) {
                    if(result[i] > result[minIndex] + getEdgeWeight(minIndex, i)) {
                        result[i] = result[minIndex] + getEdgeWeight(minIndex, i);
                    }
                }
            }
        }
        System.out.println("dijkstra result: " + Arrays.toString(result));
    }

    public void floyd() {
        int[][] Dis = new int[getNumOfPoint()][getNumOfPoint()];
        for (int i = 0; i < getNumOfPoint(); i++) {
            for (int j = 0; j < getNumOfPoint(); j++) {
                Dis[i][j] = edges[i][j];
            }
        }

        for (int k = 0; k < getNumOfPoint(); k++) {
            for (int i = 0; i < getNumOfPoint(); i++) {
                for (int j = 0; j < getNumOfPoint(); j++) {
                    if (Dis[i][j] > Dis[i][k] + Dis[k][j]) {
                        Dis[i][j] = Dis[i][k] + Dis[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < getNumOfPoint(); i++) {
            for (int j = 0; j < getNumOfPoint(); j++) {
                System.out.println(i + "->" + j + "  " + Dis[i][j]);
            }
        }
    }

    public void spfa() {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        int[] negativeCycle = new int[getNumOfPoint()];
        double[] result = new double[getNumOfPoint()];
        for (int i = 1; i < getNumOfPoint(); i++) {
            result[i] = Integer.MAX_VALUE;
        }
        queue.offer(0);
        negativeCycle[0]++;
        while(queue.size() > 0) {
            for (int i = 0; i < getNumOfPoint(); i++) {
                if(negativeCycle[i] >= getNumOfPoint()) {
                    System.out.println("There is negative cycle in the graph.");
                    return;
                }
            }

            int firstPoint = queue.poll().intValue();
            for (int i = 0; i < getNumOfPoint(); i++) {
                if (getEdgeWeight(firstPoint, i) != MAX_WEIGHT) {
                    if(result[i] > result[firstPoint] + getEdgeWeight(firstPoint, i)) {
                        result[i] = result[firstPoint] + getEdgeWeight(firstPoint, i);
                        if(!queue.contains(i)) {
                            queue.offer(i);
                            negativeCycle[i]++;
                        }
                    }
                }
            }
        }

        System.out.println("bellmanFord result: " + Arrays.toString(result));
    }

    private void depthFirstSearch(boolean[] isVisited, int i) {
        if(!isVisited[i]) {
            System.out.print(getValueByIndex(i) + " ");
            isVisited[i] = true;

            int next = getFirstNeighbor(i);
            while (next != -1) {
                depthFirstSearch(isVisited, next);
                next = getNextNeighbor(i, next);
            }
        }
    }

    private void breadthFirstSearch(boolean[] isVisited, int i) {
        if(!isVisited[i]) {
            int index, next;
            ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

            System.out.print(getValueByIndex(i) + " ");
            isVisited[i] = true;

            queue.offer(i);
            while(!queue.isEmpty()) {
                index = queue.poll().intValue();
                next = getFirstNeighbor(index);
                while(next != -1) {
                    if(!isVisited[next]) {
                        System.out.print(getValueByIndex(next) + " ");
                        isVisited[next] = true;
                        queue.offer(next);
                    }
                    next = getNextNeighbor(index, next);
                }
            }
        }
    }
}
