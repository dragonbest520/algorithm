package com.db520.algorithm;

import java.util.*;

/**
 * @Description A* Algorithm
 * @Author db520 [dragonbest520@gmail.com]
 * @Date 2017/8/11 13:39
 */
public class AStar {

    public final static int BAR = 1;
    public final static int PATH = 2;
    public final static int DIRECT_VALUE = 10;
    public final static int OBLIQUE_VALUE = 14;

    private Queue<Node> openList = new PriorityQueue<Node>();
    private List<Node> closeList = new ArrayList<Node>();

    public static class Coord {
        public int x;
        public int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj instanceof Coord) {
                Coord c = (Coord) obj;
                return x == c.x && y == c.y;
            }
            return false;
        }
    }

    public static class Node implements Comparable<Node> {
        public Coord coord;
        public Node parent;
        public int g;
        public int h;

        public Node(int x, int y) {
            this.coord = new Coord(x, y);
        }

        public Node(Coord coord, Node parent, int g, int h) {
            this.coord = coord;
            this.parent = parent;
            this.g = g;
            this.h = h;
        }

        @Override
        public int compareTo(Node o) {
            if (o == null) return -1;
            if (g + h > o.g + o.h)
                return 1;
            else if (g + h < o.g + o.h) return -1;
            return 0;
        }
    }

    public static class MapInfo {
        public int[][] maps;
        public int width;
        public int hight;
        public Node start;
        public Node end;

        public MapInfo(int[][] maps, int width, int hight, Node start, Node end) {
            this.maps = maps;
            this.width = width;
            this.hight = hight;
            this.start = start;
            this.end = end;
        }
    }

    private boolean isCoordInClose(Coord coord) {
        return coord != null && isCoordInClose(coord.x, coord.y);
    }

    private boolean isCoordInClose(int x, int y) {
        if (closeList.isEmpty()) return false;
        for (Node node : closeList) {
            if (node.coord.x == x && node.coord.y == y) {
                return true;
            }
        }
        return false;
    }

    private boolean isEndNode(Coord end, Coord coord) {
        return coord != null && end.equals(coord);
    }

    private boolean canAddNodeToOpen(MapInfo mapInfo, int x, int y) {
        if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.hight) return false;
        if (mapInfo.maps[y][x] == BAR) return false;
        if (isCoordInClose(x, y)) return false;
        return true;
    }

    private int calcH(Coord end, Coord coord) {
        return Math.abs(end.x - coord.x) + Math.abs(end.y - coord.y);
    }

    private Node findNodeInOpen(Coord coord) {
        if (coord == null || openList.isEmpty()) return null;
        for (Node node : openList) {
            if (node.coord.equals(coord)) {
                return node;
            }
        }
        return null;
    }

    private void drawPath(int[][] maps, Node end) {
        if (end == null || maps == null) return;
        System.out.println("Total G: " + end.g);
        String path = "";
        while (end != null) {
            path = "(" + end.coord.x + ", " + end.coord.y + ") " + path;
            Coord c = end.coord;
            maps[c.y][c.x] = PATH;
            end = end.parent;
        }
        System.out.println(path);
        for (int i = 0; i < maps.length; i++) {
            System.out.println();
            for (int j = 0; j < maps[i].length; j++) {
                System.out.print(maps[i][j] + " ");
            }
        }
    }

    private void addNeighborNodeInOpen(MapInfo mapInfo, Node current) {
        int x = current.coord.x;
        int y = current.coord.y;
        addNeighborNodeInOpen(mapInfo, current, x - 1, y, DIRECT_VALUE);
        addNeighborNodeInOpen(mapInfo, current, x, y - 1, DIRECT_VALUE);
        addNeighborNodeInOpen(mapInfo, current, x + 1, y, DIRECT_VALUE);
        addNeighborNodeInOpen(mapInfo, current, x, y + 1, DIRECT_VALUE);
        addNeighborNodeInOpen(mapInfo, current, x - 1, y - 1, OBLIQUE_VALUE);
        addNeighborNodeInOpen(mapInfo, current, x + 1, y - 1, OBLIQUE_VALUE);
        addNeighborNodeInOpen(mapInfo, current, x + 1, y + 1, OBLIQUE_VALUE);
        addNeighborNodeInOpen(mapInfo, current, x - 1, y + 1, OBLIQUE_VALUE);
    }

    private void addNeighborNodeInOpen(MapInfo mapInfo, Node current, int x, int y, int value) {
        if (canAddNodeToOpen(mapInfo, x, y)) {
            Node end = mapInfo.end;
            Coord coord = new Coord(x, y);
            int g = current.g + value;
            Node child = findNodeInOpen(coord);
            if (child == null) {
                int h = calcH(end.coord, coord);
                if (isEndNode(end.coord, coord)) {
                    child = end;
                    child.parent = current;
                    child.g = g;
                    child.h = h;
                } else {
                    child = new Node(coord, current, g, h);
                }
                openList.add(child);
            } else if (child.g > g) {
                child.g = g;
                child.parent = current;
                openList.add(child);
            }
        }
    }

    private void moveNodes(MapInfo mapInfo) {
        while (!openList.isEmpty()) {
            Node current = openList.poll();
            closeList.add(current);
            addNeighborNodeInOpen(mapInfo, current);
        }

        if (isCoordInClose(mapInfo.end.coord)) {
            drawPath(mapInfo.maps, mapInfo.end);
        } else {
            System.out.println("Can't find the path from start to end.");
        }
    }

    public void start(MapInfo mapInfo) {
        if (mapInfo == null) {
            return;
        }
        openList.clear();
        closeList.clear();
        openList.add(mapInfo.start);
        moveNodes(mapInfo);
    }
}
