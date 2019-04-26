package com.tobias.sort;

import java.util.Arrays;

public class ShellSort {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(shellSort2(new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0})));
  }

  private static int[] shellSort(int[] array) {
    int len = array.length;
    int temp, gap = len / 2;
    while (gap > 0) {
      for (int i = gap; i < len; i++) {
        temp = array[i];
        int preIndex = i - gap;
        while (preIndex >= 0 && array[preIndex] > temp) {
          array[preIndex + gap] = array[preIndex];
          preIndex -= gap;
        }
        array[preIndex + gap] = temp;
      }
      gap /= 2;
    }
    return array;
  }

  private static int[] shellSort2(int[] array) {
    int n = array.length;
    int h = 1;

    while (h < n / 3) {
      h = h * 3 + 1;
    }

    while (h >= 1) {
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && array[j] < array[j - h];j -= h) {
          int temp = array[j];
          array[j] = array[j - h];
          array[j - h] = temp;
        }

      }
      h = h / 3;
    }
    return array;
  }

}
