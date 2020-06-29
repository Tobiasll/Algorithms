package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

/**
 *Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class S_235LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode left, TreeNode right) {

        if (left.val > right.val) {
            return lowestCommonAncestorRecursion(root, right, left);
        }

        if (root.val > right.val) {
            return lowestCommonAncestorRecursion(root.left, left, right);
        } else if (root.val < left.val) {
            return lowestCommonAncestorRecursion(root.right, left, right);
        } else {
            return root;
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        while (true) {
            if (root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            } else {
                return root;
            }
        }

    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(new int[]{6,2,8,0,4,7,9,3,5});
        TreeNode root = binaryTree.getRoot();
        System.out.println(binaryTree);
        S_235LowestCommonAncestorOfBinarySearchTree s_235LowestCommonAncestorOfBinarySearchTree = new S_235LowestCommonAncestorOfBinarySearchTree();
        TreeNode treeNode = s_235LowestCommonAncestorOfBinarySearchTree.lowestCommonAncestor(root, root.left, root.left.right);
        binaryTree.setRoot(treeNode);
        System.out.println(binaryTree);
    }
}
