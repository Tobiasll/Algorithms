package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5 Output: [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 */
public class PascalsTriangle118 {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows == 0) {
      return result;
    }
    result.add(Collections.singletonList(1));
    for (int i = 0; i < numRows - 1; i++) {
      List<Integer> sourceList = result.get(i);
      List<Integer> newList = new ArrayList<>(sourceList.size() + 1);
      newList.add(1);
      if (sourceList.size() > 1) {
        for (int j = 0; j < sourceList.size() - 1; j++) {
          newList.add(sourceList.get(j) + sourceList.get(j + 1));
        }
      }
      newList.add(1);
      result.add(newList);
    }
    return result;
  }

  public static void main(String[] args) {
    PascalsTriangle118 pascalsTriangle118 = new PascalsTriangle118();
    List<List<Integer>> generate = pascalsTriangle118.generate(10);
    for (List<Integer> list : generate) {
      System.out.println(list);
    }
  }
}
