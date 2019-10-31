package com.tobias.leetcode.array;


import java.util.Arrays;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral
 * order.
 *
 * Example:
 *
 * Input: 3 Output: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class SpiralMatrixII59 {

  public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    if (n <= 0) {
      return result;
    }
    int num = 1;
    int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
    while (rowStart <= rowEnd && colStart <= colEnd) {
      for (int j = colStart; j <= colEnd; j++) {
        result[rowStart][j] = num++;
      }
      rowStart++;
      for (int i = rowStart; i <= rowEnd; i++) {
        result[i][colEnd] = num++;
      }
      colEnd--;
      for (int j = colEnd; j >= colStart; j--) {
        result[rowEnd][j] = num++;
      }
      rowEnd--;

      for (int i = rowEnd; i >= rowStart; i--) {
        result[i][colStart] = num++;
      }
      colStart++;
    }

    return result;
  }

  public static void main(String[] args) {
    SpiralMatrixII59 spiralMatrixII59 = new SpiralMatrixII59();
    int[][] ints = spiralMatrixII59.generateMatrix(3);
    for (int[] anInt : ints) {
      System.out.println(Arrays.toString(anInt));
    }
    ints = spiralMatrixII59.generateMatrix(4);
    for (int[] anInt : ints) {
      System.out.println(Arrays.toString(anInt));
    }
  }
}
