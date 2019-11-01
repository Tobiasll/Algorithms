package com.tobias.leetcode.string;


import java.util.Arrays;
import java.util.Map;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given a non-empty string containing only digits, determine the
 * total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12" Output: 2 Explanation: It could be decoded as "AB" (1 2) or "L" (12). Example 2:
 *
 * Input: "226" Output: 3 Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2
 * 2 6)
 */
public class S_91DecodeWays {


  public int numDecodingsByDoublePointer(String s) {
    int end = 1;
    int cur = 0;
    if (s.charAt(s.length() - 1) != '0') {
      cur = 1;
    }
    for (int i = s.length() - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        end = cur;
        cur = 0;
        continue;
      }
      int result1 = cur;
      int result2 = 0;
      int ten = (s.charAt(i) - '0') * 10;
      int one = (s.charAt(i + 1) - '0');
      if (ten + one <= 26) {
        result2 = end;
      }
      end = cur;
      cur = result1 + result2;
    }
    return cur;
  }

  public int numDecodingsByDP(String s) {
    int[] dp = new int[3];
    dp[s.length() % 3] = 1;
    // 如果字符串字符串不等于0，那么必须初始化为1
    if (s.charAt(s.length() - 1) != '0') {
      dp[(s.length() - 1) % 3] = 1;
    }
    for (int i = s.length() - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        dp[i % 3] = 0;
        continue;
      }
      int result1 = dp[(i + 1) % 3];
      int result2 = 0;
      int ten = (s.charAt(i) - '0') * 10;
      int one = (s.charAt(i + 1) - '0');
      if (ten + one <= 26) {
        result2 = dp[(i + 2) % 3];
      }

      dp[i % 3] = result1 + result2;
    }

    return dp[0];
  }


  public int numDecodings(String s) {
//    Map<Integer, Integer> map = new HashMap<>();
//    return numDecodings(s, 0, map);
    int[] memo = new int[s.length() + 1];
    Arrays.fill(memo, -1);
    return numDecodings(s, 0, memo);
  }

  /**
   * Runtime: 1 ms, faster than 98.96% of Java online submissions for Decode Ways. Memory Usage:
   * 34.3 MB, less than 100.00% of Java online submissions for Decode Ways.
   */
  private int numDecodings(String s, int start, int[] memo) {
    if (start == s.length()) {
      return 1;
    }
    if (s.charAt(start) == '0') {
      return 0;
    }
    if (memo[start] != -1) {
      return memo[start];
    }
    int result1 = numDecodings(s, start + 1, memo);
    int result2 = 0;
    if (start < s.length() - 1) {
      int ten = (s.charAt(start) - '0') * 10;
      int one = s.charAt(start + 1) - '0';
      if (ten + one <= 26) {
        result2 = numDecodings(s, start + 2, memo);
      }
    }
    memo[start] = result1 + result2;
    return result1 + result2;
  }

  /**
   * Runtime: 2 ms, faster than 56.56% of Java online submissions for Decode Ways. Memory Usage:
   * 35.1 MB, less than 100.00% of Java online submissions for Decode Ways.
   */
  private int numDecodingsByMap(String s, int start, Map<Integer, Integer> map) {
    if (start == s.length()) {
      return 1;
    }
    if (s.charAt(start) == '0') {
      return 0;
    }
    if (map.containsKey(start)) {
      return map.get(start);
    }
    int result1 = numDecodingsByMap(s, start + 1, map);
    int result2 = 0;
    if (start < s.length() - 1) {
      int ten = (s.charAt(start) - '0') * 10;
      int one = s.charAt(start + 1) - '0';
      if (ten + one <= 26) {
        result2 = numDecodingsByMap(s, start + 2, map);
      }
    }
    map.put(start, result1 + result2);
    return result1 + result2;
  }

  public static void main(String[] args) {
    S_91DecodeWays decodeWays = new S_91DecodeWays();
//    System.out.println(decodeWays.numDecodingsByDoublePointer("12"));
//    System.out.println(decodeWays.numDecodingsByDoublePointer("226"));
//    System.out.println(decodeWays.numDecodingsByDoublePointer("10226"));



  }
}
