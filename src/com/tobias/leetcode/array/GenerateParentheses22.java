package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 */
public class GenerateParentheses22 {

  public static void main(String[] args) {
    GenerateParentheses22 generateParentheses22 = new GenerateParentheses22();
    System.out.println(generateParentheses22.generateParenthesis(4));
    System.out.println(generateParentheses22.generateParenthesis(4).size());
  }

  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
//    addGenerateParentheses(list, "", n, n);
//    addGenerateParentheses2(list, "", 0, 0, n);
    list = addGenerateParenthesesByPD(n);
    return list;
  }

  /**
   * the best solve My method is DP. First consider how to get the result f(n) from previous result
   * f(0)...f(n-1). Actually, the result f(n) will be put an extra () Pair to f(n-1). Let the "("
   * always at the first position, to produce a valid result, we can only put ")" in a way that
   * there will be i pairs () inside the extra () and n - 1 - i pairs () outside the extra Pair.
   *
   * Let us consider an example to get clear view:
   *
   * f(0): "" f(1): "("f(0)")" f(2): "("f(0)")"f(1), "("f(1)")" f(3): "("f(0)")"f(2),
   * "("f(1)")"f(1), "("f(2)")" So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ...
   * "("f(i)")"f(n-1-i) ... "(f(n-1)")"
   */
  private List<String> addGenerateParenthesesByPD(int n) {
    List<List<String>> lists = new ArrayList<>();
    lists.add(Collections.singletonList(""));

    for (int i = 1; i <= n; ++i) {
      final List<String> list = new ArrayList<>();

      for (int j = 0; j < i; ++j) {
        // 当头部first为0=""时尾部second会变成n-1个括号的情况如 n = 3, first = "", second =()()/(()) 那么结尾就为( + "" + ) + ()()/(())变为()()()/()(()) n = first + second
        // 当头部first为n-1时，尾部会为0="", 如first = ()()/(())， 结尾就是 ( + ()() + ) + ""/ ( + (()) + ) + "" 最后n = first = second
        for (final String first : lists.get(j)) {
          for (final String second : lists.get(i - 1 - j)) {
            list.add("(" + first + ")" + second);
          }
        }
      }

      lists.add(list);
    }

    return lists.get(lists.size() - 1);
  }

  private void addGenerateParentheses(List<String> list, String str, int left, int right) {

    if (left < 0 || right < 0 || left > right) {
      return;
    }
    if (left == 0 && right == 0) {
      list.add(str);
      return;
    }

    if (left > 0) {
      addGenerateParentheses(list, str + "(", left - 1, right);
    }
    if (right > 0) {
      addGenerateParentheses(list, str + ")", left, right - 1);
    }
  }

  private void addGenerateParentheses2(List<String> list, String str, int open, int close,
      int max) {

    if (str.length() == max * 2) {
      list.add(str);
      return;
    }

    if (open < max) {
      addGenerateParentheses2(list, str + "(", open + 1, close, max);
    }
    if (close < open) {
      addGenerateParentheses2(list, str + ")", open, close + 1, max);
    }
  }

}
