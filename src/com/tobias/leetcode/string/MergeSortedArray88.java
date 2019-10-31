package com.tobias.leetcode.string;


import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume
 * that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
 * from nums2. Example:
 *
 * Input: nums1 = [1,2,3,4,0,0], m = 3 nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray88 {

  public void mergeByDirect(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }

    int i = 0, j = 0;

    while (j < n) {
      if (m + j == i) {
        nums1[i++] = nums2[j++];
        continue;
      }
      if (nums1[i] >= nums2[j]) {
        if (m + j - i >= 0) {
          System.arraycopy(nums1, i, nums1, i + 1, m + j - i);
        }
        nums1[i++] = nums2[j++];
      } else {
        i++;
      }
    }

    System.out.println(Arrays.toString(nums1));
  }

  public void mergeByCombine(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }
    if (m >= 0) {
      System.arraycopy(nums1, 0, nums1, n, m);
    }
    int i = n, j = 0, k = 0;
    while (j < n) {
      if (n + m == i) {
        while (j < n) {
          nums1[k++] = nums2[j++];
        }
        System.out.println(Arrays.toString(nums1));
        return;
      }

      if (nums1[i] < nums2[j]) {
        nums1[k++] = nums1[i++];
      } else {
        nums1[k++] = nums2[j++];
      }
    }

  }


  public void merge3(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    while (j >= 0) {
      if (i < 0) {
        while (j >= 0) {
          nums1[k--] = nums2[j--];
        }
        return;
      }
      //哪个数大就对应的添加哪个数。
      if (nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }
  }


  public static void main(String[] args) {
    MergeSortedArray88 mergeSortedArray88 = new MergeSortedArray88();
//    mergeSortedArray88.mergeByDirect(new int[]{1, 2, 3, 4, 0, 0, 0, 0}, 4, new int[]{1, 2, 5, 6}, 4);
//    mergeSortedArray88.mergeByDirect(new int[]{1, 2, 3, 4, 0, 0, 0}, 4, new int[]{2, 5, 6}, 3);
    mergeSortedArray88.merge3(new int[]{1, 2, 3, 0, 0, 0, 0}, 3, new int[]{2, 5, 6, 7}, 4);
    mergeSortedArray88.merge3(new int[]{4, 0, 0, 0, 0, 0}, 1, new int[]{1, 2, 3, 5, 6}, 5);
  }
}
