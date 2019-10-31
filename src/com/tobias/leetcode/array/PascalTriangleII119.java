package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3 Output: [1,3,3,1]
 */
public class PascalTriangleII119 {

  public List<Integer> bestGetRow(int rowIndex) {
    List<Integer> result = new ArrayList<>(rowIndex + 1);
    for (int i = 0; i <= rowIndex; i++) {
      result.add(1);
      for (int j = i - 1; j > 0; j--) {
        result.set(j, result.get(j) + result.get(j - 1));
      }
    }
    return result;
  }

  public List<Integer> getRow(int rowIndex) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(Collections.singletonList(1));

    for (int i = 0; i < rowIndex; i++) {
      List<Integer> insideList = new ArrayList<>();
      insideList.add(1);
      List<Integer> list = result.get(i);
      for (int j = 0; j < list.size() - 1; j++) {
        insideList.add(list.get(j) + list.get(j + 1));
      }
      insideList.add(1);
      result.add(insideList);
    }
    for (List<Integer> list : result) {
      System.out.println(list);
    }
    return result.get(rowIndex);
  }

  public static void main(String[] args) {
    PascalTriangleII119 pascalTriangleII119 = new PascalTriangleII119();
    System.out.println(pascalTriangleII119.bestGetRow(5));
  }

}
