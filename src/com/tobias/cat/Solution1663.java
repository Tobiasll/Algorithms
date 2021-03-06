package com.tobias.cat;

import java.util.Arrays;

/**
 * 1663. 忧郁 cat-only-icon CAT 专属题目 有 n 道可选的题可以做，每一题都有特定的忧郁值，你会从中选择 k 题。如果这 k 题的忧郁值总和大于等于
 * m，那么你就会感到忧郁，反之，你就感受不到忧郁。 那么，请问，有没有可能你做完 k 题之后感受不到忧郁？ 如果可能，返回 yes。 如果不可能，即你一定会感到忧郁，那么返回 no。
 *
 * 样例 样例 1：
 *
 * 输入：m = 7, k = 3, arr = [5,3,4,2,1] 输出："yes" 样例 2：
 *
 * 输入：m = 3, k = 3, arr = [5,1,1,2,3,1] 输出："no" 注意事项 1 ≤n≤ 10000 arr[i] ≤ 10000 k ≤ n
 */
public class Solution1663 {

  public static void main(String[] args) {
    Solution1663 solution1663 = new Solution1663();
    System.out.println(solution1663.depress(7, 3, new int[]{5, 3, 4, 2, 1}));
    System.out.println(solution1663.depress(3, 3, new int[]{5, 1, 1, 2, 3, 1}));

  }

  public String depress(int m, int k, int[] arr) {
    if (arr.length == 0) {
      return "no";
    }
    // Write your code here .
    int sum = 0;
    Arrays.sort(arr);
    for (int i = 0; i < k; i++) {
      sum += arr[i];
      if (sum >= m) {
        return "no";
      }
    }
    return "yes";
  }
}
