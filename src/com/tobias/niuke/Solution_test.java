package com.tobias.niuke;


import com.tobias.rudiment.heap.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * find numbers of array b no equals from a array a
 */
public class Solution_test {

  public static void main(String[] args) {
    System.out.println(findDifferent(new int[]{1, 2, 4, 6, 7}, new int[]{6, 3, 9}));

  }

  public static List<Integer> findDifferent(int[] arrA, int[] arrB) {
    Arrays.sort(arrA);
    Arrays.sort(arrB);
    List<Integer> list = new ArrayList<>();
    int i = 0;
    for (int b : arrB) {
      for (; i < arrA.length; i++) {
        if (b <= arrA[i]) {
          if (b == arrA[i]) {
            break;
          } else if (b != arrA[i]) {
            list.add(b);
            break;
          }
        }
      }
    }

    try {
      System.out.println(1 / 0);

    } catch (Exception e) {
      throw new TestException(e.getMessage(), e.getCause(), true, true);
    }
    return list;
  }


}
