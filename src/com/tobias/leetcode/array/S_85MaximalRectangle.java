package com.tobias.leetcode.array;


/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   {'1','0','1','0','0'},
 *   {'1','0','1','1','1'},
 *   {'1','1','1','1','1'},
 *   {'1','0','0','1','0'}
 * ]
 * Output: 6
 */
public class S_85MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        int result = 0;

        int[][] width = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                }

                int minWidth = width[row][col];
                for (int upRow = row; upRow >= 0; upRow--) {
                    int height = row - upRow + 1;
                    minWidth = Math.min(minWidth, width[upRow][col]);
                    result = Math.max(result, height * minWidth);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {

        char[][] chars = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
//        char[][] chars = new char[][]{{'1'}};

        S_85MaximalRectangle maximalRectangle = new S_85MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(chars));
    }
}
