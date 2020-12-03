package com.tobias.leetcode.array;


import java.util.*;

/**
 * Given an array of integers arr, replace each element with its rank.
 *
 * The rank represents how large the element is. The rank has the following rules:
 *
 * Rank is an integer starting from 1.
 * The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 * Rank should be as small as possible.
 *
 *
 * Example 1:
 *
 * Input: arr = [40,10,20,30]
 * Output: [4,1,2,3]
 * Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
 * Example 2:
 *
 * Input: arr = [100,100,100]
 * Output: [1,1,1]
 * Explanation: Same elements share the same rank.
 * Example 3:
 *
 * Input: arr = [37,12,28,9,100,56,80,5,12]
 * Output:      [5, 3, 4, 2, 8, 6, 7, 1,3]
 *
 *
 * Constraints:
 *
 * 0 <= arr.length <= 105
 * -109 <= arr[i] <= 109
 */
public class S_1331RankTransformOfAnArray {

    public int[] arrayRankTransform(int[] arr) {
        int[] result = new int[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);
        Arrays.sort(result);
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : result) {
            map.putIfAbsent(j, map.size() + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;

    }

    public int[] arrayRankTransformUsePriorityQueue(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer num : arr) {
            pq.offer(num);
        }

        Map<Integer, Integer> mapCount = new HashMap<>();
        int rank = 0;
        while (!pq.isEmpty()) {
            Integer num = pq.remove();
            Integer count = mapCount.get(num);
            if (count == null) {
                rank++;
                mapCount.put(num, rank);
            }
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = mapCount.get(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        S_1331RankTransformOfAnArray rankTransformOfAnArray = new S_1331RankTransformOfAnArray();
        System.out.println(Arrays.toString(rankTransformOfAnArray.arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12})));
        System.out.println(Arrays.toString(rankTransformOfAnArray.arrayRankTransform(new int[]{100,100,100})));
    }
}
