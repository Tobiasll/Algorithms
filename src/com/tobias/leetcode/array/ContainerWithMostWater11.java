package com.tobias.leetcode.array;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i,
 * ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains
 * the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area
 * of water (blue section) the container can contain is 49.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7] Output: 49
 */
public class ContainerWithMostWater11 {

  public int maxArea(int[] height) {
    int L = height.length, lo = 0, hi = L - 1;
    int max = 0;
    while (lo < hi) {
      int loMax = height[lo], hiMax = height[hi];

      int candidate = (hi - lo) * (loMax < hiMax ? loMax : hiMax);
      max = candidate > max ? candidate : max;

      if (height[lo] <= height[hi]) {
        while (lo < hi && height[lo] <= loMax) {
          ++lo;
        }
      } else {
        while (hi > lo && height[hi] <= hiMax) {
          --hi;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    ContainerWithMostWater11 containerWithMostWater11 = new ContainerWithMostWater11();
    System.out.println(containerWithMostWater11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }
}
