package com.tobias.leetcode.backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class S_131PalindromePartitioning {

  public List<List<String>> partition(String s) {
    boolean[][] dp = getDP(s);
    return divideAndConquer(s, 0, dp);
  }

  private boolean[][] getDP(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int len = 1; len <= s.length(); len++) {
      for (int i = 0; i <= s.length() - len; i++) {
        int j = i +  len - 1;
        dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
      }
    }
    return dp;
  }

  private List<List<String>> divideAndConquer(String s, int start, boolean[][] dp) {
    if (start == s.length()) {
      List<List<String>> result = new ArrayList<>();
      result.add(new ArrayList<>());
      return result;
    }
    List<List<String>> result = new ArrayList<>();
    for (int i = start; i < s.length(); i++) {
      if (dp[start][i]) {
        String substring = s.substring(start, i + 1);
        for (List<String> list : divideAndConquer(s, i + 1, dp)) {
          list.add(0, substring);
          result.add(list);
        }
      }
    }
    return result;
  }


  public List<List<String>> partitionByBacktrack(String s) {
    List<List<String>> result = new ArrayList<>();
    backtrack(s, 0, result, new ArrayList<>(), getDP(s));
    return result;
  }

  private void backtrack(String s, int start, List<List<String>> result, List<String> tempList,
      boolean[][] dp) {
    if (tempList.size() > 0 && start >= s.length()) {
      result.add(new ArrayList<>(tempList));
    }
    for (int i = start; i < s.length(); i++) {
      if (dp[start][i]) {
        if (i == start) {
          tempList.add(Character.toString(s.charAt(i)));
        } else {
          tempList.add(s.substring(start, i + 1));
        }
        backtrack(s, i + 1, result, tempList, dp);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    S_131PalindromePartitioning palindromePartitioning = new S_131PalindromePartitioning();
    List<List<String>> lists = palindromePartitioning.partitionByBacktrack("aab");
    for (List<String> list : lists) {
      System.out.println(list);
    }
  }
}
