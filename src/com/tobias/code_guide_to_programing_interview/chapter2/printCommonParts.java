package com.tobias.code_guide_to_programing_interview.chapter2;

import com.tobias.leetcode.linked_list.ListNode;

public class printCommonParts {


  public static void printCommonParts(ListNode head1, ListNode head2) {
    while (head1 != null && head2 != null) {
      if (head1.getVal() < head2.getVal()) {
        head1 = head1.getNext();
      } else if (head1.getVal() > head2.getVal()) {
        head2 = head2.getNext();
      } else if (head1.getVal() == head2.getVal()) {
        System.out.println(head1.getVal());
        head1 = head1.getNext();
        head2 = head2.getNext();
      }
    }
  }

  public static void main(String[] args) {
    ListNode head1 = new ListNode(new int[]{1, 3, 4, 5, 7, 10});
    ListNode head2 = new ListNode(new int[]{2, 3, 6, 7, 8, 9});
    printCommonParts(head1, head2);
  }


}
