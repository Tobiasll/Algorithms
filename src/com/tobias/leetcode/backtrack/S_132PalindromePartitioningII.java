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

  private int min = 0;
  private int tempMin = 0;


  /**
   * Time Limit Exceeded : Last executed input = "ababababababababababababcbabababababababababababa"
   */
  public int minCut(String s) {
    backtrack(s, 0);
    return min;
  }

  private void backtrack(String s, int start) {
    if (tempMin > 0 && start >= s.length()) {
      min = min == 0 ? tempMin - 1 : Math.min(min, tempMin - 1);
    }
    for (int i = start; i < s.length(); i++) {
      if (isPalindrom(s.substring(start, i + 1))) {
        tempMin++;
        backtrack(s, i + 1);
        tempMin--;
      }
    }
  }

  private boolean isPalindrom(String substring) {
    for (int i = 0, j = substring.length() - 1; i < j; i++, j--) {
      if (substring.charAt(i) != substring.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    S_132PalindromePartitioningII palindromePartitioningII = new S_132PalindromePartitioningII();
    System.out.println(palindromePartitioningII.minCut("ababababababababababababcbabababababababababa"));
  }
}
