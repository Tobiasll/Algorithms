package com.tobias.code_guide_to_programing_interview.chapter1;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxTree {

  class Node {

    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
    }
  }

  public Node getMaxTree(int[] arr) {
    Node[] nodes = new Node[arr.length];
    for (int i = 0; i < arr.length; i++) {
      nodes[i] = new Node(arr[i]);
    }
    Stack<Node> stack = new Stack<>();
    Map<Node, Node> lmap = new HashMap<>();
    Map<Node, Node> rmap = new HashMap<>();
    Node head = null;
    for (int i = 0; i != nodes.length; i++) {
      Node currentNode = nodes[i];

      while (!stack.isEmpty() && stack.peek().value < currentNode.value) {
        popAndSetMap(stack, lmap);
      }
      stack.push(currentNode);
    }
    while (!stack.isEmpty()) {
      popAndSetMap(stack, lmap);
    }

    for (int i = nodes.length - 1; i != -1; i--) {
      Node currentNode = nodes[i];
      while (!stack.isEmpty() && stack.peek().value < currentNode.value) {
        popAndSetMap(stack, rmap);
      }
      stack.push(nodes[i]);
    }
    while (!stack.isEmpty()) {
      popAndSetMap(stack, rmap);
    }
    for (int i = 0; i != nodes.length; i++) {
      Node currentNode = nodes[i];
      Node left = lmap.get(currentNode);
      Node right = rmap.get(currentNode);
      if (left == null && right == null){
       head = currentNode;
      } else if (left == null) {
        if (right.left == null) {
          right.left= currentNode;
        } else {
          right.right = currentNode;
        }
      } else if (right == null) {
        if (left.left == null) {
          left.left = currentNode;
        } else {
          left.right = currentNode;
        }
      } else {
        Node parent = left.value < right.value ? left : right;
        if (parent.left == null) {
          parent.left = currentNode;
        } else {
          parent.right = currentNode;
        }
      }
    }

    return head;
  }

  private void popAndSetMap(Stack<Node> stack, Map<Node, Node> lmap) {
    Node popNode = stack.pop();
    if (stack.isEmpty()) {
      lmap.put(popNode, null);
    } else {
      lmap.put(popNode, stack.peek());
    }
  }


  public static void main(String[] args) {
    Node maxTree = new MaxTree().getMaxTree(new int[]{3, 4, 5, 1, 2});
//    Node maxTree = new MaxTree().getMaxTree(new int[]{3, 1, 2});
    System.out.println(maxTree.value);
  }
}
