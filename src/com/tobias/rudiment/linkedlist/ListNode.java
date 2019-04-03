package com.tobias.rudiment.linkedlist;

//Definition for singly-linked list.
public class ListNode {

  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public ListNode(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("arr can not be empty");
    }
    this.val = arr[0];
    ListNode current = this;
    for (int i = 1; i < arr.length; i++) {
      current.next = new ListNode(arr[i]);
      current = current.next;
    }
  }


  @Override
  public String toString() {

    StringBuilder res = new StringBuilder();
    ListNode current = this;
    while (current != null) {
      res.append(current.val).append("->");

      current = current.next;
    }
    return res.toString();
  }

  public static void main(String[] args) {

    ListNode listNode = new ListNode(new int[]{1, 2, 3});
    System.out.println(listNode);
  }
}