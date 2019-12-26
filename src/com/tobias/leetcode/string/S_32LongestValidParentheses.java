package com.tobias.leetcode.string;


import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class S_32LongestValidParentheses {


  /**
   * Runtime: 290 ms, faster than 5.03% of Java online submissions for Longest Valid Parentheses.
   * Memory Usage: 37.4 MB, less than 90.20% of Java online submissions for Longest Valid Parentheses.
   */
  public int longestValidParentheses(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      int count = 0;
      for (int j = i; j < s.length(); j++) {
        if (s.charAt(j) == '(') {
          count++;
        } else {
          count--;
        }
        if (count < 0) {
          break;
        }
        if (count == 0) {
          if (j - i + 1> result) {
            result = j - i + 1;
          }
        }
      }
    }
    return result;
  }

  /**
   * Time Limit Exceeded
   */
  public int longestValidParentheses1(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        continue;
      }
      for (int j = i + 2; j <= s.length(); j += 2) {
        if (validated(s.substring(i, j))) {
          result = Math.max(result, j - i);
        }
      }
    }

    return result;
  }

  private boolean validated(String substring) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < substring.length(); i++) {
      if (substring.charAt(i) == '(') {
        stack.push('(');
      } else if (!stack.isEmpty() && stack.peek() == '(') {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    S_32LongestValidParentheses longestValidParentheses = new S_32LongestValidParentheses();
    System.out.println(longestValidParentheses.longestValidParentheses("(()"));

  }


}
