package com.tobias.leetcode.string;


/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class S_557ReverseWordsInAStringIII {


  /**
   * Runtime: 9 ms, faster than 39.74% of Java online submissions for Reverse Words in a String III.
   * Memory Usage: 38.4 MB, less than 98.25% of Java online submissions for Reverse Words in a String III.
   */
  public String reverseWords(String s) {
    StringBuilder result = new StringBuilder();
    s += ' ';
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
        if (result.length() > 0) {
          result.append(' ');
        }
        for (int j = i - 1; j >= 0 && s.charAt(j) != ' '; j--) {
          result.append(s.charAt(j));
        }
      }
    }
    return result.toString();
  }

  /**
   * Runtime: 4 ms, faster than 89.74% of Java online submissions for Reverse Words in a String III.
   * Memory Usage: 38 MB, less than 100.00% of Java online submissions for Reverse Words in a String III.
   */
  public String reverseWords1(String s) {
    StringBuilder result = new StringBuilder();
    String[] split = s.split(" ");
    for (String str : split) {
      StringBuilder sb = new StringBuilder(str);
      result.append(sb.reverse()).append(' ');
    }
    return result.substring(0, result.length() - 1);
  }

  public static void main(String[] args) {
    S_557ReverseWordsInAStringIII reverseWordsInAStringIII = new S_557ReverseWordsInAStringIII();
    System.out.println(reverseWordsInAStringIII.reverseWords("Let's take LeetCode contest"));
  }
}
