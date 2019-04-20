package com.tobias.cat;


import java.util.HashMap;
import java.util.Map;

public class Solution1654 {

  public static void main(String[] args) {
    System.out.println(mostFrequentlyAppearingLetters("ABCabcA"));
  }

  private static int mostFrequentlyAppearingLetters(String str) {
    // Write your code here.
    Map<Character, Integer> map = new HashMap<>();
    char[] chars = str.toCharArray();
    for (char c : chars) {
      map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
    }
    int max = 0;

    for (Character c : map.keySet()) {
      if (map.get(c) > max) {
        max = map.get(c);
      }
    }
    return max;
  }

}
