package com.tobias.cat;

/**
 * 60. 搜索插入位置
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 *
 * 你可以假设在数组中无重复元素。
 *
 * 样例
 * [1,3,5,6]，5 → 2
 *
 * [1,3,5,6]，2 → 1
 *
 * [1,3,5,6]， 7 → 4
 *
 * [1,3,5,6]，0 → 0
 *
 * 挑战
 * 时间复杂度为O(log(n))
 */
public class Solution60 {

  public static void main(String[] args) {
    System.out.println(searchInsertByBinary(new int[]{1,3,5,6}, 5));
    System.out.println(searchInsertByBinary(new int[]{1,3,5,6}, 2));
    System.out.println(searchInsertByBinary(new int[]{1,3,5,6}, 7));
    System.out.println(searchInsertByBinary(new int[]{1,3,5,6}, 0));
  }

  private static int searchInsert(int[] A, int target) {
    // write your code here
    for (int i = 0; i < A.length; i++) {
      if (A[i] == target) {
        return i;
      } else if (A[i] > target) {
        if (i != 0) {
          return i;
        } else {
          return 0;
        }
      }
    }
    return A.length;
  }

  private static int searchInsertByBinary(int[] A, int target) {
    int low = 0, high = A.length - 1, mid = 0;
    if(A.length == 0) return 0;
    while(low <= high){
      mid = (low + high) / 2;
      if(A[mid] == target) return mid;
      else if(A[mid] > target) high = mid-1;
      else low = mid+1;
    }
    if(A[mid] > target) return mid;
    else return mid + 1;

  }
}
