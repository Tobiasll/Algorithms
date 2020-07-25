package com.tobias.leetcode.array;


import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class S_414ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(4);
        for (int num : nums) {
            if (!priorityQueue.contains(num)) {
                priorityQueue.offer(num);
            }

            if (priorityQueue.size() > 3) {
                priorityQueue.remove();
            }
        }
        int size = priorityQueue.size();
        if (size < 3) {
            int result = 0;
            for (int i = 0; i < size; i++) {
                result = priorityQueue.poll();
            }
            return result;
        }
        return priorityQueue.remove();
    }


    public static void main(String[] args) {
        S_414ThirdMaximumNumber thirdMaximumNumber = new S_414ThirdMaximumNumber();
        System.out.println(thirdMaximumNumber.thirdMax(new int[]{3, 2, 1}));
        System.out.println(thirdMaximumNumber.thirdMax(new int[]{2, 1}));
        System.out.println(thirdMaximumNumber.thirdMax(new int[]{2, 2, 3, 1}));
    }
}
