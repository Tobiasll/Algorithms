package com.tobias.leetcode.string;


/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class S_205IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] sArr = new int[s.length()];
    int[] tArr = new int[t.length()];

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (s.charAt(j) == s.charAt(i)) {
          sArr[j]++;
        }
        if (t.charAt(j) == t.charAt(i)) {
          tArr[j]++;
        }
        if (tArr[j] != sArr[j]) {
          return false;
        }
      }

    }
    return true;
  }

  public static void main(String[] args) {
    S_205IsomorphicStrings isomorphicStrings = new S_205IsomorphicStrings();
    System.out.println(isomorphicStrings.isIsomorphic("paperp", "titlet"));
  }
}
