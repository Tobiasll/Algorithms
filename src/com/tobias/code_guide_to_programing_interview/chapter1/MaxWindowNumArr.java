package com.tobias.code_guide_to_programing_interview.chapter1;

import java.util.LinkedList;
import java.util.Random;

public class MaxWindowNumArr {


  /**
   * 数据量10000000的随机数；用时52毫秒
   */
  public int[] getMaxWindowNumArr(int[] arr, int window) {
    int[] result = new int[arr.length - window + 1];
    for (int i = 0; i < result.length; i++) {
      int max = arr[i];
      for (int j = i + 1; j < window + i; j++) {
        if (arr[j] > max) {
          max = arr[j];
        }
      }
      result[i] = max;
    }
    return result;
  }


  /**
   * 数据量10000000的随机数；用时333毫秒
   */
  public int[] getMaxWindowNumArrUseQueue(int[] arr, int window) {
    LinkedList<Integer> queue = new LinkedList<>();
    int[] result = new int[arr.length - window + 1];
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]) {
        queue.pollLast();
      }
      queue.add(i);
      // 巧妙的避免队列头部过期的方式，无法理解作者的思维，需要多加思考
      if (queue.peekFirst() == i - window) {
        queue.pollFirst();
      }
      if (i >= window - 1) {
        result[index++] = arr[queue.peekFirst()];
      }
    }
    return result;
  }


  public static void main(String[] args) {
    Random random = new Random();
    int[] arr = new int[10000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(10000000);
    }

    long start = System.currentTimeMillis();
    new MaxWindowNumArr().getMaxWindowNumArr(arr, 3);
    long end = System.currentTimeMillis();
    System.out.println("用时： " + (end - start));
  }

}
