package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 *
 * Example:
 *
 * Input: [1,2]
 * Output: [1,2]
 * Explanation:
 *
 *    1            <---
 *  /
 * 2               <---
 *
 */
public class S_199BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null && poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll != null && poll.right != null) {
                    queue.offer(poll.right);
                }
                if (poll != null && i == size - 1) {
                    result.add(poll.val);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S_199BinaryTreeRightSideView binaryTreeRightSideView = new S_199BinaryTreeRightSideView();
        BinaryTree binaryTree = new BinaryTree(new int[]{1, 3, 4, 2, 6, 7, 8, 9});
        binaryTree.getRoot().left = new BinaryTree.TreeNode(2);
        binaryTree.getRoot().left.right = new BinaryTree.TreeNode(5);
        System.out.println(binaryTree);
        StringBuilder sb = new StringBuilder();
        binaryTree.morrisInOrderTravel(binaryTree.getRoot(), sb);
        System.out.println(sb.toString());
        System.out.println(binaryTreeRightSideView.rightSideView(binaryTree.getRoot()));
    }
}
