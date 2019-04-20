package com.tobias.leetcode.string;


import java.util.HashMap;
import java.util.Map;

public class Test {

  public static void main(String[] args) {
    System.out.println(test("adsbbbb"));
  }

  private static int test(String s) {
    Map<Character, Integer> map = new HashMap<>();

    char[] chars = s.toCharArray();
    int start = 0;
    int maxLenth = 0;


    for (int i = 0; i < chars.length; i++) {

      if (map.get(chars[i]) != null && map.get(chars[i]) >= start) {
        start = map.get(chars[i]) + 1;
      }

      if (i - start + 1 > maxLenth) {
        maxLenth = i - start + 1;
      }

      map.put(chars[i], i);
    }

    return maxLenth;
  }
}
