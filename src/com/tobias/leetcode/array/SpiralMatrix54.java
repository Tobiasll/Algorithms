package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral
 * order.
 *
 * Example 1:
 *
 * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] Output: [1,2,3,6,9,8,7,4,5] Example 2:
 *
 * Input: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix54 {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }
    int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd =
        matrix[0].length - 1, length = matrix.length * matrix[0].length;

    while (rowStart <= rowEnd && colStart <= colEnd) {
      for (int j = colStart; j <= colEnd; j++) {
        result.add(matrix[rowStart][j]);
      }
      rowStart++;
      for (int i = rowStart; i <= rowEnd; i++) {
        result.add(matrix[i][colEnd]);
      }
      colEnd--;
      for (int j = colEnd; j >= colStart && result.size() != length; j--) {
        result.add(matrix[rowEnd][j]);
      }
      rowEnd--;
      for (int i = rowEnd; i >= rowStart && !(result.size() == length); i--) {
        result.add(matrix[i][colStart]);
      }
      colStart++;
    }
    return result;
  }


  public static void main(String[] args) {
    SpiralMatrix54 spiralMatrix54 = new SpiralMatrix54();
//    int[][] matrix2 = {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {10, 11, 12}};
//    int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13, 14, 15, 16}};
//    int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    int[][] matrix2 = {{7}, {9}, {6}};
//    System.out.println(spiralMatrix54.spiralOrder(matrix1));
    System.out.println(spiralMatrix54.spiralOrder(matrix2).size());
    System.out.println(spiralMatrix54.spiralOrder(matrix2));
  }
}
