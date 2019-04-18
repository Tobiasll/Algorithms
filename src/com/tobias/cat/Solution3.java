package com.tobias.cat;

/**
 *
 */
public class Solution3 {

  public static void main(String[] args) {
    rotateString("abcdefg".toCharArray(), 3);
  }

  private static void rotateString(char[] str, int offset) {
    // write your code here
    if (offset == 0 || str == null || str.length == 0) {
      return;
    }
    int order;
    if (offset > str.length) {
      order = offset % str.length;
    } else if (offset == str.length) {
      return;
    } else {
      order = offset;
    }
    for (int i = 0; i < order; i++) {
      char a = 0;
      char b;
      for (int j = 0; j < str.length; j++) {
        if (j == 0) {
          a = str[j];
          str[j] = str[str.length - 1];
        } else {
          b = str[j];
          str[j] = a;
          a = b;
        }
      }
    }

  }
}
