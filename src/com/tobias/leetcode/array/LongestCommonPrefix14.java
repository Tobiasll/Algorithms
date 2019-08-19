package com.tobias.leetcode.array;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix14 {


  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String result = strs[0];

    for (int i = 1; i < strs.length; i++) {
      while (strs[i].indexOf(result) != 0) {
        result = result.substring(0, result.length() - 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    LongestCommonPrefix14 commonPrefix14 = new LongestCommonPrefix14();
    System.out.println(commonPrefix14.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    System.out.println(commonPrefix14.longestCommonPrefix(new String[]{"dog","racecar","car"}));
  }
}
