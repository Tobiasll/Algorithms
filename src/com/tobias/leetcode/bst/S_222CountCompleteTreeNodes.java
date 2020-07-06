package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 */
public class S_222CountCompleteTreeNodes {

    private int result = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root;
        int leftHeight = 0;
        while (left != null) {
            left = left.left;
            leftHeight++;
        }

        TreeNode right = root;
        int rightHeight = 0;
        while (right != null) {
            right = right.right;
            rightHeight++;
        }

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    public int countNodesPreOrderTravel(TreeNode root) {
        preOrderTravel(root);
        return result;
    }

    public void preOrderTravel(TreeNode treeNode) {
        if (treeNode != null) {
            result++;
            preOrderTravel(treeNode.left);
            preOrderTravel(treeNode.right);
        }
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(new int[]{1, 3});
        binaryTree.getRoot().left = new TreeNode(2);
        binaryTree.getRoot().left.left = new TreeNode(4);
        binaryTree.getRoot().left.right = new TreeNode(5);
        binaryTree.getRoot().right.left = new TreeNode(6);
        binaryTree.getRoot().right.right = new TreeNode(7);
        System.out.println(binaryTree);

        S_222CountCompleteTreeNodes s_222CountCompleteTreeNodes = new S_222CountCompleteTreeNodes();
        System.out.println(s_222CountCompleteTreeNodes.countNodes(binaryTree.getRoot()));
    }
}
