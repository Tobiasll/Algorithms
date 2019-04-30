package com.tobias.rudiment.sort;

import com.tobias.util.ArraysUtils;
import java.util.Arrays;

public class HeapSort {

  //声明全局变量，用于记录数组array的长度；
  private static int len;

  /**
   * 堆排序算法
   */
  public static int[] heapSort(int[] array) {
    len = array.length;
    if (len < 1)
      return array;
    //1.构建一个最大堆
    buildMaxHeap(array);
    //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
    while (len > 0) {
      ArraysUtils.swap(array, 0, len - 1);
      len--;
      adjustHeap(array, 0);
    }
    return array;
  }

  /**
   * 建立最大堆
   */
  private static void buildMaxHeap(int[] array) {
    //从最后一个非叶子节点开始向上构造最大堆
    for (int i = (len - 1) / 2; i >= 0; i--) {
      adjustHeap(array, i);
    }
  }

  private static void adjustHeap(int[] array, int i) {
    int maxIndex = i;
    //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
    if (i * 2 < len && array[i * 2] > array[maxIndex])
      maxIndex = i * 2;
    //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
    if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
      maxIndex = i * 2 + 1;
    //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
    if (maxIndex != i) {
      ArraysUtils.swap(array, maxIndex, i);
      adjustHeap(array, maxIndex);
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(heapSort(new int[]{4, 5, 6, 1, 3, 2})));
  }

}