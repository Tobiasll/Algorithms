package com.tobias.leetcode.binary_search;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2] Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4] Note: Each element in the result must
 * be unique. The result can be in any order.
 */
public class IntersectionOfTwoArrays349 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
  }

  private static int[] intersection(int[] nums1, int[] nums2) {

    Set<Integer> set = new HashSet<>();
    for (int num : nums1) {
      set.add(num);
    }
    List<Integer> result = new ArrayList<>(set.size());
    Arrays.sort(nums2);
    for (Integer key : set) {
      int low = 0, hight = nums2.length - 1, mid;
      while (low <= hight) {
        mid = low + ((hight - low) >> 1);
        if (key < nums2[mid]) {
          hight = mid - 1;
        } else if (key > nums2[mid]) {
          low = mid + 1;
        } else if (key == nums2[mid]) {
          result.add(key);
          break;
        }
      }
    }
    int[] r = new int[result.size()];
    for (int i = 0; i < r.length; i++) {
      r[i] = result.get(i);
    }
    return r;
  }

}
