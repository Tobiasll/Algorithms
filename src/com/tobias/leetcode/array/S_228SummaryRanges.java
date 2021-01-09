package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b
 * "a" if a == b
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 * <p>
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * Example 3:
 * <p>
 * Input: nums = []
 * Output: []
 * Example 4:
 * <p>
 * Input: nums = [-1]
 * Output: ["-1"]
 * Example 5:
 * <p>
 * Input: nums = [0]
 * Output: ["0"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 */
public class S_228SummaryRanges {


    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0, len = nums.length, j; i < len; i = j + 1) {
            j = getIndexByBinarySearch(nums, i, len);
            if (i != j) {
                result.add(nums[i] + "->" + nums[j]);

            } else {
                result.add(nums[i] + "");
            }
        }

        return result;
    }

    private int getIndexByBinarySearch(int[] nums, int start, int end) {
        while (start + 1 < end) {
            int mid = (end + start) / 2;
            if (nums[mid] - nums[start] == mid - start) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    /**
     * Runtime: 11 ms, faster than 6.41% of Java online submissions for Summary Ranges.
     * Memory Usage: 39.1 MB, less than 6.03% of Java online submissions for Summary Ranges.
     */
    public List<String> summaryRangesByLoop(int[] nums) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) {
                i++;
            }
            if (a != nums[i]) {
                result.add(a + "->" + nums[i]);
            } else {
                result.add(a + "");
            }
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {

        S_228SummaryRanges summaryRanges = new S_228SummaryRanges();
        System.out.println(summaryRanges.summaryRanges(new int[]{0,2,3,4,6,8,9}));
        System.out.println(summaryRanges.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(summaryRanges.summaryRanges(new int[]{}));
        System.out.println(summaryRanges.summaryRanges(new int[]{-1}));
        System.out.println(summaryRanges.summaryRanges(new int[]{0}));
        System.out.println(summaryRanges.summaryRanges(new int[]{-2147483648, -2147483647, 2147483647}));
        //["-2147483648->-2147483647","2147483647"]
    }
}
