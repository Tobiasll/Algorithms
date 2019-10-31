package com.tobias.leetcode.binary_search;

/**
 * Let's call an array A a mountain if the following properties hold:
 *
 * A.length >= 3 There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] >
 * A[i+1] > ... > A[A.length - 1] Given an array that is definitely a mountain, return any i such
 * that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 * Input: [0,1,0] Output: 1 Example 2:
 *
 * Input: [0,2,1,0] Output: 1
 */
public class PeakIndexInMountainArray852 {

  public static void main(String[] args) {
    System.out.println(peakIndexInMountainArray(new int[]{0, 1, 2, 1, 0}));
  }

  private static int peakIndexInMountainArray(int[] A) {

    int low = 0, hight = A.length, mid;

    while (low <= hight) {
      mid = low + ((hight - low) >> 1);
      if (A[mid] > A[mid + 1]) {
        hight = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }
}
