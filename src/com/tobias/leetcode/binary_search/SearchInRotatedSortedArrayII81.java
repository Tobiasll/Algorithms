package com.tobias.leetcode.binary_search;


/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedSortedArrayII81 {




  public boolean search(int[] nums, int target) {

    int left, right, midIndex = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i + 1] < nums[i]) {
        midIndex = i + 1;
        break;
      }
    }
    if (midIndex > 0 && target <= nums[midIndex - 1] && target >= nums[0]) {
      left = 0;
      right = midIndex - 1;
    } else {
      left = midIndex;
      right = nums.length - 1;
    }

    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    SearchInRotatedSortedArrayII81 searchInRotatedSortedArrayII81 = new SearchInRotatedSortedArrayII81();
    System.out.println(searchInRotatedSortedArrayII81.search(new int[]{2,5,6,0,0,1,2}, 0));
    System.out.println(searchInRotatedSortedArrayII81.search(new int[]{2,5,6,7,0,1,1,2}, 3));
    System.out.println(searchInRotatedSortedArrayII81.search(new int[]{}, 3));
    System.out.println(searchInRotatedSortedArrayII81.search(new int[]{3,5 ,1}, 1));
  }
}
