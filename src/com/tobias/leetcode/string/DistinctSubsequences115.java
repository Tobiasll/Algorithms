package com.tobias.leetcode.string;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the remaining
 * characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit" Output: 3 Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S. (The caret symbol ^ means the
 * chosen letters)
 *
 * rabbbit ^^^^ ^^ rabbbit ^^ ^^^^ rabbbit ^^^ ^^^ Example 2:
 *
 * Input: S = "babgbag", T = "bag" Output: 5 Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S. (The caret symbol ^ means the
 * chosen letters)
 *
 * babgbag ^^ ^ babgbag ^^    ^ babgbag ^    ^^ babgbag ^  ^^ babgbag ^^^
 */
public class DistinctSubsequences115 {

  private int count;


  public int numDistinctByDynamicPlanningWithOrderArray(String s, String t) {
    int[] dp = new int[s.length() + 1];
    for (int i = 0; i <= s.length(); i++) {
      dp[i] = 1;
    }

    for (int ti = 1; ti <= t.length(); ti++) {
      int pre = dp[s.length()];
      dp[0] = 0;
      for (int si = 1; si <= s.length(); si++) {
        int temp = dp[si];
        if (s.charAt(si - 1) == t.charAt(ti - 1)) {
          dp[si] = dp[si - 1] + pre;
        } else {
          dp[si] = dp[si - 1];
        }
        pre = temp;
      }
    }
    return dp[s.length()];
  }

  public int numDistinctByDynamicPlanningWithReverseOrderArray(String s, String t) {
    int[] dp = new int[s.length() + 1];
    for (int i = 0; i <= s.length(); i++) {
      dp[i] = 1;
    }
    for (int ti = t.length() - 1; ti >= 0; ti--) {
      int pre = dp[s.length()];
      dp[s.length()] = 0;
      for (int si = s.length() - 1; si >= 0; si--) {
        int temp = dp[si];
        if (s.charAt(si) == t.charAt(ti)) {
          dp[si] = dp[si + 1] + pre;
        } else {
          dp[si] = dp[si + 1];
        }
        pre = temp;
      }
    }
    return dp[0];
  }

  public int numDistinctByDynamicPlanningWithMatrix(String s, String t) {
    int[][] dp = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i <= s.length(); i++) {
      dp[i][t.length()] = 1;
    }

    for (int ti = t.length() - 1; ti >= 0; ti--) {
      // init the bottom value be zero
      dp[s.length()][ti] = 0;
      for (int si = s.length() - 1; si >= 0; si--) {
        if (s.charAt(si) == t.charAt(ti)) {
          dp[si][ti] = dp[si + 1][ti + 1] + dp[si + 1][ti];
        } else {
          dp[si][ti] = dp[si + 1][ti];
        }
      }
    }

    for (int[] ints : dp) {
      System.out.println(Arrays.toString(ints));
    }
    return dp[0][0];
  }

  public int numDistinctByBacktrack(String s, String t) {
    Map<String, Integer> map = new HashMap<>();
    numDistinctByBacktrack(s, 0, t, 0, map);
    return count;
  }

  private void numDistinctByBacktrack(String s, int sStart, String t, int tStart,
      Map<String, Integer> map) {
    if (tStart == t.length()) {
      count++;
      return;
    }
    if (sStart == s.length()) {
      return;
    }
    String key = sStart + "&" + tStart;
    if (map.containsKey(key)) {
      count += map.get(key);
      return;
    }
    int countPre = count;
    if (s.charAt(sStart) == t.charAt(tStart)) {
      numDistinctByBacktrack(s, sStart + 1, t, tStart + 1, map);
    }
    numDistinctByBacktrack(s, sStart + 1, t, tStart, map);
    int countIncrement = count - countPre;
    map.put(key, countIncrement);
  }


  public int numDistinctBydivideAndConquer(String s, String t) {
    Map<String, Integer> map = new HashMap<>();
    return numDistinctBydivideAndConquer(s, 0, t, 0, map);
  }

  private int numDistinctBydivideAndConquer(String s, int sStart, String t, int tStart,
      Map<String, Integer> map) {
    if (tStart == t.length()) {
      return 1;
    }
    if (sStart == s.length()) {
      return 0;
    }
    int count;
    String key = sStart + "&" + tStart;
    if (map.get(key) != null) {
      return map.get(key);
    }
    if (s.charAt(sStart) == t.charAt(tStart)) {
      count = numDistinctBydivideAndConquer(s, sStart + 1, t, tStart + 1, map)
          + numDistinctBydivideAndConquer(s, sStart + 1, t, tStart, map);
    } else {
      count = numDistinctBydivideAndConquer(s, sStart + 1, t, tStart, map);
    }
    map.put(key, count);
    return count;
  }


  public static void main(String[] args) {
    DistinctSubsequences115 distinctSubsequences115 = new DistinctSubsequences115();
    System.out.println(
        distinctSubsequences115.numDistinctByDynamicPlanningWithOrderArray("babgbag", "bag"));
  }

}
