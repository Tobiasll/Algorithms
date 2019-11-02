package com.tobias.leetcode.string;


/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.
 *
 * Given the encoded message containing digits and the character '*', return the total number of ways to decode it.
 *
 * Also, since the answer may be very large, you should return the output mod 109 + 7.
 *
 * Example 1:
 * Input: "*"
 * Output: 9
 * Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * Example 2:
 * Input: "1*"
 * Output: 9 + 9 = 18
 * Note:
 * The length of the input string will fit in range [1, 105].
 * The input string will only contain the character '*' and digits '0' - '9'.
 */
public class S_639DecodeWaysII {

  private int mod = (int) 1e9 + 7;

  public int numDecodings(String s) {
    return (int) dfs(s.toCharArray(), 0, new long[s.length()]);
  }

  private long dfs(char[] s, int start, long[] memo) {
    if (start >= s.length) {
      return 1;
    }
    if (memo[start] != 0) {
      return memo[start];
    }

    if (start == s.length - 1) {
      memo[start] = count(s[start]);
    } else {
      memo[start] = (((count(s[start]) * dfs(s, start + 1, memo)) + (count(s[start], s[start + 1]) *
          dfs(s, start + 2, memo)))) % mod;
    }
    return memo[start];
  }

  private int count(char first, char second) {
    if (first == '0') {
      return 0;
    }
    if (first == '*' && second == '*') {
      return 15;
    }
    if (first == '*') {
      if (second<= '6') {
        return 2;
      }
      return 1;
    }
    if (second == '*') {
      if (first == '1') {
        return 9;
      }
      if (first == '2') {
        return 6;
      }
      return 0;
    }
    if (first == '1') {
      return 1;
    }
    if (first == '2' && second <= '6') {
      return 1;
    }
    return 0;
  }

  private int count(char c) {
    if (c == '0') {
      return 0;
    }
    return c == '*' ? 9 : 1;
  }

  public int numDecodings1(String s) {
    int[] dp = new int[s.length() + 1];
    dp[s.length()] = 1;
    if (s.charAt(s.length() - 1) != '0') {
      dp[s.length() - 1] = s.charAt(s.length() - 1) == '*' ? 9 : 1;
    }

    for (int i = s.length() - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        continue;
      }
      int result1 = dp[i + 1];
      int result2 = 0;
      if (s.charAt(i) == '*' && s.charAt(i + 1) == '*') {
        result2 = result1 * 9 - result1;
      } else if (s.charAt(i) != '*' && s.charAt(i + 1) == '*') {
        result2 = result1;
      } else {
        int ten = (s.charAt(i) - 'a') * 10;
        int one = s.charAt(i + 1) - 'a';
        if (ten + one <= 26) {
          result2 = 1;
        }
      }

      dp[i] = (result1 + result2) % 1000000007;
    }

    return dp[0];
  }

  public static void main(String[] args) {
    S_639DecodeWaysII decodeWaysII = new S_639DecodeWaysII();
    System.out.println(decodeWaysII.numDecodings("*"));
    System.out.println(decodeWaysII.numDecodings("1*"));
    System.out.println(decodeWaysII.numDecodings("**"));
    System.out.println(decodeWaysII.numDecodings("*1*1*0"));
    System.out.println(decodeWaysII.numDecodings("*10*1"));
  }
}
