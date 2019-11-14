package com.tobias.leetcode.string;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address
 * combinations.
 *
 * Example:
 *
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 */
public class S_93RestoreIPAddresses {


  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    int len = s.length();

    for (int i = 1; i < 4 && i < len - 2; i++) {
      for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
        for (int k = j + 1; k < j + 4 && k < len; k++) {
          String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);

          if (ValidationData(s1) && ValidationData(s2) && ValidationData(s3) && ValidationData(s4)) {
            result.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
          }
        }
      }
    }

    return result;
  }

  private boolean ValidationData(String s) {
    return s.length() <= 3 && s.length() != 0 && (s.charAt(0) != '0' || s.length() <= 1) && Integer.valueOf(s) <= 255;
  }

  public List<String> restoreIpAddresses1(String s) {
    List<String> result = new ArrayList<>();
    restoreIpAddresses(s, new StringBuilder(), result, 0, 0);
    return result;
  }

  private void restoreIpAddresses(String s, StringBuilder sb, List<String> result, int start,
      int count) {

    if (s.length() - start > 3 * (4 - count)) {
      return;
    }
    if (s.length() == start) {
      if (count == 4) {
        result.add(sb.substring(0, sb.length() - 1));
      }
    }

    if (start >= s.length() || count == 4) {
      return;
    }

    StringBuilder before = new StringBuilder(sb);
    sb.append(s.charAt(start)).append('.');
    restoreIpAddresses(s, sb, result, start + 1, count + 1);

    if (s.charAt(start) == '0') {
      return;
    }

    if (start + 2 <= s.length()) {
      sb = new StringBuilder(before);
      sb.append(s, start, start + 2).append('.');
      restoreIpAddresses(s, sb, result, start + 2, count + 1);
    }
    if (start + 3 <= s.length()) {
      sb = new StringBuilder(before);
      int num = Integer.valueOf(s.substring(start, start + 3));
      if (num >= 0 && num <= 255) {
        sb.append(s, start, start + 3).append('.');
        restoreIpAddresses(s, sb, result, start + 3, count + 1);
      }
    }
  }

  public static void main(String[] args) {
    S_93RestoreIPAddresses restoreIPAddresses = new S_93RestoreIPAddresses();
    System.out.println(restoreIPAddresses.restoreIpAddresses("25525511135"));
  }
}
