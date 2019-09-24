package com.tobias.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 *The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 * public String getPermutation(int n, int k) {
 *     List<Integer> nums = new ArrayList<Integer>();
 *     int factorial = 1;
 *     for (int i = 0; i < n; i++) {
 *         nums.add(i + 1);
 *         if (i != 0) {
 *             factorial *= i;
 *         }
 *     }
 *     factorial *= n; //先求出 n 的阶乘
 *     StringBuilder ans = new StringBuilder();
 *     k = k - 1; // k 变为 k - 1
 *     for (int i = n; i > 0; i--) {
 *         factorial /= (nums.size()); //更新为 n - 1 的阶乘
 *         int groupNum = k / factorial;
 *         int num = nums.get(groupNum);
 *         nums.remove(groupNum);
 *         k = k % factorial;
 *         ans.append(num);
 *
 *     }
 *     return ans.toString();
 * }
 */
public class PermutationSequence60 {

  public String getPermutation(int n, int k) {

    StringBuilder sb = new StringBuilder();
    int factorial = 1;
    List<Integer> nums = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      nums.add(i);
      if (i != n) {
        factorial *= i;
      }
    }
    factorial *= n;
    k = k - 1;

    for (int i = n; i >= 1; i--) {
      factorial /= (nums.size());
      int groupNum =  k / factorial;
      int num = nums.get(groupNum);
      nums.remove(groupNum);
      sb.append(num);
      k = k % factorial;
    }

    return sb.toString();
  }

    public String getPermutationByCurrency(int n, int k) {
    List<Integer> nums = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      nums.add(i + 1);
    }
    return getAns(nums, n, k);
  }

  private String getAns(List<Integer> nums, int n, int k) {
    if (n == 1) {
      //把剩下的最后一个数字返回就可以了
      return nums.get(0) + "";
    }
    int perGroupNum = factorial(n - 1); //每组的个数
    int groupNum = (k - 1) / perGroupNum;
    int num = nums.get(groupNum);
    nums.remove(groupNum);
    k = k % perGroupNum; //更新下次的 k
    k = k == 0 ? perGroupNum : k;
    return num + getAns(nums, n - 1, k);
  }
  public int factorial(int number) {
    if (number <= 1)
      return 1;
    else
      return number * factorial(number - 1);
  }


  public static void main(String[] args) {
    PermutationSequence60 permutationSequence60 = new PermutationSequence60();
    System.out.println(permutationSequence60.getPermutation(4, 6));
  }
}
