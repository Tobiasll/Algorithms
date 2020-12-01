package com.tobias.leetcode.array;



import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * Example 2:
 *
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * Example 3:
 *
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class S_1636SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {

        return nums;
    }


    /**
     * Runtime: 6 ms, faster than 62.23% of Java online submissions for Sort Array by Increasing Frequency.
     * Memory Usage: 38.9 MB, less than 95.94% of Java online submissions for Sort Array by Increasing Frequency.
     */
    public int[] frequencySortByTreeMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, Set<Integer>> treeMap = new TreeMap<>();

        for (Integer key : map.keySet()) {
            if (treeMap.get(map.get(key)) == null) {
                Set<Integer> set = new TreeSet<>((o1, o2) -> o2 - o1);
                set.add(key);
                treeMap.put(map.get(key), set);
            } else {
                Set<Integer> set = treeMap.get(map.get(key));
                set.add(key);
            }
        }

        int index = 0;
        for (Integer key : treeMap.keySet()) {
            Set<Integer> set = treeMap.get(key);
            for (Integer setValue : set) {
                for (int i = 0; i < key; i++) {
                    nums[index++] = setValue;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        S_1636SortArrayByIncreasingFrequency sortArrayByIncreasingFrequency = new S_1636SortArrayByIncreasingFrequency();
        System.out.println(Arrays.toString(sortArrayByIncreasingFrequency.frequencySort(new int[]{1,1,2,2,2,3})));
        System.out.println(Arrays.toString(sortArrayByIncreasingFrequency.frequencySort(new int[]{2,3,1,3,2})));
        System.out.println(Arrays.toString(sortArrayByIncreasingFrequency.frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1})));
    }
}
