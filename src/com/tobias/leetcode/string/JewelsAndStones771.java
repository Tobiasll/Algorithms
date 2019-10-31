package com.tobias.leetcode.string;


import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the
 * stones you have.  Each character in S is a type of stone you have.  You want to know how many of
 * the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are
 * case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Input: J = "aA", S = "aAAbbbb" Output: 3 Example 2:
 *
 * Input: J = "z", S = "ZZ" Output: 0
 */
public class JewelsAndStones771 {

  public static void main(String[] args) {
    System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    System.out.println(numJewelsInStones("z", "ZZ"));
  }

  private static int numJewelsInStones(String J, String S) {
    int count = 0;
    Set<Character> set = new HashSet<>();

    for (char c : J.toCharArray()) {
      set.add(c);
    }

    for (char c : S.toCharArray()) {
      if (set.contains(c)) {
        count++;
      }
    }

    return count;
  }

}
