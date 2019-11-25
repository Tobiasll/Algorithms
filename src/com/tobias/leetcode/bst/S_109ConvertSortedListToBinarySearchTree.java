package com.tobias.leetcode.bst;


import com.tobias.rudiment.linkedlist.ListNode;
import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class S_109ConvertSortedListToBinarySearchTree {


  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    List<Integer> nums = new ArrayList<>();
    while (head != null) {
      nums.add(head.val);
      head = head.next;
    }

    return sortedListToBST(nums, 0, nums.size());
  }

  private TreeNode sortedListToBST(List<Integer> nums, int start, int end) {
    if (start == end) {
      return null;
    }
    int mid = (start + end) >>> 1;
    TreeNode root = new TreeNode(nums.get(mid));
    root.left = sortedListToBST(nums, start, mid);
    root.right = sortedListToBST(nums, mid + 1, end);
    return root;
  }

  public static void main(String[] args) {
    S_109ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new S_109ConvertSortedListToBinarySearchTree();
    TreeNode root = convertSortedListToBinarySearchTree.sortedListToBST(new ListNode(new int[]{-10, -3, 0, 5, 9}));
    System.out.println(new BinaryTree(root));
  }

}
