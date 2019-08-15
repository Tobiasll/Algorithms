package com.tobias.leetcode.array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class Solution4 {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int length = nums1.length + nums2.length;
    int index1 = 0, index2 = 0, prev = 0, current = 0;
    for (int i = 0; i <= length / 2; i++) {
      prev = current;
      if (index1 < nums1.length && index2 < nums2.length) {
        if (nums1[index1] < nums2[index2]) {
          current = nums1[index1++];
        } else {
          current = nums2[index2++];
        }
      } else {
        if (index1 < nums1.length) {
          current = nums1[index1++];
        } else {
          current = nums2[index2++];
        }
      }
    }
    if ((length & 1) == 1) {
      return current;
    } else {
      return (double) (prev + current) / 2;
    }
  }

  public static void main(String[] args) {
    // 3:0011 && 1:0001 = 0001
    // 4:0100 && 1:0001 = 0001
    // 5:0101 && 1:0001 = 0001
//    System.out.println(5 & 4);
    System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    System.out.println(findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
  }
}
