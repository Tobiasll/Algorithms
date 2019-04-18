package com.tobias.sort;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    System.out.println( Arrays.toString(bubbleSort1(new int[]{1, 3, 4, 2, 7, 5})));;
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

}
