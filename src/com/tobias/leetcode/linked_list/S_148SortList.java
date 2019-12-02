package com.tobias.leetcode.linked_list;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class S_148SortList {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    boolean hasSort = true;
    ListNode firstPoint = head;
    ListNode secondPoint = head.next;

    while (secondPoint != null) {
      if (firstPoint.val > secondPoint.val) {
        int temp = firstPoint.val;
        firstPoint.val = secondPoint.val;
        secondPoint.val = temp;
        hasSort = false;
      }
      if (secondPoint.next == null && hasSort) {
        break;
      } else if (secondPoint.next == null && !hasSort){
        firstPoint = head;
        secondPoint = head.next;
        hasSort = true;
      } else {
        firstPoint = firstPoint.next;
        secondPoint = secondPoint.next;
      }
    }
    return head;
  }


  public ListNode sortList1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    Collections.sort(list);
    ListNode result = new ListNode(list.get(0));
    ListNode curRoot = result;
    for (int i = 1; i < list.size(); i++) {
      curRoot.next = new ListNode(list.get(i));
      curRoot = curRoot.next;
    }
    return result;
  }

  public static void main(String[] args) {
    S_148SortList sortList = new S_148SortList();
    System.out.println(sortList.sortList(new ListNode(new int[]{4, 2, 1, 3})));
  }

}
