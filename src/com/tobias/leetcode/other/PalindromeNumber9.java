package com.tobias.leetcode.other;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber9 {

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int source = x;
    long palindrome = 0;
    while (x != 0) {
      palindrome = palindrome * 10 + (x % 10);
      x = x / 10;
    }
    return source == palindrome;
  }

  public static void main(String[] args) {
    PalindromeNumber9 palindromeNumber9 = new PalindromeNumber9();
    boolean palindrome = palindromeNumber9.isPalindrome(10);
    System.out.println(palindrome);
  }
}
