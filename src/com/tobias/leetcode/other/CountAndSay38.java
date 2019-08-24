package com.tobias.leetcode.other;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1 2.     11 3.     21 4.     1211 5.     111221 1 is read off as "one 1" or 11. 11 is read
 * off as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1 Output: "1" Example 2:
 *
 * Input: 4 Output: "1211"
 */
public class CountAndSay38 {

  public String countAndSay(int n) {
    String result = "1";
    for (int i = 0; i < n - 1; i++) {
      StringBuilder sb = new StringBuilder();
      char[] chars = result.toCharArray();
      for (int j = 0; j < chars.length; j++) {
        int count = 1;
        while (j < chars.length - 1 && chars[j] == chars[j + 1]) {
          j++;
          count++;
        }
        sb.append(count).append(chars[j]);
      }
      result = sb.toString();
    }
    return result;
  }



  public static void main(String[] args) {
    CountAndSay38 countAndSay38 = new CountAndSay38();
//    System.out.println(countAndSay38.countAndSay(1));
//    System.out.println(countAndSay38.countAndSay(2));
//    System.out.println(countAndSay38.countAndSay(3));
//    System.out.println(countAndSay38.countAndSay(4));
//    System.out.println(countAndSay38.countAndSay(5));
    System.out.println(countAndSay38.countAndSay(6));
  }

}
