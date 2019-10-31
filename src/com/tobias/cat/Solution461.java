package com.tobias.cat;

import java.util.PriorityQueue;

/**
 * 找到一个无序数组中第 K 小的数
 *
 * 样例 样例 1:
 *
 * 输入: [3, 4, 1, 2, 5], k = 3 输出: 3 样例 2:
 *
 * 输入: [1, 1, 1], k = 2 输出: 1 挑战 O (nlogn) 的算法固然可行，但如果你能 O (n) 解决，那就非常棒了.
 */
public class Solution461 {


  public int kthSmallest2(int k, int[] nums) {
    // write your code here
    if (nums == null || nums.length == 0) {
      return -1;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
    for (int num : nums) {
      pq.add(num);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    return pq.poll();
  }

  /**
   * @param k: An integer
   * @param nums: An integer array
   * @return: kth smallest element
   */
  public int kthSmallest(int k, int[] nums) {
    // write your code here
    if (nums == null || nums.length == 0) {
      return -1;
    }
    return findKth(nums, 0, nums.length - 1, k);
  }

  private int findKth(int[] nums, int start, int end, int k) {
    int left = start;
    int right = end;
    int pivot = nums[left + (right - left) / 2];
    while (left <= right) {
      while (left <= right && nums[left] < pivot) {
        left++;
      }
      while (left <= right && nums[right] > pivot) {
        right--;
      }
      if (left <= right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
      }
    }

    if (start + k - 1 <= right) {
      return findKth(nums, start, right, k);
    } else if (start + k - 1 >= left) {
      return findKth(nums, left, end, k - (left - start));
    } else {
      return nums[right + 1];
    }
  }

  public static void main(String[] args) {
    Solution461 solution461 = new Solution461();
    int i = solution461.kthSmallest2(3, new int[]{3, 4, 1, 2, 5});
    System.out.println(i);
  }
}
