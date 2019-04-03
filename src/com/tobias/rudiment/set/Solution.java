package com.tobias.rudiment.set;

import java.util.TreeSet;

public class Solution {

  public static void main(String[] args) {

    String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
        ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--.."};
    String[] words = {"gin", "zen", "gig", "msg"};
    TreeSet<String> treeSet = new TreeSet<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < word.length(); i++) {
        sb.append(codes[word.charAt(i) - 'a']);
      }
      treeSet.add(sb.toString());
    }

    System.out.println(treeSet);

  }

}
