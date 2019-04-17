package com.tobias.cat;

import java.util.ArrayList;
import java.util.List;

/**
 * 水仙花数的定义是，这个数等于他每一位上数的幂次之和 见维基百科的定义
 *
 * 比如一个3位的十进制整数153就是一个水仙花数。因为 153 = 13 + 53 + 33。
 *
 * 而一个4位的十进制数1634也是一个水仙花数，因为 1634 = 14 + 64 + 34 + 44。
 *
 * 给出n，找到所有的n位十进制水仙花数。
 */
public class Solution2 {

  public static void main(String[] args) {
    System.out.println(getNarcissisticNumbers(1));
  }

  public static List<Integer> getNarcissisticNumbers(int n) {
    // write your code here
    double c = Math.pow(10, n);
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < c; i++) {
      int ge;
      for (int j = 0; j < n; j++) {
        ge = i % 10;
        if (i == ge) {
          list.add(i);
        }
      }
    }

    return list;
  }

}
