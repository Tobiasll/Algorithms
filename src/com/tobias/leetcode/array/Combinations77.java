package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2 Output: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */
public class Combinations77 {


  /**
   * Runtime: 6 ms, faster than 82.69% of Java online submissions for Combinations.
   * Memory Usage: 38.8 MB, less than 86.96% of Java online submissions for Combinations.
   */
  public List<List<Integer>> combineByIterator(int n, int k) {
    if (n == 0 || k == 0 || k > n) {
      return Collections.emptyList();
    }
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 1; i <= n + 1 - k; i++) {
      res.add(Collections.singletonList(i));
    }
    //第一层循环，从 2 到 k
    for (int i = 2; i <= k; i++) {
      List<List<Integer>> tmp = new ArrayList<>();
      //第二层循环，遍历之前所有的结果
      for (List<Integer> list : res) {
        //第三次循环，对每个结果进行扩展
        //从最后一个元素加 1 开始，然后不是到 n ，而是和解法一的优化一样
        //(k - (i - 1） 代表当前已经有的个数，最后再加 1 是因为取了 n
        // m = 拿到当前层集合的最后一个元素然后再加一，然后放进新集合中，新集合包含了旧集合的数还有一个递增的数
        for (int m = list.get(list.size() - 1) + 1; m <= n - (k - (i - 1)) + 1; m++) {
          List<Integer> newList = new ArrayList<Integer>(list);
          newList.add(m);
          tmp.add(newList);
        }
      }
      res = tmp;
    }

    return res;
  }


  /**
   * Runtime: 58 ms, faster than 5.15% of Java online submissions for Combinations. Memory Usage:
   * 43.8 MB, less than 6.52% of Java online submissions for Combinations.
   */
  public List<List<Integer>> combineByIteratorSimulateBacktrack(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> insideList = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      insideList.add(0);
    }
    int i = 0;
    while (i >= 0) {
      insideList.set(i, insideList.get(i) + 1);
      if (insideList.get(i) > n) {
        i--;
      } else if (i == k - 1) {
        result.add(new ArrayList<>(insideList));
      } else {
        i++;
        insideList.set(i, insideList.get(i - 1));
      }

    }
    return result;
  }

  /**
   * Runtime: 2 ms, faster than 96.57% of Java online submissions for Combinations. Memory Usage:
   * 39.4 MB, less than 82.61% of Java online submissions for Combinations.
   */
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(1, n, k, result, new ArrayList<>());
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
    System.out.println(combinations77.combineByIterator(4, 2));
    System.out.println(combinations77.combineByIterator(4, 3));
    System.out.println(combinations77.combineByIterator(5, 3));
    System.out.println(combinations77.combineByIterator(10, 4));
    System.out.println(combinations77.combineByIterator(1, 1));
    System.out.println(combinations77.combineByIterator(3, 1));
  }
}
