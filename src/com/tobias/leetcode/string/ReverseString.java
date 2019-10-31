package com.tobias.leetcode.string;

import java.util.Arrays;


public class ReverseString {

  public static void main(String[] args) {
    char[] s = {'h', 'e', 'l', 'l', 'o'};
    reverseString(s);

  }

  public static void reverseString(char[] s) {

    System.out.println(Arrays.toString(s));
    for (int i = 0, j = s.length - 1; i < j; i++, j--) {
      char temp = s[i];
      s[i] = s[j];
      s[j] = temp;
    }
    String ss = new String();
    System.out.println(Arrays.toString(s));
  }

}
