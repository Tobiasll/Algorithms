package com.tobias.leetcode.array;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 * Example 4:
 *
 * Input: nums = [9,11], k = 2
 * Output: [11]
 * Example 5:
 *
 * Input: nums = [4,-2], k = 2
 * Output: [4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class S_239SlidingWindowMaximum {


    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k +1];
        int start = 0, end = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        while (end < nums.length) {
            treeMap.put(nums[end], treeMap.getOrDefault(nums[end], 0) + 1);
             if (end++ - start + 1 == k) {
                result[start] = treeMap.lastKey();
                treeMap.put(nums[start], treeMap.getOrDefault(nums[start], 0) - 1);
                if (treeMap.get(nums[start]) == 0) {
                    treeMap.remove(nums[start]);
                }
                start++;
            }
        }

        return result;
    }

    /**
     * Time Limit Exceeded
     */
    public int[] maxSlidingWindowWithPriorityQueue(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] result = new int[nums.length - k +1];
        int start = 0;
        int end = 0;

        while(end < nums.length){
            pq.offer(nums[end]);
            if(end - start + 1 < k){
                end++;
            }else if(end - start + 1 == k){
                result[start] = pq.peek();
                pq.remove(nums[start++]);
                end++;
            }
        }
        return result;

//        int[] result = new int[nums.length - k + 1];
//
//        for (int i = 0; i <= nums.length - k; i++) {
//            int max = nums[i];
//            for (int j = i + 1; j < k + i; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            result[i] = max;
//        }
//        return result;
    }

    public static void main(String[] args) {
        S_239SlidingWindowMaximum slidingWindowMaximum = new S_239SlidingWindowMaximum();
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6}, 5)));
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));

    }
}
