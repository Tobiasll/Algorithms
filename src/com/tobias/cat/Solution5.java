package com.tobias.cat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 *
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 *
 * 你可以假设只有一组答案。
 *
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * Example1:
 * numbers=[2, 7, 11, 15], target=9
 * return [0, 1]
 * Example2:
 * numbers=[15, 2, 7, 11], target=9
 * return [1, 2]
 */
public class Solution5 {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15, 3,6 ,4 ,5, 111, 222, 33 ,444 ,555 ,66 ,77, 88}, 9)));
    long end = System.currentTimeMillis();
    System.out.println(end - start);
     start = System.currentTimeMillis();

    System.out.println(Arrays.toString(twoSumByMap(new int[]{2, 7, 11, 15, 3,6 ,4 ,5, 111, 222, 33 ,444 ,555 ,66 ,77, 88}, 9)));
    end = System.currentTimeMillis();
    System.out.println(end - start);
  }
  private static int[] twoSum(int[] numbers, int target) {
    // write your code here
    int[] arr = new int[2];

    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[i] + numbers[j] == target) {
         return new int[]{i, j};
        }
      }
    }
    return arr;
  }

  private static int[] twoSumByMap(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < numbers.length; i++) {
      if (map.get(numbers[i]) != null) {
        return new int[]{map.get(numbers[i]), i};
      } else {
        map.put(target - numbers[i], i);
      }
    }
    return new int[2];
  }

}
