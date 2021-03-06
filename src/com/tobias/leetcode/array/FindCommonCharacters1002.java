package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters
 * that show up in all strings within the list (including duplicates).  For example, if a character
 * occurs 3 times in all strings but not 4 times, you need to include that character three times in
 * the final answer.
 *
 * You may return the answer in any order.
 *
 * Input: ["bella","label","roller"] Output: ["e","l","l"] Example 2:
 *
 * Input: ["cool","lock","cook"] Output: ["c","o"]
 */
public class FindCommonCharacters1002 {

  public static void main(String[] args) {
    System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
  }

  private static List<String> commonChars(String[] A) {
    List<String> ans = new ArrayList<>();
    int[] count = new int[26];
    Arrays.fill(count, Integer.MAX_VALUE);
    for (String str : A) {
      int[] cnt = new int[26];
      for (char c : str.toCharArray()) {
        ++cnt[c - 'a'];
      } // count each char's frequency in string str.
      for (int i = 0; i < 26; ++i) {
        count[i] = Math.min(cnt[i], count[i]);
      } // update minimum frequency.
    }
    for (char c = 'a'; c <= 'z'; ++c) {
      while (count[c - 'a']-- > 0) {
        ans.add("" + c);
      }
    }
    return ans;

  }
}
