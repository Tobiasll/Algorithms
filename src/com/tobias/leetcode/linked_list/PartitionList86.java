package com.tobias.leetcode.linked_list;


/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3 Output: 1->2->2->4->3->5
 */
public class PartitionList86 {

  public ListNode partition2(ListNode head, int x) {
    ListNode minListNode = new ListNode(0);
    ListNode minRoot = minListNode;
    ListNode maxListNode = new ListNode(0);
    ListNode maxRoot = maxListNode;

    while (head != null) {
      if (head.val < x) {
        minRoot.next = new ListNode(head.val);
        minRoot = minRoot.next;
      } else {
        maxRoot.next = new ListNode(head.val);
        maxRoot = maxRoot.next;
      }
      head = head.next;
    }
    minRoot.next = maxListNode.next;
    return minListNode.next;
  }

  public ListNode partition(ListNode head, int x) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode tail = null;
    head = dummy;
    //找到第一个大于等于分区点的节点，tail 指向它的前边
    while (head.next != null) {
      if (head.next.val >= x) {
        tail = head;
        head = head.next;
        break;
      } else {
        head = head.next;
      }
    }
    while (head.next != null) {
      //如果当前节点小于分区点，就把它插入到 tail 的后边
      if (head.next.val < x) {
        //拿出要插入的节点
        ListNode move = head.next;
        //将要插入的结点移除
        head.next = move.next;
        //将 move 插入到 tail 后边
        move.next = tail.next;
        tail.next = move;
        //更新 tail
        tail = move;
      } else {
        head = head.next;
      }

    }
    return dummy.next;
  }


  public static void main(String[] args) {
    PartitionList86 partitionList86 = new PartitionList86();
    System.out.println(partitionList86.partition2(new ListNode(new int[]{1, 4, 3, 2, 5, 2}), 3));
    System.out.println(partitionList86.partition2(new ListNode(new int[]{2, 1}), 2));
  }
}
