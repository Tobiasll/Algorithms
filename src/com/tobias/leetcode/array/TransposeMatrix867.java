package com.tobias.leetcode.array;

import java.util.Arrays;

/**
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and
 * column indices of the matrix.
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]] Output: [[1,4,7],[2,5,8],[3,6,9]] Example 2:
 *
 * Input: [[1,2,3],[4,5,6]] Output: [[1,4],[2,5],[3,6]]
 */
public class TransposeMatrix867 {

  public static void main(String[] args) {
    int[][] transpose = transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});
    for (int[] arr : transpose) {
      System.out.println(Arrays.toString(arr));
    }
  }

  private static int[][] transpose(int[][] A) {
    int[][] result = new int[A[0].length][A.length];

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        result[j][i] = A[i][j];
      }
    }

    return result;
  }

}
