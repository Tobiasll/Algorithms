package com.tobias.leetcode.string;


/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1" Output: "100" Example 2:
 *
 * Input: a = "1010", b = "1011" Output: "10101"
 */
public class AddBinary67 {

  public static void main(String[] args) {
    AddBinary67 addBinary67 = new AddBinary67();
    System.out.println(addBinary67.addBinary("11", "1"));
    System.out.println(addBinary67.addBinary("1010", "1011"));
    System.out.println(addBinary67.addBinary("1010", "1011"));
    System.out.println(Math.sqrt(2));
  }

  public String addBinary(String a, String b) {

    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;

    while (i >= 0 || j >= 0) {
      int sum = MultiplyStrings43.calculateSum(a, b, i, j, carry);
      if (sum >= 2) {
        sum = sum % 2;
        carry = 1;
      } else {
        carry = 0;
      }
      sb.append(sum);
      i--;
      j--;
    }
    if (carry == 1) {
      sb.append(carry);
    }
    return sb.reverse().toString();
  }

}
