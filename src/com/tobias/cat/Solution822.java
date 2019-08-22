package com.tobias.cat;

import com.tobias.leetcode.linked_list.ListNode;
import java.util.ArrayList;
import java.util.List;



public class Solution822 {
  /**
   * @param head: the given linked list
   * @return: the array that store the values in reverse order
   */
  public List<Integer> reverseStore(ListNode head) {
    // write your code here
    List<Integer> list = new ArrayList<>();
    if (head == null) {
      return list;
    }
    traverseAndPutVal(head, list);
    return list;
  }

  private void traverseAndPutVal(ListNode head, List<Integer> list) {
    if (head == null) {
      return ;
    }
    traverseAndPutVal(head.next, list);
    list.add(head.val);
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(new int[]{5, 4, 2, 1});
    System.out.println(listNode);
    Solution822 solution822 = new Solution822();
    System.out.println(solution822.reverseStore(listNode));

  }
}
