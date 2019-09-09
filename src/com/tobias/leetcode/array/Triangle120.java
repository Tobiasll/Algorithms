package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      {2},
 *     {3,4},
 *    {6,5,7},
 *   {4,1,8,3}
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle120 {


  public int minimumTotal(List<List<Integer>> triangle) {
    int sum = 0;
    for (List<Integer> insideList : triangle) {
      int min = insideList.get(0);
      for (int i = 1; i < insideList.size(); i++) {
        if (insideList.get(i) < min) {
          min = insideList.get(i);
        }
      }
      sum += min;
    }
    return sum;
  }

  public static void main(String[] args) {
    Triangle120 triangle120 = new Triangle120();
    List<List<Integer>> triangle = new ArrayList<>();
//    [[-1],[2,3],[1,-1,-3]]
    triangle.add(Collections.singletonList(-1));
    triangle.add(Arrays.asList(2,3));
    triangle.add(Arrays.asList(1,-1,-3));
//    triangle.add(Arrays.asList(4,1,8,3));
    System.out.println(triangle120.minimumTotal(triangle));
  }
}
