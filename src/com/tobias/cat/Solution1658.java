package com.tobias.cat;

/**
 * 请判断字符串 str 是不是一个合法的标识符。
 * 合法的标识符由字母（A-Z，a-z）、数字（0-9）和下划线组成，并且首字符不能为数字。
 *
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1：
 *
 * 输入：str= "LintCode"
 * 输出：true
 * 解释：
 * 因为 "LintCode" 由字母组成。
 * 样例 2：
 *
 * 输入：str = "123_abc"
 * 输出：false
 * 解释：
 * 虽然 "123_abc" 由字母、数字和下划线组成，但是它的首字符为数字。
 */
public class Solution1658 {

  public static void main(String[] args) {
    System.out.println(isLegalIdentifier("_abc123"));
  }

  private static boolean isLegalIdentifier(String str) {
    // Write your code here.
    if ("".equals(str)) {
      return false;
    }
    if (str.charAt(0) >= '0' & str.charAt(0) <= '9') {
      return false;
    }

    return str.matches("^\\w+$");
  }

}
