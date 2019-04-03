package com.tobias.rudiment.bst;


import java.util.LinkedList;

class TreeNode {
  int val ;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }
}

public class Solution {

  private int[] array = { 1, 2, 7, 3, 5, 8, 9, 4, 6, 10, 11};
  private LinkedList<TreeNode> nodeList;
  private static int count = 0;

  public void createTree() {
    nodeList = new LinkedList<>();
    for (int i : array) {
      nodeList.add(new TreeNode(i));
    }
    //最后一个父节点在数组中的索引
    int lastParentIndex = array.length / 2 - 1;
    for(int parentInex = 0; parentInex < lastParentIndex; parentInex++) {
      nodeList.get(parentInex).left = nodeList.get(parentInex * 2 + 1);
      nodeList.get(parentInex).right = nodeList.get(parentInex * 2 + 2);
    }
    // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
    // 左孩子
    nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
    // 右孩子
    if(array.length % 2 == 1) {
      nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
    }
  }

  // 层次遍历
  public void levelTraverse(TreeNode root) {
    if(root == null) return;

    LinkedList<TreeNode> list = new LinkedList<>();
    list.add(root);
    while(list.size() != 0) {
      TreeNode node = list.removeFirst();
      System.out.print(node.val + " ");
      if(node.left != null) {
        list.add(node.left);
      }
      if(node.right != null) {
        list.add(node.right);
      }
    }
    System.out.println();
  }


  public TreeNode invertTree(TreeNode root) {
    if(root == null){
      count++;
      return null;
    }
    invertTree(root.left);
    invertTree(root.right);
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    return root;
  }


  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.createTree();
    solution.levelTraverse(solution.nodeList.get(0));
    TreeNode treeNode = solution.invertTree(solution.nodeList.get(0));
    System.out.println(treeNode.val);
    solution.levelTraverse(solution.nodeList.get(0));
    System.out.println(count);
  }
}
