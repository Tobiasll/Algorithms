package com.tobias.leetcode.array;


/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */
public class RemoveDuplicatesFromSortedArrayII80 {

  public int removeDuplicates(int[] nums) {
    int slow = 1;
    for (int max = 2, fast = 2; fast < nums.length; fast++) {
      if (nums[slow - max + 1] != nums[fast]) {
        nums[++slow] = nums[fast];
      }
    }
    return slow + 1;
  }


    public int removeDuplicates1(int[] nums) {
    int slow = 0;

    for (int fast = 1, count = 1; fast < nums.length; fast++) {
      //当前遍历的数字和慢指针末尾数字不同，就加到慢指针的末尾
      if (nums[fast] != nums[slow]) {
        nums[++slow] = nums[fast];
        //当前数字置为 1 个
        count = 1;

      } else {
        //和末尾数字相同，考虑当前数字的个数，小于 2 的话，就加到慢指针的末尾
        if (count < 2) {
          nums[++slow] = nums[fast];
          //当前数字加 1
          count++;
        }
      }
    }
    return slow + 1;
  }



  public static void main(String[] args) {
    RemoveDuplicatesFromSortedArrayII80 removeDuplicatesFromSortedArrayII80 = new RemoveDuplicatesFromSortedArrayII80();
    System.out.println(removeDuplicatesFromSortedArrayII80.removeDuplicates(new int[]{1,1,1,2,2,3}));
    System.out.println(removeDuplicatesFromSortedArrayII80.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
  }
}
