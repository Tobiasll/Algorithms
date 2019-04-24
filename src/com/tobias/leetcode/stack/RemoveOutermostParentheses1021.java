package com.tobias.leetcode.stack;


import java.util.Stack;

/**
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid
 * parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and
 * "(()(()))" are all valid parentheses strings.
 *
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to
 * split it into S = A+B, with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... +
 * P_k, where P_i are primitive valid parentheses strings.
 *
 * Return S after removing the outermost parentheses of every primitive string in the primitive
 * decomposition of S.
 *
 * Input: "(()())(())" Output: "()()()" Explanation: The input string is "(()())(())", with
 * primitive decomposition "(()())" + "(())". After removing outer parentheses of each part, this is
 * "()()" + "()" = "()()()". Example 2:
 *
 * Input: "(()())(())(()(()))" Output: "()()()()(())" Explanation: The input string is
 * "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))". After removing
 * outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 */
public class RemoveOutermostParentheses1021 {

  public static void main(String[] args) {
    System.out.println(removeOuterParentheses("(()())(())(()(()))"));
  }

  private static String removeOuterParentheses(String S) {
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (Character c : S.toCharArray()) {
      if (stack.isEmpty() && c == '(') {
        stack.push(c);
        continue;
      }
      if (stack.size() == 1 && c == ')') {
        stack.pop();
        continue;
      }

      if (c == '(') {
        stack.push(c);
      }

      if (c == ')') {
        stack.pop();
      }
      sb.append(c);
    }
    return sb.toString();
  }

}
