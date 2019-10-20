package com.tobias.leetcode.linked_list;

public class ListNode {

  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public ListNode(int[] arr) {
    if (arr == null || arr.length == 0) {
//      throw new IllegalArgumentException("arr can not be empty");
    }
    if (arr.length > 0) {
      this.val = arr[0];
      ListNode current = this;
      for (int i = 1; i < arr.length; i++) {
        current.next = new ListNode(arr[i]);
        current = current.next;
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    ListNode cur = this;

    while (cur != null) {
      sb.append(cur.val).append("-->");
      cur = cur.next;
    }

    return sb.toString();
  }

  public int getVal() {
    return this.val;
  }

  public ListNode getNext() {
    return next;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5, 6});
    System.out.println(listNode);
  }
}