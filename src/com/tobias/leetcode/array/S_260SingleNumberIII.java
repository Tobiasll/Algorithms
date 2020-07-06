package com.tobias.leetcode.array;


import java.util.*;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class S_260SingleNumberIII {


    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        int i = 0;
        for (Integer num : set) {
            result[i++] = num;
        }

        return result;
    }


    /**
     * Runtime: 6 ms, faster than 10.64% of Java online submissions for Single Number III.
     * Memory Usage: 40.9 MB, less than 20.86% of Java online submissions for Single Number III.
     */
    public int[] singleNumberWithMap(int[] nums) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int num : nums) {
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result[i++] = entry.getKey();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        S_260SingleNumberIII s_260SingleNumberIII = new S_260SingleNumberIII();
        System.out.println(Arrays.toString(s_260SingleNumberIII.singleNumber(new int[]{1,2,1,3,2,5})));
    }
}
