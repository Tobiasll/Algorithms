package com.tobias.rudiment.trie;

import java.util.TreeMap;

public class Trie {

  class Node {
    boolean isWord;
    TreeMap<Character, Node> next;

    Node(boolean isWord) {
      this.isWord = isWord;
      next = new TreeMap<>();
    }

    Node() {
      this(false);
    }
  }

  Trie() {
    this.root = new Node();
  }

  private Node root;
  private int size;

  public int getSize() {
    return size;
  }

  public void add(String words) {

    Node currentNode = root;
    for (int i = 0; i < words.length(); i++) {
      if (currentNode.next.get(words.charAt(i)) == null) {
        currentNode.next.put(words.charAt(i), new Node());
      }
      currentNode = currentNode.next.get(words.charAt(i));
    }

    if (!currentNode.isWord) {
      currentNode.isWord = true;
      size++;
    }

  }

  public static void main(String[] args) {
    new Trie().add("tst");

  }

}
