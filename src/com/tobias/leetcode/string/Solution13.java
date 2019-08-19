package com.tobias.leetcode.string;


import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value I             1 V             5 X             10 L             50 C 100 D 500
 * M             1000 For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written
 * as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral
 * for four is not IIII. Instead, the number four is written as IV. Because the one is before the
 * five we subtract it making four. The same principle applies to the number nine, which is written
 * as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed before L (50) and C
 * (100) to make 40 and 90. C can be placed before D (500) and M (1000) to make 400 and 900. Given a
 * roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to
 * 3999.
 *
 * Example 1:
 *
 * Input: "III" Output: 3 Example 2:
 *
 * Input: "IV" Output: 4 Example 3:
 *
 * Input: "IX" Output: 9 Example 4:
 *
 * Input: "LVIII" Output: 58 Explanation: L = 50, V= 5, III = 3. Example 5:
 *
 * Input: "MCMXCIV" Output: 1994 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class Solution13 {

  private Map<Character, Integer> map = new HashMap<>();

  {
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
  }

  public int romanToInt(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'I' && i + 1 < s.length() && (s.charAt(i + 1) == 'V'
          | s.charAt(i + 1) == 'X')) {
        result -= 1;
      } else if (s.charAt(i) == 'X' && i + 1 < s.length() && (s.charAt(i + 1) == 'L'
          | s.charAt(i + 1) == 'C')) {
        result -= 10;
      } else if (s.charAt(i) == 'C' && i + 1 < s.length() && (s.charAt(i + 1) == 'D'
          | s.charAt(i + 1) == 'M')) {
        result -= 100;
      } else {
        result += map.get(s.charAt(i));
      }
    }
    return result;
  }

  public int romanToInt2(String s) {
    int result = 0;
    if (s.contains("IV")) {
      result -= 2;
    }
    if (s.contains("IX")) {
      result -= 2;
    }
    if (s.contains("XL")) {
      result -= 20;
    }
    if (s.contains("XC")) {
      result -= 20;
    }
    if (s.contains("CD")) {
      result -= 200;
    }
    if (s.contains("CM")) {
      result -= 200;
    }

    char[] chars = s.toCharArray();
    for (char aChar : chars) {
      if (aChar == 'M') {
        result += 1000;
      }
      if (aChar == 'D') {
        result += 500;
      }
      if (aChar == 'C') {
        result += 100;
      }
      if (aChar == 'L') {
        result += 50;
      }
      if (aChar == 'X') {
        result += 10;
      }
      if (aChar == 'V') {
        result += 5;
      }
      if (aChar == 'I') {
        result += 1;
      }

    }
    return result;
  }

  public static void main(String[] args) {
    Solution13 solution13 = new Solution13();
    System.out.println(solution13.romanToInt2("III"));
    System.out.println(solution13.romanToInt2("IV"));
    System.out.println(solution13.romanToInt2("IX"));
    System.out.println(solution13.romanToInt2("LVIII"));
    System.out.println(solution13.romanToInt2("MCMXCIV"));

  }
}
