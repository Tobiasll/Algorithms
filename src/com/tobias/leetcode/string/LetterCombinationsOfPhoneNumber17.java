package com.tobias.leetcode.string;


import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
 * the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
 * does not map to any letters.
 *
 * Example:
 *
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfPhoneNumber17 {

  public List<String> letterCombinations(String digits) {
    LinkedList<String> result = new LinkedList<>();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    char[][] buttons = {{'0'}, {'1'}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
        {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    char[] digitsChars = digits.toCharArray();
   result.offer("");
    for (int i = 0; i < digitsChars.length; i++) {
      char[] letters = buttons[Character.getNumericValue(digitsChars[i])];
      // 通过弹出前面一个字符再拼接后一个字符来使长度和i值相等的全部弹出最后，剩余和i值不相等的字符串长度
      while (result.peek().length() == i) {
        String str = result.poll();
        for (char letter : letters) {
          result.offer(str + letter);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    LetterCombinationsOfPhoneNumber17 letterCombinationsOfPhoneNumber17 = new LetterCombinationsOfPhoneNumber17();
    System.out.println(letterCombinationsOfPhoneNumber17.letterCombinations("23"));
  }
}
