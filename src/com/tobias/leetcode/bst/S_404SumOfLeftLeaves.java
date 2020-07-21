package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class S_404SumOfLeftLeaves {


    int sum = 0;

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
     * Memory Usage: 37.5 MB, less than 36.28% of Java online submissions for Sum of Left Leaves.
     */
    public int sumOfLeftLeaves(TreeNode root) {

        if (root != null) {
            TreeNode left = root.left;
            if (left != null && left.left == null && left.right == null) {
                sum += left.val;
            }
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);
        }

        return sum;
    }

    /**
     * Runtime: 2 ms, faster than 30.00% of Java online submissions for Sum of Left Leaves.
     * Memory Usage: 39.5 MB, less than 26.00% of Java online submissions for Sum of Left Leaves.
     */
    public int sumOfLeftLeavesByStack(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                TreeNode left = root.left;
                if (left != null && left.left == null && left.right == null) {
                    sum += left.val;
                }
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                root = pop.right;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(new int[]{3, 20});
        binaryTree.getRoot().left = new TreeNode(9);
        binaryTree.getRoot().right.left = new TreeNode(15);
        binaryTree.getRoot().right.right = new TreeNode(7);
        System.out.println(binaryTree);
        S_404SumOfLeftLeaves sumOfLeftLeaves = new S_404SumOfLeftLeaves();
        System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(binaryTree.getRoot()));
    }
}
