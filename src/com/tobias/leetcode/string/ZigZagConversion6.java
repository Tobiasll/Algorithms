package com.tobias.leetcode.string;


/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N A P L S I I G Y   I   R And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows); Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3 Output: "PAHNAPLSIIGYIR" Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4 Output: "PINALSIGYAHRPI" Explanation:
 *
 * P     I    N A   L S  I G Y A   H R P     I
 */
public class ZigZagConversion6 {

  public String convert(String s, int numRows) {
    if (s == null || "".equals(s)) {
      return s;
    }
    StringBuffer[] sb = new StringBuffer[numRows];
    for (int i = 0; i < numRows; i++) {
      sb[i] = new StringBuffer();
    }
    int i = 0;
    while (i < s.length()) {
      for (int index = 0; index < numRows && i < s.length(); index++) {
        sb[index].append(s.charAt(i++));
      }
      for (int index = numRows - 2; index >= 1 && i < s.length(); index--) {
        sb[index].append(s.charAt(i++));
      }
    }
    for (int j = 1; j < sb.length; j++) {
      sb[0].append(sb[j]);
    }

    return sb[0].toString();
  }


  public static void main(String[] args) {
    ZigZagConversion6 zigZagConversion6 = new ZigZagConversion6();
    String paypalishiring = zigZagConversion6.convert("PAYPALISHIRING", 3);
    System.out.println(paypalishiring.equals("PAHNAPLSIIGYIR"));
    System.out.println(40 + '2' - '0');
  }
}
