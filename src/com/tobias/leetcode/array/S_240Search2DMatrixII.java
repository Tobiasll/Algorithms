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
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return searchHelper(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, matrix.length - 1,  matrix[0].length - 1, target);
    }

    private boolean searchHelper(int[][] matrix, int x1, int y1, int x2, int y2, int xMax, int yMax, int target) {
        if (x1 > xMax || y1 > yMax) {
            return false;
        }
        System.out.println(matrix[x1][y1]);
        System.out.println(matrix[x2][y2]);
        if (x1 == x2 && y1 == y2) {
            return matrix[x1][y1] == target;
        }
        int m1 = (x1 + x2) >>> 1;
        int m2 = (y1 + y2) >>> 1;

        if (matrix[m1][m2] == target) {
            return true;
        }
        if (matrix[m1][m2] < target) {
            // 右上，左下, 右下
            return searchHelper(matrix, x1, m2 + 1, m1, y2, x2, y2, target) ||
                    searchHelper(matrix, m1 + 1, y1, x2, m2, x2, y2, target) ||
                    searchHelper(matrix, m1 + 1, m2 + 1, x2, y2, x2, y2, target);
        } else {
            return searchHelper(matrix, x1, y1, m1, m2, x2, y2, target) ||
                    searchHelper(matrix, x1, m2 + 1, m1, y2, x2, y2, target) ||
                    searchHelper(matrix, m1 + 1, y1, x2, m2, x2, y2, target);
        }

    }

    /**
     * Runtime: 9 ms, faster than 27.08% of Java online submissions for Search a 2D Matrix II.
     * Memory Usage: 51.5 MB, less than 12.76% of Java online submissions for Search a 2D Matrix II.
     */
    public boolean searchMatrixBinarySearch(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;

        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] == target) {
                return true;
            } else {
                break;
            }
        }
        return false;
    }


    /**
     * Runtime: 8 ms, faster than 31.28% of Java online submissions for Search a 2D Matrix II.
     * Memory Usage: 52 MB, less than 5.00% of Java online submissions for Search a 2D Matrix II.
     *
     * todo : 优化成从上往下，减低时间复杂度
     */
    public boolean searchMatrixNormal(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

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
                {1, 2, 3, 4, 5 },
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        }, 5));
    }
}
