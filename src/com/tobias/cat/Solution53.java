package com.tobias.cat;

public class Solution53 {

  public static void main(String[] args) {
    System.out.println(reverseWords("the sky   is blue"));
  }

  private static String reverseWords(String s) {
    // write your code here
    if (!s.equals("")) {
      String[] arr = s.split("\\s+");
      StringBuilder result = new StringBuilder();

      for (int i = arr.length - 1; i >= 0; i--) {
        result.append(arr[i]).append(' ');
      }
      return result.toString();
    }
    return "";
  }
}
