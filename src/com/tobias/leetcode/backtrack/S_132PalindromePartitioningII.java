package com.tobias.leetcode.backtrack;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class S_132PalindromePartitioningII {

  private int min = Integer.MAX_VALUE;

  /**
   * Time Limit Exceeded : Last executed input = "ababababababababababababcbabababababababababababa"
   */
  public int minCut(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int len = 1; len <= s.length(); len++) {
      for (int i = 0; i <= s.length() - len; i++) {
        int j = i + len - 1;
        dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
      }
    }
    backtrack(s, 0, dp, 0);
    return min;
  }

  private void backtrack(String s, int start, boolean[][] dp, int num) {
    if (dp[start][s.length() - 1]) {
      min = Math.min(min, num);
    }
    for (int i = start; i < s.length() - 1; i++) {
      if (dp[start][i]) {
        backtrack(s, i + 1, dp, num + 1);
      }
    }
  }



  public static void main(String[] args) {
    S_132PalindromePartitioningII palindromePartitioningII = new S_132PalindromePartitioningII();
    System.out.println(palindromePartitioningII.minCut("ababababababababababababcbabababababababababababa"));
  }
}
