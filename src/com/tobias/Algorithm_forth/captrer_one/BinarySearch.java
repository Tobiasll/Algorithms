package com.tobias.Algorithm_forth.captrer_one;

public class BinarySearch {

  public static void main(String[] args) {

    System.out.println(findKeyByBinarySearch(4, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));

  }

  private static int findKeyByBinarySearch(int key, int[] origin) {
    int low = 0;
    int hight = origin.length - 1;

    while (low <= hight) {
      int mid = (low + hight) / 2;
      if (key < origin[mid]) {
        hight = mid - 1;
      } else if (key > origin[mid]) {
        low = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
