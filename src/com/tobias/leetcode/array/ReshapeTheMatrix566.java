package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new
 * one with different size but keep its original data.
 *
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c
 * representing the row number and column number of the wanted reshaped matrix, respectively.
 *
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same
 * row-traversing order as they were.
 *
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped
 * matrix; Otherwise, output the original matrix. Input: nums = [[1,2], [3,4]] r = 1, c = 4 Output:
 * [[1,2,3,4]] Explanation: The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1
 * * 4 matrix, fill it row by row by using the previous list. Example 2: Input: nums = [[1,2],
 * [3,4]] r = 2, c = 4 Output: [[1,2], [3,4]] Explanation: There is no way to reshape a 2 * 2 matrix
 * to a 2 * 4 matrix. So output the original matrix.
 */
public class ReshapeTheMatrix566 {

  public static void main(String[] args) {
    int[][] ints = matrixReshape(new int[][]{{1, 2},{3, 4}}, 1, 4);
//    int[][] ints = matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 2);
    for (int[] anInt : ints) {
      System.out.println(Arrays.toString(anInt));
    }
  }

  private static int[][] matrixReshape1(int[][] nums, int r, int c) {

    if (r * c != nums.length * nums[0].length) {
      return nums;
    }

    int[][] result = new int[r][c];
    List<Integer> list = new ArrayList<>(r * c);
    for (int[] num : nums) {
      for (int i : num) {
        list.add(i);
      }
    }
    int index = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        result[i][j] = list.get(index++);
      }
    }

    return result;
  }

  private static int[][] matrixReshape(int[][] nums, int r, int c) {
    int n = nums.length, m = nums[0].length;
    if (r * c != n * m) {
      return nums;
    }
    int[][] res = new int[r][c];
    for (int i = 0; i < r * c; i++) {
      res[i / c][i % c] = nums[i / m][i % m];
    }
    return res;
  }
}
