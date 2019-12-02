package com.tobias.leetcode.string;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class S_140WordBreakII {

  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> result = new ArrayList<>();
    Set<Character> set = new HashSet<>();
    for (String word : wordDict) {
      for (int i = 0; i < word.length(); i++) {
        set.add(word.charAt(i));
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if (!set.contains(s.charAt(i))) {
        return result;
      }
    }

    wordDict(s, wordDict, "", "", result, new HashMap<>());
    return result;
  }

  private boolean wordDict(String s, List<String> wordDict, String temp, String resultStr, List<String> result, Map<String, Boolean> memo) {
    if (temp.length() > s.length()) {
      return false;
    }
    if (memo.containsKey(temp)) {
      resultStr += temp;
      return memo.get(temp);
    }
    for (int i = 0; i < temp.length(); i++) {
      if (temp.charAt(i) != s.charAt(i)) {
        return false;
      }
    }
    if (temp.length() == s.length()) {
      result.add(resultStr);
      return true;
    }

    return false;
  }

  public static void main(String[] args) {

  }
}
