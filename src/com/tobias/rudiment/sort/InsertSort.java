package com.tobias.rudiment.sort;

import java.util.Arrays;

public class InsertSort {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sort(new int[]{4, 5, 6, 1, 3, 2})));
  }

  private static int[] sort(int[] arrs) {
    for (int i = 1; i < arrs.length; i++) {
      int value = arrs[i];
      int j = i - 1;
      for (; j >= 0; j--) {
        if (arrs[j] > value) {
          arrs[j + 1] = arrs[j];
        } else {
          break;
        }
      }
      arrs[j + 1] = value;
    }
    return arrs;
  }
}
