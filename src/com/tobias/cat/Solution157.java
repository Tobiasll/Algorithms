package com.tobias.cat;

import java.util.HashMap;

/**
 * 157. 判断字符串是否没有重复字符 实现一个算法确定字符串中的字符是否均唯一出现
 *
 * 样例 Example 1: Input: "abc_____" Output: false
 *
 * Example 2: Input:  "abc" Output: true
 */
public class Solution157 {

  public static void main(String[] args) {
    isUnique("abc_____");
  }

  private static boolean isUnique(String str) {
    // write your code here
    HashMap<Character, Integer> map = new HashMap<>();
    char[] chars = str.toCharArray();
    for (char c : chars) {
      map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
    }

    for (Character character : map.keySet()) {
      if (map.get(character) != 1) {
        return false;
      }
    }
    return true;
  }
}
