package com.tobias.leetcode.array;



import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 * 3, 4, 7, 2, -3, 1, 4, 2  k = 7  0,1  3,1  7,1, 14,1  11,1  12,1  16,1
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class S_560SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {

            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        System.out.println(map);
        return count;
    }

    /**
     * Runtime: 1286 ms, faster than 9.79% of Java online submissions for Subarray Sum Equals K.
     * Memory Usage: 42.6 MB, less than 16.29% of Java online submissions for Subarray Sum Equals K.
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int i = start; i < nums.length; i++) {
                sum += nums[i];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Time Limit Exceeded
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;

        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        S_560SubarraySumEqualsK subarraySumEqualsK = new S_560SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySumEqualsK.subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
    }
}
