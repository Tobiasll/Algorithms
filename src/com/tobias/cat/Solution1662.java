package com.tobias.cat;

import java.util.Arrays;

/**
 * 1662. 中位数下标 cat-only-icon CAT 专属题目 给出一个含有 n 个互不相等整数的无序数组，找到其中中位数的下标。下标从 0 开始。
 *
 * 中位数是指这些数排序后最中间的数。
 *
 * 若 n 为偶数，则中位数是数组排序后的第 n/2 个数。
 *
 * 样例 样例 1：
 *
 * 输入：[4,5,1,2,3] 输出：4 样例 2：
 *
 * 输入：[7,9,4,5] 输出：3 注意事项 1 \leq n \leq 1000001≤n≤100000 所有数都各不相同
 */
public class Solution1662 {

  public static void main(String[] args) {
    System.out.println(getAns(new int[]{4, 5, 1, 2, 3}));
    System.out.println(getAns(new int[]{7, 9, 4, 5}));
  }

  private static int getAns(int[] a) {
    // write your code here

    int[] arr = Arrays.copyOf(a, a.length);
    Arrays.sort(a);
    int middleNumber;
    if (a.length % 2 == 0) {
      middleNumber = a[a.length / 2 - 1];
    } else {
      middleNumber = a[a.length / 2];
    }

    int index = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == middleNumber) {
        index = i;
        break;
      }
    }

    return index;
  }
}
