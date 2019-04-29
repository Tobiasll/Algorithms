package com.tobias.leetcode.array;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 *
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 * Input:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 */
public class ToeplitzMatrix766 {
  public static void main(String[] args) {
    System.out.println(isToeplitzMatrix(new int[][]{{1,2,3,4}, {5,1,2,3},{9,5,1,2}}));
    System.out.println(isToeplitzMatrix(new int[][]{{1,2}, {2, 2}}));
    System.out.println(isToeplitzMatrix(new int[][]{{18}, {66}}));
    System.out.println(isToeplitzMatrix(new int[][]{{57,54}, {84,57}}));
  }

  private static boolean isToeplitzMatrix(int[][] matrix) {

    for (int i = 0; i < matrix.length - 1; i++) {
      for (int j = 0; j < matrix[i].length - 1; j++) {
        if ( matrix[i][j] != matrix[i + 1][j + 1]) {
          return false;
        }
      }
    }

    return true;
  }
}
