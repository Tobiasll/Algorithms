package com.tobias.leetcode.array;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class RotateImage48 {

  public void rotateByExchange(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j <= i; j++) {
        if (i == j) {
          continue;
        }
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int i = 0, j = matrix.length - 1; i < matrix.length / 2; i++, j--) {
      for (int k = 0 ; k < matrix[i].length; k++) {
        int temp = matrix[k][i];
        matrix[k][i] = matrix[k][j];
        matrix[k][j] = temp;
      }
    }


  }

  public void rotateByRing(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < n - i - 1; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - j - 1][i];
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = temp;
      }

    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9}};
    RotateImage48 rotateImage48 = new RotateImage48();
    rotateImage48.rotateByRing(matrix);

    for (int[] ints : matrix) {
      System.out.println(Arrays.toString(ints));
    }
  }
}
