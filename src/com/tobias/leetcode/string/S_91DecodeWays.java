package com.tobias.leetcode.string;


/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
 */
public class S_91DecodeWays {
  public int numDecodings(String s) {
    return numDecodings(s, 0);
  }

  private int numDecodings(String s, int start) {
    if (start == s.length()) {
      return 1;
    }
    if (s.charAt(start) == '0') {
      return 0;
    }

    int result1 = numDecodings(s, start + 1);
    int result2 = 0;
    if (start < s.length() - 1) {
      int ten = (s.charAt(start) - '0') * 10;
      int one = s.charAt(start + 1) - '0';
      if (ten + one <= 26) {
        result2 = numDecodings(s, start + 2);
      }
    }
    return result1 + result2;
  }

  public static void main(String[] args) {
    S_91DecodeWays decodeWays = new S_91DecodeWays();
    System.out.println(decodeWays.numDecodings("12"));
    System.out.println(decodeWays.numDecodings("226"));
  }
}
