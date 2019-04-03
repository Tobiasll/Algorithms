package com.tobias.leetcode.linked_list;

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
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
    StringBuilder sb = new StringBuilder();

    ListNode cur = this;

    while (cur != null) {
      sb.append(cur.val).append("-->");
      cur = cur.next;
    }

    return sb.toString();
  }
}

public class ReverseList {

  public static void main(String[] args) {
    ListNode listNode = new ListNode(new int[]{1, 2, 3});

    System.out.println(listNode);
  }

  private static void reverseList(int[] arr) {

  }

}
