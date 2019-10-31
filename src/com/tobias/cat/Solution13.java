package com.tobias.cat;

public class Solution13 {

  public static void main(String[] args) {
    System.out.println(count(
        "This won iz correkt. It has, No Mistakes et Oll. But there are two BIG mistakes in this sentence. and here is one more."));
  }

  private static int count(String s) {
    // Write your code here.
    int result = 0;
    String[] sentences = s.split("\\.");
    for (String sentence : sentences) {
      String[] words = sentence.trim().split("\\s+");
      for (int i = 0; i < words.length; i++) {
        char[] chars = words[i].toCharArray();
        for (int j = 0; j < chars.length; j++) {
          if (i == 0 && j == 0) {
            if (chars[j] < 'A' | chars[j] > 'Z') {
              result++;
            }
          } else if (j > 0) {
            if (chars[j] > 'A' & chars[j] < 'Z') {
              result++;
            }
          }
        }
      }
    }
    return result;
  }
}
