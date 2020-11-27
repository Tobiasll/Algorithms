package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 *
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 *
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * Output: "1(2(4))(3)"
 *
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 */
public class S_606ConstructStringFromBinaryTree {

    private void tree2StrHelper(TreeNode root, TreeNode parent, StringBuilder sb) {
        if (root == null) {
            if (parent.left != null && parent.right != null) {
                sb.append("()");
            }
            return;
        }
        sb.append('(').append(root.val);
        tree2StrHelper(root.left, root, sb);
        tree2StrHelper(root.right, root, sb);
        sb.append(')');
    }

    public String tree2str(TreeNode t) {

        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        tree2StrHelper(t.left, t, sb);
        tree2StrHelper(t.right, t, sb);

        return sb.toString();
    }



    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(new int[]{1, 3});
        binaryTree.getRoot().left = new TreeNode(2);
        binaryTree.getRoot().left.right = new TreeNode(4);
        System.out.println(binaryTree);
        S_606ConstructStringFromBinaryTree constructStringFromBinaryTree = new S_606ConstructStringFromBinaryTree();
        System.out.println(constructStringFromBinaryTree.tree2str(binaryTree.getRoot()));
    }
}
