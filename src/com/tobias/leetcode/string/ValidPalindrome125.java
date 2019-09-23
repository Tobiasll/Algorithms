package com.tobias.leetcode.string;


/**
 *Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome125 {

  private int[] charMap = new int[256];

  {
    for (int i = 0; i < 10; i++) {
      charMap[i + '0'] = i + 1;
    }

    for (int i = 0; i < 26; i++) {
      charMap[i + 'a'] = charMap[i + 'A'] = i + 11;
    }
  }

  public boolean isPalindromeByMap(String s) {
    int start = 0;
    int end = s.length() - 1;
    // 防止"a."这种情况出现，所以end必须大于等于0
    while (start < s.length() && end >= 0) {
      int startCharValue = charMap[s.charAt(start)];
      int endCharValue = charMap[s.charAt(end)];

      if (startCharValue == 0) {
        start++;
        continue;
      }
      if (endCharValue == 0) {
        end--;
        continue;
      }

      if (startCharValue != endCharValue) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }


    public boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    s = s.toLowerCase();
    while (start < s.length()) {
      if (isNoneAlphanumeric(s.charAt(start))) {
        start++;
        continue;
      }
      if (isNoneAlphanumeric(s.charAt(end))) {
        end--;
        continue;
      }

      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

  private boolean isNoneAlphanumeric(char c) {
    return ('a' > c || c > 'z') && ('A' > c || c > 'Z') && ('0' > c || c > '9');
  }

  public static void main(String[] args) {
    ValidPalindrome125 validPalindrome125 = new ValidPalindrome125();
    System.out.println(validPalindrome125.isPalindromeByMap("A man, a plan, a canal: Panama"));
    System.out.println(validPalindrome125.isPalindromeByMap("race a car"));
    System.out.println(validPalindrome125.isPalindromeByMap("0P"));
    System.out.println(validPalindrome125.isPalindromeByMap("a."));
  }
}
