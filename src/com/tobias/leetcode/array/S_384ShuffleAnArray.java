package com.tobias.leetcode.array;


import java.util.Arrays;
import java.util.Random;

/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array.
 *
 * Implement the Solution class:
 *
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 *
 *
 * Example 1:
 *
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
 * solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 * solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -106 <= nums[i] <= 106
 * All the elements of nums are unique.
 * At most 5 * 104 calls will be made to reset and shuffle.
 */
public class S_384ShuffleAnArray {

    static class Solution {

        private final int[] original;
        private final int[] arr;

        public Solution(int[] nums) {
            arr = nums;
            original = Arrays.copyOf(nums,  nums.length);
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return original;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            Random random = new Random();
            for (int i = 0; i < arr.length; i++) {
                int index = random.nextInt(arr.length - i);
                int temp = arr[index];
                arr[index] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
            return arr;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

    public static void main(String[] args) {
        Solution obj = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
    }
}
