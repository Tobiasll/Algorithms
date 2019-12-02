package com.tobias.rudiment.string;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class S_139WordBreak {


  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        dp[i] = dp[j] && set.contains(s.substring(j, i));
        if (dp[i]) {
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public boolean wordBreakByRecursive(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);

    return wordBreak(s, set, new HashMap<>());
  }

  private boolean wordBreak(String s, Set<String> set, Map<String, Boolean> memo) {
    if (s.length() == 0) {
      return true;
    }
    if (memo.containsKey(s)) {
      return memo.get(s);
    }
    for (int i = 0; i < s.length(); i++) {
      if (set.contains(s.substring(i)) && wordBreak(s.substring(0, i), set, memo)) {
        memo.put(s, true);
        return true;
      }
    }
    memo.put(s, false);
    return false;
  }

  public boolean wordBreakByBacktrack(String s, List<String> wordDict) {
    Set<Character> set = new HashSet<>();
    for (String word : wordDict) {
      for (int i = 0; i < word.length(); i++) {
        set.add(word.charAt(i));
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if (!set.contains(s.charAt(i))) {
        return false;
      }
    }

    return wordBreak(s, wordDict, "", new HashMap<>());
  }

  private boolean wordBreak(String s, List<String> wordDict, String temp, Map<String, Boolean> memo) {
    if (temp.length() > s.length()) {
      return false;
    }
    if (memo.containsKey(temp)) {
      return memo.get(temp);
    }
    for (int i = 0; i < temp.length(); i++) {
      if (s.charAt(i) != temp.charAt(i)) {
        return false;
      }
    }
    if (temp.length() == s.length()) {
      return true;
    }
    for (int i = 0; i < wordDict.size(); i++) {
      boolean result = wordBreak(s, wordDict, temp + wordDict.get(i), memo);
      if (result) {
        memo.put(temp, result);
        return true;
      }
    }
    memo.put(temp, false);
    return false;
  }


  public static void main(String[] args) {
    S_139WordBreak wordBreak = new S_139WordBreak();
    List<String> wordDict = new ArrayList<>();
    wordDict.add("leet");
    wordDict.add("code");
//    wordDict.add("sand");
//    wordDict.add("and");
//    wordDict.add("cat");
    System.out.println(wordBreak.wordBreak("leetcode", wordDict));
  }
}
