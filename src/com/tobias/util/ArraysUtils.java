package com.tobias.util;

public final class ArraysUtils {

  public static void swap(int[] arrays, int i, int j) {
    arrays[i] = arrays[i] ^ arrays[j];
    arrays[j] = arrays[i] ^ arrays[j];
    arrays[i] = arrays[i] ^ arrays[j];
  }


}
