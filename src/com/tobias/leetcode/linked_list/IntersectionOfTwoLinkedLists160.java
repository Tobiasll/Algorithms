package com.tobias.leetcode.linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists: begin to intersect at node c1.
 *
 * Example 1: Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB
 * = 3 Output: Reference of the node with value = 8 Input Explanation: The intersected node's value
 * is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as
 * [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the
 * intersected node in A; There are 3 nodes before the intersected node in B.
 *
 * Example 2: Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2 Input Explanation: The intersected node's value is 2
 * (note that this must not be 0 if the two lists intersect). From the head of A, it reads as
 * [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected
 * node in A; There are 1 node before the intersected node in B.
 *
 * Example 3: Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2 Output:
 * null Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as
 * [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be
 * arbitrary values. Explanation: The two lists do not intersect, so return null.
 */
public class IntersectionOfTwoLinkedLists160 {


  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    ListNode a = headA;
    ListNode b = headB;

    while (a != b) {
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
    }

    return a;
  }

  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    ListNode result = new ListNode(0);
    ListNode rootA = headA;
    ListNode rootB = headB;
    List<Integer> listA = new ArrayList<>();
    List<Integer> listB = new ArrayList<>();
    while (rootA != null || rootB != null) {
      if (rootA != null) {
        listA.add(rootA.val);
        rootA = rootA.next;
      }
      if (rootB != null) {
        listB.add(rootB.val);
        rootB = rootB.next;
      }
    }
    int indexA = listA.size() - 1;
    int indexB = listB.size() - 1;
    ListNode resultRoot = result;
    while (indexA >= 0 && indexB >= 0 && listA.get(indexA).equals(listB.get(indexB))) {
      resultRoot.next = new ListNode(listA.get(indexA));
      resultRoot = resultRoot.next;
      indexA--;
      indexB--;
    }
    return result.next;
  }

  public static void main(String[] args) throws Exception {
    IntersectionOfTwoLinkedLists160 intersectionOfTwoLinkedLists160 = new IntersectionOfTwoLinkedLists160();
    System.out.println(intersectionOfTwoLinkedLists160.getIntersectionNode(new ListNode(new int[]{0,9,1,2,4}), new ListNode(new int[]{3,2,4})));

    // 测试并行流执行是否会出现join
    List<Thread> list = new ArrayList<>();
    for (int i = 1; i < 10; i++) {
      list.add(new Thread(() -> System.out.println(Thread.currentThread().getName() + " 当前线程执行"),
          "线程" + i));
    }

//    list.add(new Thread(() -> {
//      try {
//        Thread.sleep(5000);
//      } catch (InterruptedException ignored) {
//      }
//      System.out.println(Thread.currentThread().getName() + " 当前线程执行");
//    }, "线程" + 10));
//
//    list.parallelStream().forEach(thread -> {
//      thread.start();
//      try {
//        if (thread.getName().contains("10")) {
//          thread.join();
////        Thread.sleep(6000);
//        }
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    });

    List<Integer> list2 = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list2.add(i);
    }

    list2.parallelStream().forEach(integer -> {
      if (integer.equals(5)) {
        try {
          Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
      }
      System.out.println(Thread.currentThread().getName() + " 执行数字 : " + integer);
    });
    System.out.println("主线程输出");
  }
}
