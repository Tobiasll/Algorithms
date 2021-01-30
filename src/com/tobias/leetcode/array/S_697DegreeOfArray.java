package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 *
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 *
 * Constraints:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class S_697DegreeOfArray {


    /**
     * error
     */
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> countMap = new TreeMap<>(Comparator.comparingInt(o -> o));
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
                int start = (indexMap.get(nums[i]) - 1) >> 16;
                int distance = i - start + 1;
                indexMap.put(nums[i], (indexMap.get(nums[i])) + distance);
            } else {
                countMap.put(nums[i], 1);
                indexMap.put(nums[i], (i + 1) << 16);
            }
        }

        Integer count = Collections.max(countMap.values());
        int smallestDistance = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer value = entry.getValue();
            if (value.equals(count)) {
                smallestDistance = Math.min(smallestDistance, indexMap.get(entry.getKey()) << 16);
            }
        }
        return smallestDistance;
    }

    /**
     * Runtime: 25 ms, faster than 24.30% of Java online submissions for Degree of an Array.
     * Memory Usage: 42.4 MB, less than 86.25% of Java online submissions for Degree of an Array.
     */
    public int findShortestSubArrayUseList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> countMap = new TreeMap<>(Comparator.comparingInt(o -> o));
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
                indexMap.get(nums[i]).add(i);
            } else {
                countMap.put(nums[i], 1);
                List<Integer> list = new ArrayList<>();
                list.add(i);
                indexMap.put(nums[i], list);
            }
        }

        Integer count = Collections.max(countMap.values());
        int smallestDistance = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer value = entry.getValue();
            if (value.equals(count)) {
                List<Integer> indexList = indexMap.get(entry.getKey());
                int distance = indexList.get(indexList.size() - 1) - indexList.get(0) + 1;
                smallestDistance = Math.min(smallestDistance, distance);
            }
        }

        return smallestDistance;
    }

    public static void main(String[] args) {
        S_697DegreeOfArray degreeOfArray = new S_697DegreeOfArray();
        System.out.println(degreeOfArray.findShortestSubArray(new int[]{1,2,2,3,1}));
        System.out.println(degreeOfArray.findShortestSubArrayUseList(new int[]{1,2,2,3,1,4,2}));
    }
}
