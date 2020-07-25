package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 *
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */
public class S_572SubtreeOfAnotherTree {


    /**
     * Runtime: 5 ms, faster than 97.34% of Java online submissions for Subtree of Another Tree.
     * Memory Usage: 39.7 MB, less than 38.20% of Java online submissions for Subtree of Another Tree.
     */
    public boolean isSubtree(TreeNode s,TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.val == t.val) {
                    boolean judge = isSubtreeHelper(poll, t);
                    if (judge) {
                        return judge;
                    }
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }

        return false;
    }

    private boolean isSubtreeHelper(TreeNode s,TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null && t != null || s != null && t == null || s.val != t.val) {
            return false;
        } else if (s.val == t.val && s.left == null && s.right == null && t.left == null && t.right == null) {
            return true;
        }
        return isSubtreeHelper(s.left, t.left) && isSubtreeHelper(s.right, t.right);

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(new int[]{3, 5});
        binaryTree.getRoot().left = new TreeNode(4);
        binaryTree.getRoot().left.left = new TreeNode(1);
        binaryTree.getRoot().left.right = new TreeNode(2);
        binaryTree.getRoot().left.right.left = new TreeNode(0);
        System.out.println(binaryTree);
        BinaryTree binaryTree2 = new BinaryTree(new int[]{3, 5});
        binaryTree2.getRoot().left = new TreeNode(4);
        binaryTree2.getRoot().left.left = new TreeNode(1);
        binaryTree2.getRoot().left.right = new TreeNode(2);
        System.out.println(binaryTree2);
        S_572SubtreeOfAnotherTree subtreeOfAnotherTree = new S_572SubtreeOfAnotherTree();
        System.out.println(subtreeOfAnotherTree.isSubtree(binaryTree.getRoot(), binaryTree2.getRoot().left));
    }
}
