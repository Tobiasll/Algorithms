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
    Set<String> set = new HashSet<>(wordDict);
    return wordBreak(set, s, new HashMap<>());
  }

  private List<String> wordBreak(Set<String> set, String s, Map<String, List<String>> memo) {
    if (s.length() == 0) {
      return new ArrayList<>();
    }
    if (memo.containsKey(s)) {
      return memo.get(s);
    }
    List<String> result = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (set.contains(s.substring(i))) {
        if (i == 0) {
          result.add(s.substring(i));
        } else {
          List<String> list = wordBreak(set, s.substring(0, i), memo);
          for (String word : list) {
            result.add(word + " " + s.substring(i));
          }
        }
      }
    }
    memo.put(s, result);
    return result;
  }


  public static void main(String[] args) {
   S_140WordBreakII wordBreakII = new S_140WordBreakII();
   List<String> wordDict = new ArrayList<>();
   wordDict.add("cat");
   wordDict.add("cats");
   wordDict.add("and");
   wordDict.add("sand");
   wordDict.add("dog");
    System.out.println(wordBreakII.wordBreak("catsanddog", wordDict));
  }
}
