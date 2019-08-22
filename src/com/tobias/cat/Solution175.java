package com.tobias.cat;


class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
 }

/**
 * 翻转一棵二叉树。左右子树交换。
 *
 * 样例
 * 样例 1:
 *
 * 输入: {1,3,#}
 * 输出: {1,#,3}
 * 解释:
 * 	  1    1
 * 	 /  =>  \
 * 	3        3
 * 样例 2:
 *
 * 输入: {1,2,3,#,#,4}
 * 输出: {1,3,2,#,4}
 * 解释:
 *
 *       1         1
 *      / \       / \
 *     2   3  => 3   2
 *        /       \
 *       4         4
 * 挑战
 * 递归固然可行，能否写个非递归的？
 */
public class Solution175 {

  /**
   * @param root: a TreeNode, the root of the binary tree
   * @return: nothing
   */
  public void invertBinaryTree(TreeNode root) {
    // write your code here
  }

}
