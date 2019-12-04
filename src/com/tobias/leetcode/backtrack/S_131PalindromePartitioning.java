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
    List<List<String>> result = new ArrayList<>();
    backtrack(s, 0, result, new ArrayList<>());
    return result;
  }

  private void backtrack(String s, int start, List<List<String>> result, List<String> tempList) {
    if (tempList.size() > 0 && start >= s.length()) {
      result.add(new ArrayList<>(tempList));
    }
    for (int i = start; i < s.length(); i++) {
      if (isPalindrome(s.substring(start, i + 1))) {
        if (i == start) {
          tempList.add(Character.toString(s.charAt(i)));
        } else {
          tempList.add(s.substring(start, i + 1));
        }
        backtrack(s, i + 1, result, tempList);
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
    List<List<String>> lists = palindromePartitioning.partition("aab");
    for (List<String> list : lists) {
      System.out.println(list);
    }
  }
}
