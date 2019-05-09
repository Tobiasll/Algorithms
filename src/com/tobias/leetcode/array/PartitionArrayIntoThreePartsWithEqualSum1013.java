package com.tobias.leetcode.array;


/**
 * Given an array A of integers, return true if and only if we can partition the array into three
 * non-empty parts with equal sums.
 *
 * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... +
 * A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 *
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1] Output: true Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0
 * + 1 Example 2:
 *
 * Input: [0,2,1,-6,6,7,9,-1,2,0,1] Output: false Example 3:
 *
 * Input: [3,3,6,5,-2,2,5,1,-9,4] Output: true Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 */
public class PartitionArrayIntoThreePartsWithEqualSum1013 {

  public static void main(String[] args) {
    System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
  }

  private static boolean canThreePartsEqualSum(int[] A) {
    // sum 数组总和， part 分段部分总和，最终应等于sum 除于 3端， cnt 为需要分为多少端

    int sum = 0, part = 0, count = 0;
    for (int a : A) {
      sum += a;
    }
    if (sum % 3 != 0) {
      return false;
    }
    for (int num : A) {
      part += num;
      if (part != sum / 3) {
        continue;
      }
      if (++count == 3) {
        return true;
      }
      part = 0;
    }

    return false;
  }

}
