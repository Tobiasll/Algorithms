package com.tobias.sort;

import java.util.Arrays;

public class BinaryInsertionSort {

  public static void main(String[] args) {
    System.out.println( Arrays.toString(sort(new int[]{1, 3, 4, 2, 7, 5})));

  }

  public static int[] sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int x = array[i];

      // Find location to insert using binary search
      int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

      //Shifting array to one location right
      System.arraycopy(array, j, array, j + 1, i - j);

      //Placing element at its correct location
      array[j] = x;
    }
    return array;
  }

  public static int[] advanceInsertSortWithBinarySearch(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int temp = arr[i];
      int low = 0, high = i - 1;
      int mid;
      while (low <= high) {
        mid = low + (high - low) / 2;
        if (arr[mid] > temp) {
          high = mid - 1;
        } else {
          // 元素相同时，也插入在后面的位置
          low = mid + 1;
        }
      }
      for(int j = i - 1; j >= low; j--) {
        arr[j + 1] = arr[j];
      }
      arr[low] = temp;
    }
    return arr;
  }

}
