package com.tobias.leetcode.array;

import java.util.*;

/**
 *Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */
public class S_347TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];
        int[][] counts = new int[20][2];
        for (int num : nums) {
            counts[num][1]++;
            counts[num][0] = num;
        }
        Arrays.sort(counts, (o1, o2) -> o2[1] - o1[1]);

        for (int i = 0; i < k; i++) {
            result[i] = counts[i][0];
        }
        return result;
    }

    public int[] topKFrequentByMap(int[] nums, int k) {

        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(map.size() + 2, (o1, o2) -> o2.getValue() - o1.getValue());
        priorityQueue.addAll(map.entrySet());
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {

        S_347TopKFrequentElements topKFrequentElements = new S_347TopKFrequentElements();

        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(new int[]{1}, 1)));
    }

}
