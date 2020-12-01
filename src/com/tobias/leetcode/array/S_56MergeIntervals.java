package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]] Explanation: Since intervals
 * [1,3] and [2,6] overlaps, merge them into [1,6]. Example 2:
 *
 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are considered
 * overlapping. NOTE: input types have been changed on April 15, 2019. Please reset to default code
 * definition to get new method signature.
 */
public class S_56MergeIntervals {

  public int[][] merge(int[][] intervals) {
    List<int[]> result = new ArrayList<>();
//    sort(intervals);

    Arrays.sort(intervals, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });
    for (int i = 0; i < intervals.length; i++) {
      int firstNum = intervals[i][0];
      int secondNum = intervals[i][1];

      while (i + 1 < intervals.length && secondNum <= intervals[i + 1][1] && secondNum >= intervals[
          i + 1][0]) {
        secondNum = intervals[i + 1][1];
        i++;
      }

      result.add(new int[]{firstNum, secondNum});
    }
    int[][] resultInt = new int[result.size()][2];
    for (int i = 0; i < result.size(); i++) {
      resultInt[i] = result.get(i);
    }
    return resultInt;
  }

  private int[][] sort(int[][] intervals) {
    sort(intervals, 0, intervals.length - 1);
    return intervals;
  }

  private void sort(int[][] intervals, int l, int h) {
    if (l >= h) {
      return;
    }
    int j = partition(intervals, l, h);
    sort(intervals, l, j - 1);
    sort(intervals, j + 1, h);

  }

  private int partition(int[][] intervals, int l, int h) {
    //8, 9, 1, 7, 2, 3, 5, 4, 6, 0
    int i = l, j = h + 1;
    int firstValue = intervals[l][0];

    while (true) {
      while (intervals[++i][0] < firstValue && i != h) {
      }
      while (intervals[--j][0] > firstValue && j != l) {
      }
      if (i >= j) {
        break;
      }
      int[] temp = intervals[i];
      intervals[i] = intervals[j];
      intervals[j] = temp;

    }
    int[] temp = intervals[l];
    intervals[l] = intervals[j];
    intervals[j] = temp;
    return j;
  }


  public static void main(String[] args) {
    S_56MergeIntervals s_56MergeIntervals = new S_56MergeIntervals();
    int[][] merge = s_56MergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
//    int[][] merge = s_56MergeIntervals.merge(new int[][]{{1, 4}, {0, 4}});
//    int[][] merge = s_56MergeIntervals.merge(new int[][]{{1, 4}, {1, 5}});
//    int[][] merge = s_56MergeIntervals.merge(new int[][]{{1,4},{2,3}});
    for (int[] insideArray : merge) {
      System.out.println(Arrays.toString(insideArray));
    }
  }

}
