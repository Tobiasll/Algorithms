package com.tobias.leetcode.array;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 * <p>
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class S_523ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        //this case "[0,0] 0 Output false Expected true" will is error,so must init 0,-1
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(0, -1);
        }};
        ;
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum %= k;
            }
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(runningSum, i);
            }
        }
        return false;
    }

    /**
     * error
     */
    public boolean checkSubarraySum1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (set.contains(sum - k)) {
                return true;
            }
            set.add(sum);
        }

        return false;
    }

    public static void main(String[] args) {
        S_523ContinuousSubarraySum continuousSubarraySum = new S_523ContinuousSubarraySum();
        // 42 - 23 = 19
        System.out.println(continuousSubarraySum.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, -6));
    }
}
