package com.tobias.leetcode.binary_search;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

import java.util.PriorityQueue;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 *    7
 *  3 ' 15
 * n'n 9'20
 *
 * Example:
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 * Note:
 *
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 */
public class S_173BinarySearchTreeIterator {

    private final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public S_173BinarySearchTreeIterator(TreeNode root) {
        putValueToPriorityQueue(root);
        System.out.println(priorityQueue);
    }

    public void putValueToPriorityQueue(TreeNode root) {
        if (root != null) {
            putValueToPriorityQueue(root.left);
            priorityQueue.add(root.val);
            putValueToPriorityQueue(root.right);
        }
    }

    /** @return the next smallest number */
    public int next() {
        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !priorityQueue.isEmpty();
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(new int[]{7, 3, 15, 9, 20});
        System.out.println(binaryTree);
        S_173BinarySearchTreeIterator iterator = new S_173BinarySearchTreeIterator(binaryTree.getRoot());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }
}
