package com.tobias.leetcode.string;


import java.util.HashMap;
import java.util.Map;

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

  /**
   * Runtime: 3 ms, faster than 95.93% of Java online submissions for Isomorphic Strings.
   * Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Isomorphic Strings.
   *
   *  过程 例如 ：paper  那么 p = t\a = i\p = t\e = l\r = e    sChars[sChar] = t == tChar] = t 则成立
   *              title
   *              bab  b = a\ a = b\ 然后拿出 b = a ，发现 tChar = b ，sChars[sChar]::a 不等于 tChar::b
   *              abb
   */
  public boolean isIsomorphic(String s, String t) {
    char[] sChars = new char[256];
    char[] tChars = new char[256];

    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      if (sChars[sChar] == 0 && tChars[tChar] == 0) {
        tChars[tChar] = sChar;
        sChars[sChar] = tChar;
      } else {
        if (tChars[tChar] != sChar || sChars[sChar] != tChar) {
          return false;
        }
      }
    }

    return true;
  }

  public boolean isIsomorphic2(String s, String t) {

    Map map = new HashMap();

    for (Integer i = 0; i < s.length(); i++) {
      if (map.put(s.charAt(i), i) != map.put(t.charAt(i) + "", i)) {
        return false;
      }
    }
    return true;
  }

  public boolean isIsomorphic1(String s, String t) {
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
    System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));


  }
}
