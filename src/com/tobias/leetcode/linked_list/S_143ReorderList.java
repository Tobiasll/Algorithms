package com.tobias.leetcode.linked_list;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class S_143ReorderList {


  public void reorderList(ListNode head) {
    List<ListNode> list = new ArrayList<>();
    while (head != null) {
      list.add(head);
      head = head.next;
    }
    int i = 0;

    for (int j = list.size() - 1; i < j; j--) {
      list.get(i).next = list.get(j);
      i++;
      list.get(j).next = list.get(i);
    }
    list.get(i).next = null;
  }

    /**
     * Runtime: 755 ms, faster than 5.02% of Java online submissions for Reorder List.
     * Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for Reorder List.
     */
  public void reorderList1(ListNode head) {

    ListNode curRoot = head;
    while (curRoot != null && curRoot.next != null && curRoot.next.next != null) {
      ListNode tail = curRoot;
      while (tail.next.next != null) {
        tail = tail.next;
      }

      ListNode lastNode = curRoot.next;
      curRoot.next = tail.next;
      tail.next = null;
      curRoot.next.next = lastNode;

      curRoot = lastNode;
    }
  }

  public static void main(String[] args) {
    S_143ReorderList reorderList = new S_143ReorderList();
    ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5});
//    ListNode listNode = new ListNode(new int[]{1, 2});
    reorderList.reorderList(listNode);
    System.out.println(listNode);
  }
}
