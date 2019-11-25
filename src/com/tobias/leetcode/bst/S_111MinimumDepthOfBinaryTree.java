package com.tobias.leetcode.bst;


import com.tobias.rudiment.trie.BinaryTree;
import com.tobias.rudiment.trie.BinaryTree.TreeNode;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import sun.misc.Unsafe;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class S_111MinimumDepthOfBinaryTree {

  public int minDepthByRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null) {
      return minDepth(root.right) + 1;
    }
    if (root.right == null) {
      return minDepth(root.left) + 1;
    }
    return Math.min(minDepthByRecursive(root.left), minDepthByRecursive(root.right)) + 1;
  }


  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int level = 0;
    boolean stopWhile = false;
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        TreeNode node = queue.poll();
        if (node.left == null && node.right == null) {
          stopWhile = true;
          break;
        }
        S_103BinaryTreeZigzagLevelOrderTraversal.offerValueToQueue(queue, node);
      }
      level++;
      if (stopWhile) {
        break;
      }
    }
    return level;
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    BinaryTree binaryTree = new BinaryTree(root);
    System.out.println(binaryTree);
    S_111MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new S_111MinimumDepthOfBinaryTree();
    System.out.println(minimumDepthOfBinaryTree.minDepthByRecursive(root));
    TreeNode treeNode = new TreeNode(1);
    treeNode.right = new TreeNode(2);
    binaryTree.setRoot(treeNode);
    System.out.println(binaryTree);
    System.out.println(minimumDepthOfBinaryTree.minDepthByRecursive(treeNode));
  }
}

class Test {

  private int count = 1;

  public void test() throws NoSuchFieldException, IllegalAccessException {
    // 获取unsafe实例
    Field field = Unsafe.class.getDeclaredField("theUnsafe");
    field.setAccessible(true);
    Unsafe unsafe = (Unsafe) field.get(null);

    // 获取count域的Field
    Field fieldCount = Test.class.getDeclaredField("count");
    fieldCount.setAccessible(true);

    // 计算count的内存偏移量
    long countOffset = (int) unsafe.objectFieldOffset(fieldCount);
    System.out.println(countOffset);
    System.out.println(unsafe.getInt(this, countOffset));
    // 原子性的更新指定偏移量的值（将count的值修改为3）
    unsafe.compareAndSwapInt(this, countOffset, count, 3);

    // 获取指定偏移量的int值
    System.out.println(unsafe.getInt(this, countOffset));
  }

}
