package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
public class S_229MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        long group1 = (long) Integer.MAX_VALUE + 1 , group2 = (long) Integer.MAX_VALUE + 1;
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (group1 == num) {
                count1++;
            } else if (group2 == num) {
                count2++;
            } else if (count1 == 0) {
                group1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                group2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == group1) {
                count1++;
            }
            if (num == group2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            result.add((int) group1);
        }

        if (count2 > nums.length / 3) {
            result.add((int) group2);
        }

        return result;
    }


    public List<Integer> majorityElementByMap(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int size = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > size) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        S_229MajorityElementII majorityElementII = new S_229MajorityElementII();
        System.out.println(majorityElementII.majorityElement(new int[]{-2147483648}));
        System.out.println(majorityElementII.majorityElement(new int[]{0,0,0}));
        System.out.println(majorityElementII.majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElementII.majorityElement(new int[]{1,1,1,3,3,2,2,2}));
    }
}
