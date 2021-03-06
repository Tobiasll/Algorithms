package com.tobias.leetcode.array;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class S_215KthLargestElementInAnArray {

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int num : nums) {
      priorityQueue.add(num);
      if (priorityQueue.size() > k) {
        priorityQueue.remove();
      }
    }

    return priorityQueue.remove();
  }

  public int findKthLargestBySort(int[] nums, int k) {
    Arrays.sort(nums);
    return k > nums.length ? nums[nums.length - 1] : nums[nums.length - k];
  }

  public static void main(String[] args) {
    S_215KthLargestElementInAnArray kthLargestElementInAnArray = new S_215KthLargestElementInAnArray();
    System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
  }
}
