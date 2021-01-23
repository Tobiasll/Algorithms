package com.tobias.leetcode.array;


import java.util.Arrays;

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 *Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 * Example 1:
 *
 *
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * Example 2:
 *
 *
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] is 0 or 1.
 *
 *
 * Follow up:
 *
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
 * Accepted
 *
 * �����ϸ����Χ�˸�λ�õĻ�ϸ�����������������λ�û�ϸ��������
 * �����ϸ����Χ�˸�λ����������������ϸ�������λ�û�ϸ����Ȼ��
 * �����ϸ����Χ�˸�λ���г���������ϸ�������λ�û�ϸ��������
 * �����ϸ����Χ������������ϸ�������λ����ϸ�����
 */
public class S_289GameOfLife {


    private static final int[][] direction = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        if (rows == 0) {
            return;
        }
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // ��
                check(r, c, r, c + 1, rows, cols, board);
                // ����
                check(r, c, r + 1, c + 1, rows, cols, board);
                // ��
                check(r, c, r + 1, c, rows, cols, board);
                // ����
                check(r, c, r + 1, c - 1, rows, cols, board);
                //5, 6, 7 ������һ״̬�� 1
                if (board[r][c] >= 5 && board[r][c] <= 7) {
                    board[r][c] = 1;
                } else {
                    board[r][c] = 0;
                }

            }
        }
    }

    private void check(int rCur, int cCur, int rNext, int cNext, int rows, int cols, int[][] board) {
        if (rNext < 0 || cNext < 0 || rNext >= rows || cNext >= cols) {
            return;
        }
        //���������˵��֮ǰ�� 1, ������֮����ھ�
        if (board[rCur][cCur] % 2 == 1) {
            board[rNext][cNext] += 2;
        }
        //���������˵��֮ǰ�� 1, ���µ�ǰ��λ��ֵ
        if (board[rNext][cNext] % 2 == 1) {
            board[rCur][cCur] += 2;
        }
    }


    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
     * Memory Usage: 37.5 MB, less than 25.67% of Java online submissions for Game of Life.
     */
    public void gameOfLifeUseBit(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        // ԭ�е�00�ͣ�01����λ�ƺ󶼻���00Ҳ����������ϸ����ʹ��10��11�������ϸ����Ϊʲô������������ΪҪ����ԭ�е�״̬������count��ʱ��Ҫ��
        // ����&���㣬��������ԭ����1��ϸ���ľͱ�����3(11)�����棬Ҳ�����´�ͳ��ʱ 11 & 01 ����� 01 Ҳ���ǵ���1��Ȼ��count�����ۼ�
        // ��ԭ������ϸ��0���Ͳ�����3�ˣ�ֻ��ʹ��һ��ż����Ҳ����2(10) �´�����ʱ 10 & 01 �ոպõ���00 ��count�ۼӻ��ǲ���
        // ע������Ĺؼ���ʹ��������ż��������ԭ�е�0��1��������&�����ۼ�ͳ�ƣ�����ʹ������������5��4�����Ǿͱ���λ����λ
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = countFromBoardUseBit(i, j, row, col, board);
                // �����ϸ����Χ�˸�λ����������������ϸ�������λ�û�ϸ����Ȼ����Ϊһ��ʼ����1��
                if (board[i][j] == 1 && count >= 2 && count <= 3) {
                    board[i][j] = 5;
                }
                // �����ϸ����Χ������������ϸ�������λ����ϸ�����������������Ϊһ��ʼ������ϸ��00
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 4;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 2;
            }
        }

    }

    private int countFromBoardUseBit(int i, int j, int row, int col, int[][] board) {
        int count = 0;
      /*  for (int x = Math.max(0, i - 1); x <= Math.min(row - 1, i + 1); x++) {
            for (int y = Math.max(0 , j - 1); y <= Math.min(col - 1, j + 1); y++) {
                // 0 & 1 = 00 & 01 = 00   1 & 1 = 01 & 01 = 01
                count += board[x][y] & 1;
            }
        }
        // ���ڱ�����9�ΰ������Լ���������Ҫ���������ȥ���Լ���ͳ��
        count -= board[i][j] & 1;*/

        // ���� i = 1, j = 1, �����˳��Ϊ2,0 2,1 2,2 1,0 1,1 1,2 0,0 0,1 0,2
        for (int[] arr : direction) {
            int x = arr[0] + i, y = arr[1] + j;
            if (x >= 0 && x < row && y < col && y >= 0 && !(x == i && y == j)) {
                count += board[x][y] & 1;
            }
        }
        return count;
    }

    /**
     * Runtime: 1 ms, faster than 15.87% of Java online submissions for Game of Life.
     * Memory Usage: 37.2 MB, less than 73.47% of Java online submissions for Game of Life.
     */
    public void gameOfLifeUseNegative(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = countFromBoard(i, j, row, col, board);

                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = -1;
                }
                // �����ڵ���1ʱ���ܸ�ֵΪ-2�������ж��Ƿ�Ϊ-2Ҳ��ζ���ж�֮ǰ��ֵ�ǲ��Ǵ����������⸲��Ϊ-2�ǲ���֮ǰ�Ƿ����״̬�� -2 == 1 ture
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = -2;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(board[i]));
            for (int j = 0; j < col; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                } else if (board[i][j] == -2) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countFromBoard(int i, int j, int row, int col, int[][] board) {
        int count = 0;
        if (j > 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -2)) {
            count++;
        }
        if (j + 1 < col && (board[i][j + 1] == 1 || board[i][j + 1] == -2)) {
            count++;
        }
        if (i > 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -2)) {
            count++;
        }
        if (i + 1 < row && (board[i + 1][j] == 1 || board[i + 1][j] == -2)) {
            count++;
        }
        if (i > 0 && j >= 1 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -2)) {
            count++;
        }
        if (i > 0 && j + 1 < col && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -2)) {
            count++;
        }

        if (i + 1 < row && j > 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -2)) {
            count++;
        }

        if (i + 1 < row && j + 1 < col && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -2)) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
            };
        S_289GameOfLife gameOfLife = new S_289GameOfLife();
        gameOfLife.gameOfLife(board);
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
