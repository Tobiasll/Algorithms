package com.tobias.sort;

import java.util.Arrays;

public class SelectSort {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sort(new int[]{4, 5, 6, 1, 3, 2})));
  }

  private static int[] sort(int[] arrs) {

    for (int i = 0; i < arrs.length; i++) {

      int index = i;
      for (int j = i + 1; j < arrs.length; j++) {
        if (arrs[j] < arrs[index]) {
          arrs[index] = arrs[j];
          index = j;
        }
      }
      int temp = arrs[i];
      arrs[i] = arrs[index];
      arrs[index] = temp;
    }

    return arrs;
  }

}
