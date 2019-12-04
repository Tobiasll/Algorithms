package com.tobias.rudiment.trie;


import com.tobias.leetcode.bst.S_103BinaryTreeZigzagLevelOrderTraversal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

  private TreeNode root;
  private int size;

  public static class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(int x) {
      val = x;
    }


  }

  public BinaryTree() {

  }

  public BinaryTree(TreeNode root) {
    this.root = root;
  }

  public BinaryTree(int[] array) {
    for (int i : array) {
      add(i);
    }
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void add(int value) {
    root = add(value, root);
  }

  private TreeNode add(int value, TreeNode node) {
    if (node == null) {
      size++;
      return new TreeNode(value);
    }
    if (value <= node.val) {
      node.left = add(value, node.left);
    } else {
      node.right = add(value, node.right);
    }
    return node;
  }

  public TreeNode getRoot() {
    return root;
  }

  public void setRoot(TreeNode root) {
    this.root = root;
  }

  public void morrisPreOrderTravel(TreeNode root, StringBuilder sb) {
    TreeNode cur = root;
    while (cur != null) {
      if (cur.left == null) {
        sb.append(cur.val).append("->");
        cur = cur.right;
      } else {
        TreeNode pre = cur.left;
        while (pre.right != null && pre.right != cur) {
          pre = pre.right;
        }
        if (pre.right == null) {
          sb.append(cur.val).append("->");
          pre.right = cur;
          cur = cur.left;
        }
        if (pre.right == cur) {
          pre.right = null;
          cur = cur.right;
        }
      }
    }
  }

  public void morrisInOrderTravel(TreeNode root, StringBuilder sb) {
    TreeNode cur = root;
    while (cur != null) {
      if (cur.left == null) {
        sb.append(cur.val).append("->");
        cur = cur.right;
      } else {
        TreeNode pre = cur.left;
        while (pre.right != null && pre.right != cur) {
          pre = pre.right;
        }
        if (pre.right == null) {
          pre.right = cur;
          cur = cur.left;
        }
        if (pre.right == cur) {
          pre.right = null;
          sb.append(cur.val).append("->");
          cur = cur.right;
        }
      }
    }
  }

  public void postOrderMorrisTraversal(TreeNode root) {
    TreeNode dump = new TreeNode(0);
    dump.left = root;
    TreeNode cur = dump;
    while (cur != null) {
      // 情况 1
      if (cur.left == null) {
        cur = cur.right;
      } else {
        // 找左子树最右边的节点
        TreeNode pre = cur.left;
        while (pre.right != null && pre.right != cur) {
          pre = pre.right;
        }
        // 情况 2.1
        if (pre.right == null) {
          pre.right = cur;
          cur = cur.left;
        }
        // 情况 2.2,第二次遍历节点
        if (pre.right == cur){
          // 与其他三种遍历不同的地方，反转打印，图中的1-1、2-2、5-3、6-6、9-7
          printReverse(cur.left, pre);
          pre.right = null;
          cur = cur.right;
        }
      }
    }
  }

  private void printReverse(TreeNode from, TreeNode to) {
    // 将to 变成 form的反转节点 例如 from为5.right->4.r->3.r->9.r->.... to为3.right->9.r->8.r->...
    // 反转完，form的根节点还是5，from = 5.r->4.r->5.r->4.r->5.r->... to为from刚刚反转后的内容to = 3.r->4.r->5.r->4.r->...
    reverse(from, to, from.right);
    // 用一个临时遍历来保存to，并不断右移
    TreeNode tempNode = to;
    while (true) {
      // 打印to的内容，例如第一次，3，第二次，4，第三次，5
      System.out.println(tempNode.val);
      // 为了保证不会死循环打印下去，所以当to移到from的节点也就是5时，就结束掉整个循环
      if (tempNode == from) {
        break;
      }
      // 不断右移
      tempNode = tempNode.right;
    }
    // 将to 变成 from 的反转节点，反转后 from = 5.r->4.r->3.r->4.r->3.r->.... to = 3.r->4.r->3.r->4.r->....
    reverse(to, from, from.right);
  }

  private void reverse(TreeNode from, TreeNode to, TreeNode fromRight) {
    // 如果都是同一个节点的情况，例如图中的1，2，6
    if (from == to) {
      return;
    }
    // 遍历并反转
    do {
      TreeNode temp = fromRight.right;
      fromRight.right = from;
      from = fromRight;
      fromRight = temp;
    } while (from != to);
  }

  @Override
  public String toString() {
    return handleLevelTraversalList(levelTraversal(root));
  }

  private String handleLevelTraversalList(List<List<String>> list) {
    if (list.isEmpty()) {
      return "";
    }
    StringBuilder result = new StringBuilder();
    for (int i = list.size() - 2, blank = 1; i >= 0; i--, blank = 1 + (2 * blank)) {
      List<String> insideList = list.get(i);
      char[] blankChars = new char[blank];
      Arrays.fill(blankChars, ' ');
      String blankString = String.valueOf(blankChars);
      for (int j = 0; j < insideList.size(); j++) {
        insideList.set(j, blankString + insideList.get(j));
      }
    }

    for (List<String> strings : list) {
      for (String s : strings) {
        result.append(s);
      }
      result.append('\n');
    }
    return result.toString();
  }

  private List<List<String>> levelTraversal(TreeNode root) {
    List<List<String>> list = new ArrayList<>();
    if (root != null) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
        List<String> insideList = new ArrayList<>();
        int queueSize = queue.size();
        boolean isAllNull = true;
        boolean addBar = true;
        for (int i = 0; i < queueSize; i++) {
          root = queue.poll();
          if (root.val != Integer.MIN_VALUE) {
            insideList.add(root.val + "");
          } else {
            insideList.add("n");
          }
          if (addBar && i != queueSize - 1) {
            insideList.add("'");
          } else {
            insideList.add(" ");
          }
          addBar = !addBar;
          if (root.left != null) {
            isAllNull = false;
            queue.add(root.left);
          } else {
            queue.offer(new TreeNode(Integer.MIN_VALUE));
          }
          if (root.right != null) {
            isAllNull = false;
            queue.add(root.right);
          } else {
            queue.offer(new TreeNode(Integer.MIN_VALUE));
          }

        }
        list.add(insideList);
        if (isAllNull) {
          break;
        }
      }
    }
    return list;
  }

  public static void addLeftAndRightNodeToQueue(Queue<TreeNode> tempQueue, TreeNode pollNode) {
    if (pollNode.left != null) {
      tempQueue.add(pollNode.left);
    }
    if (pollNode.right != null) {
      tempQueue.add(pollNode.right);
    }
  }

  public static void offerLeftAndRightNodeToQueue(Queue<TreeNode> queue, TreeNode pollNode) {
    if (pollNode != null) {
      S_103BinaryTreeZigzagLevelOrderTraversal.offerValueToQueue(queue, pollNode);
    }
  }


  private void postOrderTraversalByIterator(TreeNode root, StringBuilder sb) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode last = null;
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        TreeNode peek = stack.peek();
        if (peek.right != null && peek.right != last) {
          root = peek.right;
        } else {
          peek = stack.pop();
          sb.append(peek.val).append(" -> ");
          last = peek;
        }
      }
    }
  }


  private void midOrderTraversalByIterator(TreeNode root, StringBuilder sb) {
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        TreeNode pop = stack.pop();
        sb.append(pop.val).append(" -> ");
        root = pop.right;
      }
    }
  }

  private void preOrderTraversalByIterator(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();

    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        sb.append(root.val).append(" -> ");
        stack.push(root);
        root = root.left;
      } else {
        TreeNode pop = stack.pop();
        root = pop.right;

      }
    }

  }


  private void preOrderTraversalByRecursive(TreeNode node, StringBuilder sb) {
    if (node != null) {
      preOrderTraversalByRecursive(node.left, sb);
      preOrderTraversalByRecursive(node.right, sb);
      sb.append(node.val).append(" -> ");
    }
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new int[]{6, 4, 8, 2, 5, 7, 9, 1, 3});
    StringBuilder sb = new StringBuilder();
    binaryTree.postOrderTraversalByIterator(binaryTree.getRoot(), sb);
    System.out.println(binaryTree);

  }
}
