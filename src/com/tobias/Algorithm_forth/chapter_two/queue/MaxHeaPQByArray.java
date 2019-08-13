package com.tobias.Algorithm_forth.chapter_two.queue;

import java.util.Arrays;

public class MaxHeaPQByArray<Key extends Comparable<Key>> {

  private Key[] pq;
  private int size;

  public MaxHeaPQByArray(Key[] arr) {
    this.pq = (Key[]) new Comparable[arr.length + 1];
    if (arr.length >= 0) {
      System.arraycopy(arr, 0, pq, 1, arr.length);
      this.size = arr.length;
    }
    for (int i = pq.length / 2; i >= 1; i--) {
      sink(i);
    }
  }

  private MaxHeaPQByArray(int capacity) {
    pq = (Key[]) new Comparable[capacity + 1];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }

  public boolean less(int first, int second) {
    return pq[first].compareTo(pq[second]) < 0;
  }

  public void exch(int source, int target) {
    Key temp = pq[source];
    pq[source] = pq[target];
    pq[target] = temp;
  }

  public void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exch(k / 2, k);
      k = k / 2;
    }
  }

  public void sink(int k) {
    while (k * 2 <= size) {
      int j = k * 2;
      if (j < size && less(j, j + 1)) {
        j++;
      }
      if (!less(k, j)) {
        break;
      }
      exch(j, k);
      k = j;
    }
  }

  public void insert(Key key) {
    pq[++size] = key;
    swim(size);
  }

  public Key delMax() {
    Key max = pq[1];
    pq[1] = pq[size];
    sink(1);
    pq[size--] = null;
    return max;
  }

  public Key[] getSortArr() {
    Key[] tempArr = (Key[]) new Comparable[pq.length];
    if (pq.length >= 0) {
      System.arraycopy(pq, 0, tempArr, 0, pq.length);
    }
    Key[] sortArr = (Key[]) new Comparable[pq.length - 1];
    for (int i = 0; i < sortArr.length; i++) {
      sortArr[i] = delMax();
    }
    pq = tempArr;
    size = sortArr.length;
    return sortArr;
  }


  @Override
  public String toString() {
    return Arrays.toString(pq);
  }

  public static void main(String[] args) {
    Character[] chars = new Character[]{'A', 'D', 'B', 'H', 'E', 'F', 'L', 'C'};
    MaxHeaPQByArray<Character> maxPQ = new MaxHeaPQByArray<>(chars);
//    MaxHeaPQByArray<Character> maxPQ = new MaxHeaPQByArray<>(10);
/*    maxPQ.insert('A');
    maxPQ.insert('D');
    maxPQ.insert('B');
    maxPQ.insert('H');
    maxPQ.insert('E');
    maxPQ.insert('F');
    maxPQ.insert('L');*/

    System.out.println(maxPQ);
    System.out.println(Arrays.toString(maxPQ.getSortArr()));
    System.out.println(maxPQ);
    int size = maxPQ.getSize();
    for (int i = 0; i < size; i++) {
      System.out.println(maxPQ.delMax());
    }
  }
}
