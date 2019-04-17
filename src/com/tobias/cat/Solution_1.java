package com.tobias.cat;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 {

  public static void main(String[] args) {
    System.out.println(singleNumber1(new int[]{1, 1, 2, 2, 3, 4, 4}));
    System.out.println(singleNumber(new int[]{1, 1, 2, 2, 3, 4, 4}));

  }

  private static int singleNumber1(int[] A) {
    // write your code here
    Map<Integer, Integer> map = new HashMap<>();
    for (int a : A) {
      map.put(a, map.containsKey(a) ? map.get(a) + 1 : 1);
    }

    int num = 0;
    for (Integer key : map.keySet()) {
      if (map.get(key) == 1) {
        num = key;
      }
    }
    return num;
  }

  private static int singleNumber(int[] A) {

    int a = 0;
    for (int aa : A) {
      a ^= aa;
    }
    return a;

  }
}