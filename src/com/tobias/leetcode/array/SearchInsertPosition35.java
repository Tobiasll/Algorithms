package com.tobias.leetcode.array;


/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5 Output: 2 Example 2:
 *
 * Input: [1,3,5,6], 2 Output: 1 Example 3:
 *
 * Input: [1,3,5,6], 7 Output: 4 Example 4:
 *
 * Input: [1,3,5,6], 0 Output: 0
 */
public class SearchInsertPosition35 {

  public int searchInsert(int[] nums, int target) {
    if (nums.length == 0) {
      return 0;
    }
    int start = 0, end = nums.length - 1;
    int mid = 0;
    while (start <= end) {
      mid = (end + start) / 2;
      if (nums[mid] > target) {
        end = mid - 1;
      } else if (nums[mid] < target) {
        start = mid + 1;
      } else if (nums[mid] == target) {
        return mid;
      }
    }
    return nums[mid] < target ? mid + 1 : mid;
  }

  public static void main(String[] args) {
    SearchInsertPosition35 searchInsertPosition35 = new SearchInsertPosition35();
    System.out.println(searchInsertPosition35.searchInsert(new int[]{1, 3, 5, 6}, 5));
    System.out.println(searchInsertPosition35.searchInsert(new int[]{1, 3, 5, 6}, 2));
    System.out.println(searchInsertPosition35.searchInsert(new int[]{1, 3, 5, 6}, 7));
    System.out.println(searchInsertPosition35.searchInsert(new int[]{1, 3, 5, 6}, 0));
  }
}
