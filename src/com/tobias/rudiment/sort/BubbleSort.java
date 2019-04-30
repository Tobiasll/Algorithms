package com.tobias.rudiment.sort;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    System.out.println( Arrays.toString(bubbleSort2(new int[]{1, 3, 4, 2, 7, 5})));
  }

  private static int[] bubbleSort1(int[] arrs) {

    int n = arrs.length;
    for (boolean sorted = false; sorted = !sorted; n--) {
      for (int i = 1; i < n; i++) {
        if (arrs[i - 1] > arrs[i]) {
          System.out.println(arrs[i]);
          int temp = arrs[i - 1];
          arrs[i - 1] = arrs[i];
          arrs[i] = temp;
          sorted = false;
        }
      }
    }

    return arrs;
  }

  private static int[] bubbleSort2(int[] arrs) {
    for (int i = 0; i < arrs.length; i++) {
      boolean flag = false;
      for (int j = 0; j < arrs.length - i -1; j++) {
        if (arrs[j] > arrs[j + 1]) {
          int temp = arrs[j];
          arrs[j] = arrs[j + 1];
          arrs[j + 1] = temp;
          flag = true;
        }
      }
      if (!flag) {
        break;
      }
    }
    return arrs;
  }
}
