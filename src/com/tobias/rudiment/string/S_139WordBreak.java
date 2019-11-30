package com.tobias.rudiment.string;


import java.util.ArrayList;
import java.util.List;

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

    int index = 1;
    while (s.length() > 0 && index != -1) {

      for (int i = 0; i < wordDict.size(); i++) {
        index = s.indexOf(wordDict.get(i));
        if (index != -1) {
          String preStr = s.substring(0, index);
          String postStr = s.substring(index + wordDict.get(i).length());
          s = preStr + postStr;
          break;
        }
      }
      if (s.length() == 0) {
        return true;
      }
    }

    return false;
  }


  public static void main(String[] args) {
    S_139WordBreak wordBreak = new S_139WordBreak();
    List<String> wordDict = new ArrayList<>();
    wordDict.add("cats");
    wordDict.add("dog");
    wordDict.add("sand");
    wordDict.add("and");
    wordDict.add("cat");
    System.out.println(wordBreak.wordBreak("catsandog", wordDict));
  }
}
