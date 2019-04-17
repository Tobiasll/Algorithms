package com.tobias.cat;

import java.util.Arrays;

/**
 *
 */
public class Solution3 {

  public static void main(String[] args) {
    rotateString("abcdefg".toCharArray(), 3);
  }

  public static void rotateString(char[] str, int offset) {
    // write your code here
    int index = str.length - offset;
    char[] arr = new char[str.length];
    int j = 0;
    for (int i = index; i < str.length; i++) {
      arr[j++] = str[i];
    }
    for (int i = 0; i < index; i++) {
      arr[j++] = str[i];
    }
    System.out.println(Arrays.toString(arr));

  }
}
