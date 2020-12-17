package com.tobias.leetcode.array;


/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up:
 *
 * Could you come up with the O(n2) solution?
 * Could you improve it to O(n log(n)) time complexity?
 */
public class S_300LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE,0);
    }

    private int lengthOfLIS(int[] nums, int prev, int index) {
        if (index == nums.length) {
            return 0;
        }
        int maxLength = 0;
        if (nums[index] > prev) {
            maxLength = 1 + lengthOfLIS(nums, nums[index], index + 1);
        }
        int tempMaxLength = lengthOfLIS(nums, prev, index + 1);
        return Math.max(maxLength, tempMaxLength);
    }

    public static void main(String[] args) {
        S_300LongestIncreasingSubsequence longestIncreasingSubsequence = new S_300LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
