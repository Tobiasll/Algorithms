package com.tobias.leetcode.string;


/**
 *Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary67 {

  public static void main(String[] args) {
    int num = 1;
    for (int i = 0; i < 3; i++) {
      System.out.println(2 * 2 * 2);
    }
  }

  public String addBinary(String a, String b) {
    int suma = a.length() == 0 ? a.charAt(a.length() - 1) == '0' ? 0 : 1 : 0;
    int sumb = b.length() == 0 ? b.charAt(b.length() - 1) == '0' ? 0 : 1 : 0;

    return a;
  }

}
