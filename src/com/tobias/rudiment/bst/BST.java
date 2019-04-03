package com.tobias.rudiment.bst;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

  private class Node {

    E e;
    Node left;
    Node right;

    public Node(E e) {
      this.e = e;
      this.left = null;
      this.right = null;
    }
  }

  public BST() {
    root = null;
    size = 0;
  }

  public Node getLeft(Node node) {
     return node.left;
  }

  public Node getRight(Node node) {
    return node.right;
  }

  private Node root;
  private int size;

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void add(E e) {
 /*   if (size == 0) {
      root = new Node(e);
      size++;
    } else {
      add1(e, root);
    }*/
    root = add2(e, root);
  }

  private void add1(E e, Node node) {

    if (e.compareTo(node.e) == 0) {
      return;
    } else if (e.compareTo(node.e) < 0 && node.left == null) {
      node.left = new Node(e);
      size++;
      return;
    } else if (e.compareTo(node.e) > 0 && node.right == null) {
      node.right = new Node(e);
      size++;
      return;
    }

    if (e.compareTo(node.e) < 0) {
      add1(e, node.left);
    } else {
      add1(e, node.right);
    }
  }

  public void addForEach(E e) {
    Node node = root;
    if (isEmpty()) {
      root = new Node(e);
      size++;

    } else {

      while (node != null) {
        if (e.compareTo(node.e) < 0) {
          if (node.left == null) {
            node.left = new Node(e);
            size++;
            break;
          }
          node = node.left;

        } else if (e.compareTo(node.e) > 0) {
          if (node.right == null) {
            node.right = new Node(e);
            size++;
            break;
          }
          node = node.right;
        }
      }
    }

  }

  private Node add2(E e, Node node) {
    if (node == null) {
      size++;
      return new Node(e);

    }

    if (e.compareTo(node.e) < 0) {
      node.left = add2(e, node.left);
    } else {
      node.right = add2(e, node.right);
    }
    return node;
  }

  public boolean contain(E e) {
    return contain(e, root);
  }

  public boolean contain(E e, Node node) {

    if (node == null) {
      return false;
    }

    if (e.compareTo(node.e) == 0) {
      return true;
    } else if (e.compareTo(node.e) < 0) {
      return contain(e, node.left);
    } else {
      return contain(e, node.right);
    }

  }

  // 二分搜索树的前序遍历
  public void preOrder() {
    StringBuilder sb = new StringBuilder();
    preOrder(root, sb);
    System.out.println(sb.toString());
  }

  public void inOrder() {
    StringBuilder sb = new StringBuilder();
    inOrder(root, sb);
    System.out.println(sb.toString());
  }

  public void postOrder() {
    StringBuilder sb = new StringBuilder();
    postOrder(root, sb);
    System.out.println(sb.toString());
  }

  private void preOrder(Node node, StringBuilder sb) {
    if (node == null) {
      return;
    }
    sb.append(node.e).append("-->");
    preOrder(node.left, sb);
    preOrder(node.right, sb);
  }

  public void preOrderNR() {
    StringBuilder sb = new StringBuilder();
    preOrderNR(root, sb);
    System.out.println(sb.toString());
  }
  private void preOrderNR(Node node, StringBuilder sb) {
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node cur = stack.pop();
      sb.append(cur.e).append("-->");
      if (cur.right != null) {
        stack.push(cur.right);
      }
      if (cur.left != null) {
        stack.push(cur.left);
      }

    }
  }

  private void levelOrder() {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      System.out.print(node.e + "-->");
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }
  }

  private void inOrder(Node node, StringBuilder sb) {
    if (node == null) {
      return;
    }
    inOrder(node.left, sb);
    sb.append(node.e).append("-->");
    inOrder(node.right, sb);
  }

  private void postOrder(Node node, StringBuilder sb) {
    if (node == null) {
      return;
    }
    postOrder(node.left, sb);
    postOrder(node.right, sb);
    sb.append(node.e).append("-->");
  }

  public E minNode() {
    if(size == 0)
      throw new IllegalArgumentException("BST is empty");

    return minNode(root).e;
  }

  private Node minNode(Node node) {
    if (node.left == null) {
      return node;
    }
    return minNode(node.left);
  }

  public E maxNode() {
    if(size == 0)
      throw new IllegalArgumentException("BST is empty");

    return maxNode(root).e;
  }


  private Node maxNode(Node node) {
    if (node.right == null) {
      return node;
    }
    return maxNode(node.right);
  }

  // 从二分搜索树中删除最小值所在节点, 返回最小值
  public E removeMin(){
    E ret = minNode();
    root = removeMin(root);
    return ret;
  }

  // 删除掉以node为根的二分搜索树中的最小节点
  // 返回删除节点后新的二分搜索树的根
  private Node removeMin(Node node){

    if(node.left == null){
      Node rightNode = node.right;
      node.right = null;
      size --;
      return rightNode;
    }

    node.left = removeMin(node.left);
    return node;
  }

  public E removeMax() {
    E max = maxNode();
    root = removeMax(root);
    return max;
  }

  private Node removeMax(Node node) {
    if (node.right == null) {
      Node leftNode = node.left;
      node.left = null;
      size--;
      return leftNode;
    }

    node.right = removeMax(node.right);
    return node;
  }

  // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
  // 返回删除节点后新的二分搜索树的根
  private Node remove(Node node, E e){

    if( node == null )
      return null;

    if( e.compareTo(node.e) < 0 ){
      node.left = remove(node.left , e);
      return node;
    }
    else if(e.compareTo(node.e) > 0 ){
      node.right = remove(node.right, e);
      return node;
    }
    else{   // e.compareTo(node.e) == 0

      // 待删除节点左子树为空的情况
      if(node.left == null){
        Node rightNode = node.right;
        node.right = null;
        size --;
        return rightNode;
      }

      // 待删除节点右子树为空的情况
      if(node.right == null){
        Node leftNode = node.left;
        node.left = null;
        size --;
        return leftNode;
      }

      // 待删除节点左右子树均不为空的情况

      // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
      // 用这个节点顶替待删除节点的位置
      Node successor = minNode(node.right);
      successor.right = removeMin(node.right);
      successor.left = node.left;

      node.left = node.right = null;

      return successor;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    preOrder(root, sb);
    return sb.toString();
  }

  public static void main(String[] args) {

    BST<Integer> bst = new BST<>();
//    bst.addForEach(5);
//    bst.addForEach(3);
//    bst.addForEach(6);
    int[] nums = {5, 3, 6, 8, 4, 2};
    for (int num : nums) {
      bst.add(num);
    }
//    bst.addForEach(2);
    /////////////////
    //      5      //
    //    /   \    //
    //   3    6    //
    //  / \    \   //
    // 2  4     8  //
    /////////////////
    bst.preOrder();
    bst.preOrderNR();
    bst.inOrder();
    bst.postOrder();
    bst.levelOrder();
    System.out.println();
    System.out.println(bst);

    System.out.println(bst.contain(2));
    System.out.println(bst.minNode());
    System.out.println(bst.maxNode());
    System.out.println(bst.removeMin());
    System.out.println(bst.removeMax());
    System.out.println(bst);


  }

}
