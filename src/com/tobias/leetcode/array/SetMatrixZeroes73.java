package com.tobias.leetcode.array;


import java.util.Arrays;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   {1,1,1},
 *   {1,0,1},
 *   {1,1,1}
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   {0,1,2,0},
 *   {3,4,5,2},
 *   {1,3,1,5}
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes73 {

  public void setZeroes(int[][] matrix) {
    boolean isCol = false;
    int R = matrix.length;
    int C = matrix[0].length;
    for (int i = 0; i < R; i++) {
      //判断第 1 列是否需要置为 0
      if (matrix[i][0] == 0) {
        isCol = true;
      }
      //找 0 的位置，将相应标记置 0
      for (int j = 1; j < C; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    //根据标志，将元素置 0
    for (int i = 1; i < R; i++) {
      for (int j = 1; j < C; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    //判断第一行是否需要置 0
    if (matrix[0][0] == 0) {
      for (int j = 0; j < C; j++) {
        matrix[0][j] = 0;
      }
    }

    //判断第一列是否需要置 0
    if (isCol) {
      for (int i = 0; i < R; i++) {
        matrix[i][0] = 0;
      }
    }
  }

  public void setZeroesByBool(int[][] matrix) {
    boolean[] rowBool = new boolean[matrix.length];
    boolean[] colBool = new boolean[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          rowBool[i] = true;
          colBool[j] = true;
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (rowBool[i] || colBool[j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }

    public void setZeroesByCopyMatrix(int[][] matrix) {
    int[][] maxtrixCopies = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i].length >= 0)
        System.arraycopy(matrix[i], 0, maxtrixCopies[i], 0, matrix[i].length);
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (maxtrixCopies[i][j] == 0) {
          setRowZeroes(matrix, i);
          setColZeroes(matrix, j);
        }
      }
    }

  }

  private void setRowZeroes(int[][] matrix, int row) {
    for (int j = 0; j < matrix[0].length; j++) {
      matrix[row][j] = 0;
    }
  }

  private void setColZeroes(int[][] matrix, int col) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }

  public static void main(String[] args) {
//    int[][] matrix1 = {{1,1,1}, {1,0,1}, {1,1,1}};
    int[][] matrix1 = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};

    SetMatrixZeroes73 setMatrixZeroes73 = new SetMatrixZeroes73();
    setMatrixZeroes73.setZeroes(matrix1);
    for (int[] ints : matrix1) {
      System.out.println(Arrays.toString(ints));
    }

  }


}
