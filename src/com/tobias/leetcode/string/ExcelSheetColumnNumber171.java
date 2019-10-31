package com.tobias.leetcode.string;


/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ... Example 1:
 *
 * Input: "A" Output: 1 Example 2:
 *
 * Input: "AB" Output: 28 Example 3:
 *
 * Input: "ZY" Output: 701
 */
public class ExcelSheetColumnNumber171 {


  /**
   * first submit, I use a variable count to record How many 26's do we have to multiply by  , from
   * back to front calculate each character，for example : "AAA" = A 676 + A 26 + A 1，but this time
   * complexity is O(n²)，too slow so i improve the program， no any more use the variable count，then
   * the time complexity is O(n), it  faster than 99.98% and less than 100.00%
   */
  public int titleToNumber(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int result = s.charAt(s.length() - 1) - 'A' + 1, ans = 26;
    for (int i = s.length() - 2; i >= 0; i--) {
      int num = s.charAt(i) - 'A' + 1;
      result += ans * num;
      ans *= 26;
    }
    return result;
  }

  public static void main(String[] args) {
    ExcelSheetColumnNumber171 excelSheetColumnNumber171 = new ExcelSheetColumnNumber171();
    System.out.println(excelSheetColumnNumber171.titleToNumber("A"));
    System.out.println(excelSheetColumnNumber171.titleToNumber("AB"));
    System.out.println(excelSheetColumnNumber171.titleToNumber("ZY"));
    System.out.println(excelSheetColumnNumber171.titleToNumber("AAA"));
    System.out.println(676 + 26 + 1);
  }
}
