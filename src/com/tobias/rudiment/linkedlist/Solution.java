package com.tobias.rudiment.linkedlist;

public class Solution {

  private ListNode removeElements1(ListNode head, int val) {
    if (head == null) {
      return null;
    }
    while (head != null && head.val == val) {
      head = head.next;
    }

    handleData(val, head);

    return head;
  }

  private ListNode removeElements2(ListNode head, int val) {


    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    handleData(val, dummyHead);

    return dummyHead.next;
  }

  private void handleData(int val, ListNode dummyHead) {
    ListNode prev = dummyHead;

    while(prev.next != null){
      if(prev.next.val == val) {
        prev.next = prev.next.next;
      }
      else {
        prev = prev.next;
      }
    }
  }

  private ListNode removeElements3(ListNode head, int val) {

    if (head == null) {
      return null;
    }

    head.next = removeElements3(head.next, val);

    if (head.val == val) {
      return head.next;
    } else {
      return head;
    }
  }

  public static void main(String[] args) {

    int[] nums = {2, 1, 3};
    ListNode head = new ListNode(nums);
    System.out.println(head);

    ListNode res = (new Solution()).removeElements3(head, 1);
    System.out.println(res);
  }

}
