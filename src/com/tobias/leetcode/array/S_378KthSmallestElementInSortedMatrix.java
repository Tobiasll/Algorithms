package com.tobias.leetcode.array;


/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    { 1,  5,  9},
 *    {10, 11, 13},
 *    {12, 13, 15}
 * ],
 * k = 8,
 *
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class S_378KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix[0] == null) {
            return -1;
        }
        int index = 0;
        boolean flag = false;
        if (matrix[0].length < k) {
            index = matrix[0].length % k - 1;
            flag = true;
        }
        return matrix[index][flag ? index - 1 : k - 1];
    }

    public static void main(String[] args) {
        S_378KthSmallestElementInSortedMatrix kthSmallestElementInSortedMatrix = new S_378KthSmallestElementInSortedMatrix();
        System.out.println(kthSmallestElementInSortedMatrix.kthSmallest(new int[][]{
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
                }, 8));

        System.out.println(kthSmallestElementInSortedMatrix.kthSmallest(new int[][]{{-5}}, 1));
        System.out.println(kthSmallestElementInSortedMatrix.kthSmallest(new int[][]{
                {1,2},
                {1,3}},2));

    }
}
