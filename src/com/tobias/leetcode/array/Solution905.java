package com.tobias.leetcode.array;

import java.util.Arrays;
import java.util.Random;

/**
 * ' Given an array A of non-negative integers, return an array consisting of all the even elements
 * of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 *
 * Input: [3,1,2,4] Output: [2,4,3,1] The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be
 * accepted.
 */

public class Solution905 {

  public static void main(String[] args) {

    int[] arr = new int[1000];
    Random random = new Random();
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(100000);
    }

    long start = System.currentTimeMillis();
    System.out.println(Arrays.toString(sortArrayByParitySimple(new int[]{4, 3, 1, 2, 4})));
    long end = System.currentTimeMillis();
    System.out.println(end - start);

    start = System.currentTimeMillis();
    System.out.println(Arrays.toString(sortArrayByParity(new int[]{4, 3, 1, 2, 4})));
    end = System.currentTimeMillis();
    System.out.println(end - start);
  }

  public static int[] sortArrayByParitySimple(int[] A) {
    int[] arr = new int[A.length];
    int count = 0;
    for (int i2 : A) {
      if (i2 % 2 == 0) {
        arr[count++] = i2;
      }
    }
    for (int i1 : A) {
      if (i1 % 2 != 0) {
        arr[count++] = i1;
      }
    }
    return arr;
  }

  public static int[] sortArrayByParity1(int[] A) {
    int low = 0;
    int hight = A.length - 1;

    while (low < hight) {

      while (low < hight && A[low] % 2 == 0) {
        low++;
      }

      while (low < hight && A[hight] % 2 != 1) {
        hight--;
      }

      if (low < hight) {
        int temp = A[low];
        A[low++] = A[hight];
        A[hight--] = temp;
      }

    }

    return A;
  }

  public static int[] sortArrayByParity(int[] A) {

    for (int i = 0, j = 0; i < A.length; i++) {
      if (A[i] % 2 == 0) {
        int temp = A[j];
        A[j++] = A[i];
        A[i] = temp;
      }
    }

    return A;
  }

}
