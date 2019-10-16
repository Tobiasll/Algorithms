package com.tobias.leetcode.string;


/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support
 * for '.' and '*'.
 *
 * '.' Matches any single character. '*' Matches zero or more of the preceding element. The matching
 * should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z. p could be empty and contains only
 * lowercase letters a-z, and characters like . or *. Example 1:
 *
 * Input: s = "aa" p = "a" Output: false Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa" p = "a*" Output: true Explanation: '*' means zero or more of the preceding
 * element, 'a'. Therefore, by repeating 'a' once, it becomes "aa". Example 3:
 *
 * Input: s = "ab" p = ".*" Output: true Explanation: ".*" means "zero or more (*) of any character
 * (.)". Example 4:
 *
 * Input: s = "aab" p = "c*a*b" Output: true Explanation: c can be repeated 0 times, a can be
 * repeated 1 time. Therefore, it matches "aab". Example 5:
 *
 * Input: s = "mississippi" p = "mis*is*p*." Output: false
 *
 *
 * public boolean isMatch(String text, String pattern) { if (pattern.isEmpty()) return
 * text.isEmpty();
 *
 */
public class RegularExpressionMatching10 {


  public boolean isMatch(String text, String pattern) {
    if (pattern.isEmpty()) {
      return text.isEmpty();
    }
    boolean first_match = (!text.isEmpty() &&
        (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
    //只有长度大于 2 的时候，才考虑 *
    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      //两种情况
      //pattern 直接跳过两个字符。表示 * 前边的字符出现 0 次
      //pattern 不变，例如 text = aa ，pattern = a*，第一个 a 匹配，然后 text 的第二个 a 接着和 pattern 的第一个 a 进行匹配。表示 * 用前一个字符替代。
      // isMatch(text, pattern.substring(2)) 处理c*a*b这种不止一个*的字符串，例如 text = aab, pattern = c*a*b, 调用isMatch，同时截取掉前面的c*后让text和新的pattern = a*b做匹配
      return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
    } else {
      // 每次不断去掉第一个字符，然后递归去判断这个两个字符
      return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
  }

  public boolean isMatchByDP(String text, String pattern) {
    return false;
  }

    public static void main(String[] args) {
    RegularExpressionMatching10 regularExpressionMatching10 = new RegularExpressionMatching10();
    System.out.println(regularExpressionMatching10.isMatch("aa", "a"));
    System.out.println(regularExpressionMatching10.isMatch("aa", "a*"));
    System.out.println(regularExpressionMatching10.isMatch("ab", ".*"));
    System.out.println(regularExpressionMatching10.isMatch("aab", "c*a*b"));
    System.out.println(regularExpressionMatching10.isMatch("mississippi", "mis*is*p*."));
  }
}
