package com.tobias.leetcode.linked_list;


/**
 * Sort a linked list using insertion sort.
 *
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
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
public class S_147InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode temp = dummy;
            ListNode headNext = head.next;
            head.next = null;
            while (temp.next != null) {
                if (temp.next.val >= head.val) {
                    ListNode tempTail = temp.next;
                    temp.next = head;
                    head.next = tempTail;
                    break;
                }
                temp = temp.next;
            }
            if (temp.next == null) {
                temp.next = head;
            }
            head = headNext;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{-1,5,3,4,0});
        System.out.println(listNode);
        S_147InsertionSortList insertionSortList = new S_147InsertionSortList();
        System.out.println(insertionSortList.insertionSortList(listNode));
    }
}
