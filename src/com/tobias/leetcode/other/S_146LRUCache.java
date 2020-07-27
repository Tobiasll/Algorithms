package com.tobias.leetcode.other;


import java.util.*;

/**
 * 146. LRU Cache
 * Medium
 *
 * 6050
 *
 * 261
 *
 * Add to List
 *
 * Share
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
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 /* capacity
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 *
 * Accepted
 * 567,813
 * Submissions
 * 1,724,003*/
public class S_146LRUCache {

    static class Node {

        private int key;
        private int value;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private final LinkedList<Node> linkedList;
    private final int TREEIFY_THRESHOLD ;
    private final Map<Integer, Integer> map ;

    public S_146LRUCache(int capacity) {
        linkedList = new LinkedList<>();
        TREEIFY_THRESHOLD = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            for (int i = 0; i < linkedList.size(); i++) {
                Node node = linkedList.get(i);
                if (node.key == key) {
                    Node removeNode = linkedList.remove(i);
                    linkedList.addFirst(removeNode);
                    return node.value;
                }
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            for (int i = 0; i < linkedList.size(); i++) {
                Node node = linkedList.get(i);
                if (node.key == key) {
                    node.value = value;
                    linkedList.remove(i);
                    linkedList.addFirst(node);
                    map.put(key, value);
                    break;
                }
            }
        } else {
            if (linkedList.size() == TREEIFY_THRESHOLD) {
                Node removeNode = linkedList.removeLast();
                map.remove(removeNode.getKey());
            }
            linkedList.addFirst(new Node(key, value));

            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        S_146LRUCache cache = new S_146LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));


    }
}
