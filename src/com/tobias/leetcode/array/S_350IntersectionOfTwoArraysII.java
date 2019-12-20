package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class S_350IntersectionOfTwoArraysII {

  public int[] intersect(int[] nums1, int[] nums2) {
    int lastNumsIndex = nums2.length - 1;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j <= lastNumsIndex; j++) {
        if (nums1[i] == nums2[j]) {
          int temp = nums2[j];
          nums2[j] = nums2[lastNumsIndex];
          nums2[lastNumsIndex] = temp;
          lastNumsIndex--;
          list.add(nums1[i]);
          break;
        }
      }
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }

  public static void main(String[] args) {
    S_350IntersectionOfTwoArraysII intersectionOfTwoArraysII = new S_350IntersectionOfTwoArraysII();
    System.out.println(Arrays.toString(intersectionOfTwoArraysII.intersect(new int[]{4,9,5, 4}, new int[]{9,4,9,8,4})));
  }
}
