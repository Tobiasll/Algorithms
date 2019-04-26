package com.tobias.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
  public static void main(String[] args) {
    System.out.println(sort(
        new ArrayList<>(Arrays.asList(8, 9, 1, 7, 2, 3, 5, 4, 6, 0))));
  }

  private static List<Integer> sort(List<Integer> lists) {
    sort(lists, 0, lists.size() - 1);
    return lists;
  }

  private static void sort(List<Integer> lists, int l, int h) {
    if (l >= h) {
      return;
    }
    int j = partition(lists, l, h);
    sort(lists, l, j - 1);
    sort(lists, j + 1, h);

  }

  private static int partition(List<Integer> lists, int l , int h) {
    //8, 9, 1, 7, 2, 3, 5, 4, 6, 0
    int i = l, j = h + 1;
     int firstValue = lists.get(l);

     while (true) {
       while (lists.get(++i) < firstValue && i != h);
       while (lists.get(--j) > firstValue && j != l);
       if (i >= j) {
         break;
       }
       Integer temp = lists.get(i);
       lists.set(i, lists.get(j));
       lists.set(j, temp);
     }
      Integer temp = lists.get(l);
      lists.set(l, lists.get(j));
      lists.set(j, temp);
    return j;
  }
}
