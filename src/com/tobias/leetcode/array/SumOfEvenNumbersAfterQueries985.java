package com.tobias.leetcode.array;

import java.util.Arrays;

/**
 * We have an array A of integers, and an array queries of queries.
 *
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the
 * answer to the i-th query is the sum of the even values of A.
 *
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies
 * the array A.)
 *
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the
 * i-th query.
 *
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]] Output: [8,6,2,4] Explanation: At the
 * beginning, the array is [1,2,3,4]. After adding 1 to A[0], the array is [2,2,3,4], and the sum of
 * even values is 2 + 2 + 4 = 8. After adding -3 to A[1], the array is [2,-1,3,4], and the sum of
 * even values is 2 + 4 = 6. After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even
 * values is -2 + 4 = 2. After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even
 * values is -2 + 6 = 4.
 */
public class SumOfEvenNumbersAfterQueries985 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sumEvenAfterQueries2(new int[]{1, 2, 3, 4},
        new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
  }

  private static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    int[] result = new int[A.length];

    for (int i = 0; i < A.length; i++) {
      A[queries[i][1]] = A[queries[i][1]] + queries[i][0];
      int sum = 0;
      for (int num : A) {
        if (num % 2 == 0) {
          sum += num;
        }
      }
      result[i] = sum;
    }

    return result;
  }

  private static int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
    int sum = 0;
    for (int a : A) {
      if (a % 2 == 0) {
        sum += a;
      }
    } // sum of even #s.
    int[] ans = new int[queries.length];
    for (int i = 0; i < ans.length; ++i) {
      int idx = queries[i][1];
      if (A[idx] % 2 == 0) {
        sum -= A[idx];
      } // from 1) and 2)
      A[idx] += queries[i][0];
      if (A[idx] % 2 == 0) {
        sum += A[idx];
      } // from 2) and 3)
      ans[i] = sum;
    }
    return ans;
  }
}
