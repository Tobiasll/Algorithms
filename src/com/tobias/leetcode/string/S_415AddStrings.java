package com.tobias.leetcode.string;


/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class S_415AddStrings {

    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            sb.insert(0, (carry + a + b) % 10);
            carry = (carry + a + b) / 10;
        }
        return carry == 0 ? sb.toString() : carry + sb.toString();
    }

    public static void main(String[] args) {
        S_415AddStrings addStrings = new S_415AddStrings();
        System.out.println(addStrings.addStrings("1", "9"));
    }

}
