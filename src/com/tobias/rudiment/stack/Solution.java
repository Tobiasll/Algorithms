package com.tobias.rudiment.stack;

import java.util.Stack;

public class Solution {

  private static Stack<Character> stack = new Stack<>();

  public static void main(String[] args) {
    System.out.println(find("([{}])"));
  }

  private static boolean find(String s) {

    char[] chars = s.toCharArray();

    for (char c : chars) {
      if (c == '(' | c == '[' | c == '{') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        Character topC = stack.pop();
        if (c == ')' && topC != '(') {
          return false;
        }

        if (c == ']' && topC != '[') {
          return false;
        }

        if (c == '}' && topC != '{') {
          return false;
        }
      }
    }


    return stack.isEmpty();
  }

}
