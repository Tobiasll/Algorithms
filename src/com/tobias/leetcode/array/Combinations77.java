package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations77 {


  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(1, n ,k , result, new ArrayList<>());
    return result;
  }

  private void backtrack(int start, int n, int k, List<List<Integer>> result,
      ArrayList<Integer> insideList) {
    if (insideList.size() == k) {
      result.add(new ArrayList<>(insideList));
      return;
    }
    for (int i = start; i <= n - (k - insideList.size()) + 1; i++) {
      insideList.add(i);
      backtrack(i + 1, n, k, result, insideList);
      insideList.remove(insideList.size() - 1);
    }
  }


  public List<List<Integer>> combine1(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    Set<String> set = new HashSet<>();
    for (int i = 1; i <= n - k + 1; i++) {
      for (int j = i + 1; j <= n - k + 2; j++) {
        StringBuilder sb = new StringBuilder();
        List<Integer> insideList = new ArrayList<>();
        insideList.add(i);
        if (k > 1) {
          insideList.add(j);
        }
        for (int t = 2, num = j + 1; t < k && num <= n; t++, num++) {
          if (k == 1) {
            insideList.add(j);
          }
          insideList.add(num);
        }
        for (Integer integer : insideList) {
          sb.append(integer);
        }
        if (!set.contains(sb.toString())) {
          result.add(insideList);
          set.add(sb.toString());
        }
      }

    }
    return result;
  }

  public static void main(String[] args) {
    Combinations77 combinations77 = new Combinations77();
    System.out.println(combinations77.combine(4, 2));
    System.out.println(combinations77.combine(4, 3));
    System.out.println(combinations77.combine(5, 3));
    System.out.println(combinations77.combine(10, 4));
    System.out.println(combinations77.combine(1, 1));
    System.out.println(combinations77.combine(3, 1));
  }
}
