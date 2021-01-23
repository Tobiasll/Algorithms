package com.tobias.leetcode.array;


import java.util.*;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * Constraints:
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * All the elements of arr2 are distinct.
 * Each arr2[i] is in arr1.
 */
public class S_1122RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //create map for counting numbers in arr1. Initialize everything with zeroes
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : arr2) {
            m.put(num, 0);
        }
        int last = arr1.length - 1;
        int[] res = new int[arr1.length];
        //iterate over arr1  and count numbers of time this element is in arr1
        for (int num : arr1) {
            //if number is from arr2 - increment count
            if (m.containsKey(num)) {
                m.put(num, m.get(num) + 1);
            }
                //otherwise add element to the end of res and decrement the pointer
            else {
                res[last--] = num;
            }
        }
        //iterate over arr2, fill elements in res based on it's count
        int p = 0;
        for (int num : arr2) {
            int c = m.get(num);
            for (int i = 0; i < c; i++) {
                res[p++] = num;
            }
        }
        //now sort the leftovers - p points to the first element in series of those from arr2 that are not in arr1
        Arrays.sort(res, p, res.length);
        return res;
    }

    public static void main(String[] args) {
        S_1122RelativeSortArray relativeSortArray = new S_1122RelativeSortArray();
        System.out.println(Arrays.toString(relativeSortArray.relativeSortArray(new int[]{28,6,22,8,44,17}, new int[]{22,28,8,6})));
        System.out.println(Arrays.toString(relativeSortArray.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})));
        //[28,6,22,8,44,17]
        //[22,28,8,6]
        //Output
        //[22,28,8,6,44,17]
        //Expected
        //[22,28,8,6,17,44]


    }
}
