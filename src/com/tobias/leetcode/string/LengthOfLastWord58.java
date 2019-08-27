package com.tobias.leetcode.string;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord58 {

  public int lengthOfLastWord(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int count = 0;
    char[] chars = s.toCharArray();
    boolean hashCharacter = false;
    for (int i = chars.length - 1; i >= 0; i--) {
      if (chars[i] == ' ' && hashCharacter) {
        break;
      } else if (chars[i] != ' '){
        hashCharacter = true;
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    LengthOfLastWord58 lengthOfLastWord58 = new LengthOfLastWord58();
    System.out.println(lengthOfLastWord58.lengthOfLastWord("a "));
    System.out.println(lengthOfLastWord58.lengthOfLastWord("b   a    "));
  }
}
