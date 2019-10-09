package com.tobias.leetcode.linked_list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
 * complexity.
 *
 * Example:
 *
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists23 {

  public ListNode mergeKLists3(ListNode[] lists) {
    ListNode result = new ListNode(0);

    return result.next;
  }


    /**
     * Runtime: 1098 ms, faster than 5.01% of Java online submissions for Merge k Sorted Lists. Memory
     * Usage: 59.2 MB, less than 5.47% of Java online submissions for Merge k Sorted Lists.
     *
     * use isBreak : Runtime: 332 ms, faster than 5.48% of Java online submissions for Merge k Sorted
     * Lists. Memory Usage: 57.8 MB, less than 5.47% of Java online submissions for Merge k Sorted
     * Lists.
     */
  public ListNode mergeKLists2(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }
    ListNode result = new ListNode(0);
    ListNode root = result;

//    Set<Integer> nullCount = new HashSet<>(lists.length + 1);
    int index = -1;
//    while (nullCount.size() != lists.length) {
    while (true) {
      int number = Integer.MAX_VALUE;
      boolean isBreak = true;
      for (int i = 0; i < lists.length; i++) {
//        if (lists[i] == null) {
//          nullCount.add(i);
//          continue;
//        }
        if (lists[i] != null) {
          if (lists[i].val <= number) {
            index = i;
            number = lists[i].val;
          }
          isBreak = false;
        }
      }
      if (isBreak) {
        break;
      }
      if (index != -1 && lists[index] != null) {
//        root.next = new ListNode(lists[index].val);
//      优化，并不需要每次创建，改变指向即可
        root.next = lists[index];
        root = root.next;
        lists[index] = lists[index].next;
      }
    }
    return result.next;
  }


  public ListNode mergeKLists1(ListNode[] lists) {
    ListNode result = new ListNode(0);
    List<Integer> list = new ArrayList<>();
    for (ListNode listNode : lists) {
      ListNode root = listNode;
      while (root != null) {
        list.add(root.val);
        root = root.next;
      }
    }
    list.sort(Comparator.comparingInt(o -> o));
    ListNode root = result;
    for (Integer integer : list) {
      root.next = new ListNode(integer);
      root = root.next;
    }
    return result.next;
  }

  public static void main(String[] args) {
    MergeKSortedLists23 mergeKSortedLists23 = new MergeKSortedLists23();
    System.out
        .println(mergeKSortedLists23.mergeKLists1(new ListNode[]{new ListNode(new int[]{1, 4, 5}),
            new ListNode(new int[]{1, 3, 4}), new ListNode(new int[]{2, 6})}));
    System.out.println(mergeKSortedLists23.mergeKLists1(new ListNode[]{null, null}));
    System.out.println(mergeKSortedLists23.mergeKLists1(
        new ListNode[]{new ListNode(new int[]{1, 2, 2}), new ListNode(new int[]{1, 1, 2})}));

  }
}
