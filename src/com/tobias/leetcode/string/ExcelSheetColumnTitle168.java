package com.tobias.leetcode.string;


/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */
public class ExcelSheetColumnTitle168 {

  public String convertToTitle(int n) {
    StringBuilder result = new StringBuilder();
    while (n > 0) {
      n--;
      result.append((char)('A' +  n % 26));
      n /= 26;

    }
    return result.reverse().toString();
  }

  public static void main(String[] args) {
    ExcelSheetColumnTitle168 excelSheetColumnTitle168 = new ExcelSheetColumnTitle168();
    System.out.println(excelSheetColumnTitle168.convertToTitle(1));
    System.out.println(excelSheetColumnTitle168.convertToTitle(28));
    System.out.println(excelSheetColumnTitle168.convertToTitle(701));
    System.out.println(excelSheetColumnTitle168.convertToTitle(27));
    System.out.println(excelSheetColumnTitle168.convertToTitle(52));

  }
}
