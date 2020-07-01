package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

import java.util.*;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 *
 *        3
 *    5   '   1
 *  6 ' 2   0 ' 8
 * n'n 7'4 n'n n'n
 */
public class S_236LowestCommonAncestorBinaryTree {


    /**
     * Runtime: 8 ms, faster than 32.57% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 45.4 MB, less than 13.49% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftTreeNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTreeNode = lowestCommonAncestor(root.right, p, q);

        if (leftTreeNode == null) {
            return rightTreeNode;
        } else if (rightTreeNode == null) {
            return leftTreeNode;
        }
        return root;

    }

        /**
         * Runtime: 241 ms, faster than 5.01% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
         * Memory Usage: 43.9 MB, less than 19.05% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
         */
    public TreeNode lowestCommonAncestorMidOrder(TreeNode root, TreeNode p, TreeNode q) {

        if (root == p || root == q) {
            return root;
        }

        TreeNode cur = root.left;
        Stack<TreeNode> stack = new Stack<>();
        boolean pLeft = false;
        boolean qLeft = false;

        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();


            if (cur == p) {
                pLeft = true;
            }
            if (cur == q) {
                qLeft = true;
            }
            if (pLeft && qLeft) {
                break;
            }
            cur = cur.right;

        }

        if (qLeft && pLeft) {
            return lowestCommonAncestorMidOrder(root.left, p, q);
        } else if (!qLeft && !pLeft) {
            return lowestCommonAncestorMidOrder(root.right, p, q);
        }

        return root;
    }

    /**
     * Runtime: 10 ms, faster than ?% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 40.3 MB, less than ?% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     */
    public TreeNode lowestCommonAncestorWithForEach(TreeNode root, TreeNode p, TreeNode q) {

        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        stack.push(root);
        parent.put(root, null);

        while (!parent.containsKey(q) || !parent.containsKey(p)) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                parent.put(cur.left, cur);
                stack.push(cur.left);
            }
            if (cur.right != null) {
                parent.put(cur.right, cur);
                stack.push(cur.right);
            }
        }

        Set<TreeNode> set = new HashSet<>();

        while (p != null) {
            set.add(p);
            p = parent.get(p);
        }

        while (q != null) {

            if (set.contains(q)) {
                break;
            }
            q = parent.get(q);
        }

        return q;
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(new int[]{3});
        binaryTree.getRoot().left = new TreeNode(5);
        binaryTree.getRoot().right = new TreeNode(1);
        binaryTree.getRoot().left.left = new TreeNode(6);
        binaryTree.getRoot().left.right = new TreeNode(2);
        binaryTree.getRoot().right.left = new TreeNode(0);
        binaryTree.getRoot().right.right = new TreeNode(8);
        binaryTree.getRoot().left.right.left = new TreeNode(7);
        binaryTree.getRoot().left.right.right = new TreeNode(4);

        System.out.println(binaryTree);

        S_236LowestCommonAncestorBinaryTree s_236LowestCommonAncestorBinaryTree = new S_236LowestCommonAncestorBinaryTree();
        TreeNode treeNode = s_236LowestCommonAncestorBinaryTree.lowestCommonAncestor(binaryTree.getRoot(), binaryTree.getRoot().left, binaryTree.getRoot().left.right.right);
        binaryTree.setRoot(treeNode);
        System.out.println(binaryTree);

    }
}
