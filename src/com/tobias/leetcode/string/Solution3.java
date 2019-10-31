package com.tobias.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3. Example 2:
 *
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1. Example 3:
 *
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution3 {

  public static int lengthOfLongestSubstring(String s) {
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      int count = 0;
      List<Character> list = new ArrayList<>();
      for (int j = i; j < s.length(); j++) {
        if (list.contains(s.charAt(j))) {
          break;
        } else {
          list.add(s.charAt(j));
          count++;
        }
      }
      if (count > max) {
        max = count;
      }
    }

    return max;
  }

  public static int lengthOfLongestSubstringByMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int i = 0, j = 0, longest = 0;
    while (j < s.length()) {
      Integer index = map.get(s.charAt(j));
      if (index != null && index >= i) {
        longest = Math.max(longest, j - i);
        i = index + 1;
      }
      map.put(s.charAt(j), j++);

    }

    return Math.max(longest, s.length() - i);
  }


  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstringByMap("abcabcbb"));
    System.out.println(lengthOfLongestSubstringByMap("bbbbb"));
    System.out.println(lengthOfLongestSubstringByMap("pwwkew"));
    System.out.println(lengthOfLongestSubstringByMap("abcabcbb"));
  }
}
