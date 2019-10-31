package com.tobias.cat;

/**
 * 846. 多关键字排序 给定 n 个学生的学号(从 1 到 n 编号)以及他们的考试成绩，表示为(学号，考试成绩)，请将这些学生按考试成绩降序排序，若考试成绩相同，则按学号升序排序。
 *
 * 样例 样例1
 *
 * 输入: array = [[2,50],[1,50],[3,100]] 输出: [[3,100],[1,50],[2,50]] 样例2
 *
 * 输入: array = [[2,50],[1,50],[3,50]] 输出: [[1,50],[2,50],[3,50]]
 */
public class Solution846 {

  public static void main(String[] args) {

  }

  public int[][] multiSort(int[][] array) {
    // Write your code here
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        int[] temp = array[i];
        if (array[i][1] < array[j][1]) {
          array[i] = array[j];
          array[j] = temp;
        } else if (array[i][1] == array[j][1]) {
          if (array[i][0] > array[j][0]) {
            array[i] = array[j];
            array[j] = temp;
          }
        }
      }
    }
    return array;

  }

}
