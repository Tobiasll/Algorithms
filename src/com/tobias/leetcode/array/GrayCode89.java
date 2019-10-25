package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 *
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 *              A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 *              Therefore, for n = 0 the gray code sequence is [0].
 */
public class GrayCode89 {


  /**
   * 参考https://zhuanlan.zhihu.com/p/29254973
   * n = 3 = B2B1B0  n = 2 = B1B0 result.size = 2 的n次方
   * B2B1B0 = b1=000=0  b2=001=1  b3=010=2 b4=011=3 b5=100=4 b6=101=5 b7=110=6 b8=111=7
   * G2G1G0 = B2B1B0 异或 B2B1B0 右移一位
   * G2G1G0 = 000^000  001 ^000  010 ^001 011 ^010 100 ^010 101 ^010 110 ^ 011 111 ^ 011
   */
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    for (int binary = 0; binary < 1 << n; binary++) {
      result.add(binary ^ binary >> 1);
    }
    return result;
  }


  public List<Integer> grayCodeByDynamicAttribute(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(0);

    for (int i = 0; i < n; i++) {
      int num = 1 << i;
      for (int j = result.size() - 1; j >= 0; j--) {
        System.out.println(Integer.toBinaryString(result.get(j)) + Integer.toBinaryString(num));
        result.add(result.get(j) + num);
      }
    }
    return result;
  }


  public static void main(String[] args) {
    GrayCode89 grayCode89 = new GrayCode89();
    System.out.println(grayCode89.grayCode(3));

  }

}
