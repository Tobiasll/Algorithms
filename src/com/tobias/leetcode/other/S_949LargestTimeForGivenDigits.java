package com.tobias.leetcode.other;


import java.util.Arrays;

/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4]
 * Output: "23:41"
 * Example 2:
 *
 * Input: [5,5,5,5]
 * Output: ""
 *
 *
 * Note:
 *
 * A.length == 4
 * 0 <= A[i] <= 9
 */
public class S_949LargestTimeForGivenDigits {

  private int[] max = {2, 3, 5, 9};
  private String result;

  public String largestTimeFromDigits(int[] A) {
    boolean[] visited = new boolean[A.length];
    int[] cur = new int[A.length];
    Arrays.fill(cur, -1);
    largestTimeFromDigits(A, cur, visited, 0);

    return result;
  }

  private void largestTimeFromDigits(int[] a, int[] cur, boolean[] visited, int index) {
    if (index == a.length) {
      String s = "" + cur[0] + cur[1] + ":" + cur[2] + cur[3];
      if (result == null || result.compareTo(s) < 0) {
        result = s;
      }
      return;
    }
    if (index == 1) {
      if (cur[0] == 1 || cur[0] == 0) {
        max[index] = 9;
      } else if (cur[0] == 2) {
        max[index] = 3;
      }
    }

    for (int i = 0; i < a.length; i++) {
      if (visited[i] || a[i] > max[index]) {
        continue;
      }
      cur[index] = a[i];
      visited[i] = true;
      largestTimeFromDigits(a, cur, visited, index + 1);
      visited[i] = false;
      cur[index] = -1;
    }
  }

  public static void main(String[] args) {
    S_949LargestTimeForGivenDigits largestTimeForGivenDigits = new S_949LargestTimeForGivenDigits();
    System.out.println(largestTimeForGivenDigits.largestTimeFromDigits(new int[]{1, 2, 3, 4}));
  }
}
