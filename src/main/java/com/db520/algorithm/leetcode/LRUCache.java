package com.db520.algorithm.leetcode;

import java.util.*;

/**
 * 146. LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * @author zhuyl
 * @version 2019-06-14
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        MAX_CACHE_SIZE = capacity;
        //根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容，
        int cap = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1;
        map = new LinkedHashMap(cap, DEFAULT_LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public synchronized void put(int key, int value) {
        map.put(key, value);
    }

    public synchronized int get(int key) {
        if(map.containsKey(key)) {
            return map.get(key);
        } else {
            return -1;
        }
    }

    public synchronized void remove(int key) {
        map.remove(key);
    }

    public synchronized Set<Map.Entry<Integer, Integer>> getAll() {
        return map.entrySet();
    }

    public synchronized int size() {
        return map.size();
    }

    public synchronized void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }


    /*int size,num;
    List<Integer> list ;
    Map<Integer,Integer> map;

    public LRUCache(int capacity) {

        size = capacity;
        num = 0;
        list = new ArrayList<Integer>();
        map = new HashMap<Integer,Integer>();


    }

    public int get(int key) {
        if( map.containsKey(key) ){
            list.remove((Integer)key);
            list.add(key);
            return map.get(key);
        }
        else
            return -1;

    }

    public void set(int key, int value) {
        if( map.containsKey(key) ){
            list.remove((Integer)key);
            map.put(key,value);
            list.add(key);
        }else{
            if( num == size ){
                map.remove(list.get(0));
                list.remove((int)0);
                map.put(key,value);
                list.add(key);
            }else{
                map.put(key,value);
                list.add(key);
                num++;
            }
        }
    }*/

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */