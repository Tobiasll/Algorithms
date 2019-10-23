package com.tobias.leetcode.binary_search;


/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   {1,   3,  5,  7},
 *   {10, 11, 16, 20},
 *   {23, 30, 34, 50}
 * ]
 * target = 13
 * Output: false
 */
public class SearchA2DMatrix74 {

  public boolean searchMatrix1(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    if (matrix[0] == null || matrix[0].length == 0) {
      return false;
    }
    int low = 0,  hight = matrix.length - 1, mid;

    while (low <= hight) {
      mid = (low + hight) >> 1;
      if (matrix[mid][0] > target) {
        hight = mid - 1;
      } else if (matrix[mid][0] < target) {
        low = mid + 1;
      } else if (matrix[mid][0] == target) {
        return true;
      }
    }
    int targetArrayIndex = hight < 0 ? 0 : hight;
     low = 0;
     hight = matrix[targetArrayIndex].length - 1;

    while (low <= hight) {
      mid = (low + hight) >> 1;
      if (matrix[targetArrayIndex][mid] > target) {
        hight = mid - 1;
      } else if (matrix[targetArrayIndex][mid] < target) {
        low = mid + 1;
      } else if (matrix[targetArrayIndex][mid] == target) {
        return true;
      }
    }
    return false;
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    if (rows == 0) {
      return false;
    }
    int cols = matrix[0].length;
    int left = 0;
    int right = rows * cols - 1;
    while (left <= right) {
      int mid = (left + right) >> 1;
      int temp = matrix[mid / cols][mid % cols];
      if (temp == target) {
        return true;
      } else if (temp < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }


  public static void main(String[] args) {
    SearchA2DMatrix74 searchA2DMatrix74 = new SearchA2DMatrix74();
    System.out.println(searchA2DMatrix74.searchMatrix(new int[][]{
        {1,   3,  5,  7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}},
        3));
    System.out.println(searchA2DMatrix74.searchMatrix(new int[][]{{1}}, 2));
    System.out.println(searchA2DMatrix74.searchMatrix(new int[][]{{}}, 2));
  }
}
