package com.tobias.cat;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一棵二叉树，返回其节点值的前序遍历。
 *
 * 样例 样例 1:
 *
 * 输入：{1,2,3} 输出：[1,2,3] 解释： 1 / \ 2   3 它将被序列化为{1,2,3} 前序遍历 样例 2:
 *
 * 输入：{1,#,2,3} 输出：[1,2,3] 解释： 1 \ 2 / 3 它将被序列化为{1,#,2,3} 前序遍历 挑战 你能使用非递归实现么？
 *
 * 注意事项 首个数据为根节点，后面接着是其左儿子和右儿子节点值，"#" 表示不存在该子节点。 节点数量不超过 20
 */
public class Solution66 {

  public List<Integer> preorderTraversal(TreeNode root) {
    // write your code here
    List<Integer> list = new ArrayList<>();
    getNodes(root, list);
    return list;
  }

  private void getNodes(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.val);
    getNodes(root.left, list);
    getNodes(root.right, list);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    Solution66 solution66 = new Solution66();
    List<Integer> list = solution66.preorderTraversal(root);
    System.out.println(list);
  }
}
