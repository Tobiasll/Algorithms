package com.tobias.util;

public class ArraysUtils {

  public static void swap(int[] arrays, int i, int j) {
    int temp = arrays[i];
    arrays[i] = arrays[j];
    arrays[j] = temp;
  }

}
