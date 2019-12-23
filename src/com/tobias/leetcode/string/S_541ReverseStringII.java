package com.tobias.leetcode.string;


/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 *
 */
public class S_541ReverseStringII {

  public String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();

    for (int i = 0; i < chars.length; i += 2 * k) {
        reverse(chars, i, i + k - 1);
    }

    return new String(chars);
  }

  private void reverse(char[] chars, int start, int end) {
    if (end >= chars.length) {
      end = chars.length - 1;
    }
    for ( ;start < end;) {
      char temp = chars[start];
      chars[start++] = chars[end];
      chars[end--] = temp;
    }
  }

  public static void main(String[] args) {
    S_541ReverseStringII reverseStringII = new S_541ReverseStringII();
    System.out.println(reverseStringII.reverseStr("abcdefg", 2));
  }
}
