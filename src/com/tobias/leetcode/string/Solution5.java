package com.tobias.leetcode.string;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 * length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer. Example 2:
 *
 * Input: "cbbd" Output: "bb" form max palindrome
 */
public class Solution5 {

  private class longestPalindromeNode {

    private int length = 0;
    private String word = "";

  }

  private longestPalindromeNode process(String word, int left, int right,
      longestPalindromeNode longestPalindromeNode) {
    int maxLength;
    while (left >= 0 && right < word.length() && word.charAt(left) == word.charAt(right)) {
      left--;
      right++;
    }
    maxLength = right - left - 1;
    if (maxLength > longestPalindromeNode.length) {
      longestPalindromeNode.length = maxLength;
      longestPalindromeNode.word = word.substring(left + 1, right);
    }
    return longestPalindromeNode;
  }

  public String longestPalindrome(String s) {
    if (s.length() <= 1) {
      return s;
    }

    longestPalindromeNode longestPalindromeNode = new longestPalindromeNode();

    for (int i = 0; i < s.length(); i++) {
      int remainingLength = s.length() - i;
      int formMaxPalindrome = remainingLength + (remainingLength - 1);
      if (formMaxPalindrome < s.length() - 1) {
        break;
      }
      longestPalindromeNode = process(s, i, i, longestPalindromeNode);
      longestPalindromeNode = process(s, i, i + 1, longestPalindromeNode);
    }
    return longestPalindromeNode.word;
  }

  public static void main(String[] args) {
//    System.out.println(new Solution5().longestPalindrome("babad"));
//    System.out.println(new Solution5().longestPalindrome("cbbd"));
//    System.out.println(new Solution5().longestPalindrome("a"));
//    System.out.println(new Solution5().longestPalindrome("ac"));
    System.out.println(new Solution5().longestPalindrome("caba"));
  }
}
