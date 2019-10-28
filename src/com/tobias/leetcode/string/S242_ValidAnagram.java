package com.tobias.leetcode.string;


import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram" Output: true Example 2:
 *
 * Input: s = "rat", t = "car" Output: false Note: You may assume the string contains only lowercase
 * alphabets.
 *
 * Follow up: What if the inputs contain unicode characters? How would you adapt your solution to
 * such case?
 */
public class S242_ValidAnagram {




  /**
   * Runtime: 3 ms, faster than 93.36% of Java online submissions for Valid Anagram.
   * Memory Usage: 37 MB, less than 97.42% of Java online submissions for Valid Anagram.
   */
  public boolean isAnagramByIntegerArray(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] alphabets = new int[26];
    for (int i = 0; i < s.length(); i++) {
      alphabets[s.charAt(i) - 'a'] += 1;
      alphabets[t.charAt(i) - 'a'] -= 1;
    }

    for (int alphabetCount : alphabets) {
      if (alphabetCount != 0) {
        return false;
      }
    }

    return true;
  }

  /**
   * Runtime: 29 ms, faster than 5.03% of Java online submissions for Valid Anagram. Memory Usage:
   * 37.6 MB, less than 67.10% of Java online submissions for Valid Anagram.
   */
  public boolean isAnagramByMap(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> sMap = new HashMap<>();
    Map<Character, Integer> tMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      sMap.put(s.charAt(i), sMap.containsKey(s.charAt(i)) ? sMap.get(s.charAt(i)) + 1 : 1);
      tMap.put(t.charAt(i), tMap.containsKey(t.charAt(i)) ? tMap.get(t.charAt(i)) + 1 : 1);
    }

    for (Character key : sMap.keySet()) {
      if (!sMap.get(key).equals(tMap.get(key))) {
        return false;
      }
    }
    return true;
  }


  public boolean isSubString(String s, String t) {

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t.charAt(0)) {
        int tIndex = 0;
        while (i < s.length() && tIndex < t.length()) {
          if (t.charAt(tIndex) == s.charAt(i)) {
            i++;
            tIndex++;
          } else {
            return false;
          }
        }
        if (t.length() == tIndex) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    S242_ValidAnagram s242_validAnagram = new S242_ValidAnagram();
    System.out.println(s242_validAnagram.isAnagramByIntegerArray("anagram", "nagaram"));
    System.out.println(s242_validAnagram.isAnagramByIntegerArray("rat", "cat"));
  }
}
