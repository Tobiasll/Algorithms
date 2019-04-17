package com.tobias.demo;

import java.util.HashMap;
import java.util.Map;

public class Sulotion1 {

  public static void main(String[] args) {
    System.out.println(findLength(42));
    System.out.println(findLength(27));

  }

  private static int findLength(int n) {
    int length = 0;

    while (n > 1) {
      n = n % 2 == 0 ? n / 2 : n * 3 + 1;
      System.out.print(n + " ");
      length++;
    }
    System.out.println();
    return length;
  }


}
