package com.tobias.leetcode.array;


/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   {1,   4,  7, 11, 15},
 *   {2,   5,  8, 12, 19},
 *   {3,   6,  9, 16, 22},
 *   {10, 13, 14, 17, 24},
 *   {18, 21, 23, 26, 30}
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 */
public class S_240Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        int[] cols = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            cols[i] = matrix[i][0];
        }

        int index = binarySearch(cols, target);

        boolean result = false;
        for (int i = index; i >= 0; i--) {

            int findNumIndex = binarySearch(matrix[i], target);
            if (findNumIndex != -1 && matrix[i][findNumIndex] == target) {
                return true;
            }
        }

        return result;
    }

    private int binarySearch(int[] arr, int target) {
        int begin = 0, mid = -1, end = arr.length - 1;

        while (begin <= end) {

            mid = (begin + end) >>> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                begin = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        S_240Search2DMatrixII s_240Search2DMatrixII = new S_240Search2DMatrixII();
        System.out.println(s_240Search2DMatrixII.searchMatrix(new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 30));
    }
}
