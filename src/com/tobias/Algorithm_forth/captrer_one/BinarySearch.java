package com.tobias.Algorithm_forth.captrer_one;

public class BinarySearch {

  public static void main(String[] args) {

    System.out.println(findKeyByBinarySearch(8, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 9}));
    System.out.println(findFirstAppearByBinarySearch(8, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 9}));
    System.out.println(findLastAppearByBinarySearch(8, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 9}));

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

  private static int findFirstAppearByBinarySearch(int key, int[] arrs) {
    int low = 0, hight = arrs.length - 1,  mid;

    while (low <= hight) {
      mid = low + ((hight - low) >> 1);
      if (key < arrs[mid]) {
        hight = mid - 1;
      } else if (key > arrs[mid]) {
        low = mid + 1;
      } else {
        if (mid == 0 | arrs[mid - 1] != key){
          return mid;
        } else {
          hight = mid - 1;
        }
      }
    }

    return -1;
  }

  private static int findLastAppearByBinarySearch(int key, int[] arrs) {
    int low = 0, hight = arrs.length - 1, mid;

    while (low <= hight) {
      mid = low + ((hight - low) >> 1);
      if (key < arrs[mid]) {
        hight = mid - 1;
      } else if (key > arrs[mid]) {
        low = mid + 1;
      } else {
        if (mid == arrs.length - 1 | arrs[mid + 1] != key) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
  }




}
