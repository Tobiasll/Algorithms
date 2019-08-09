package com.tobias.Algorithm_forth.chapter_two.queue;

public abstract class MaxPQ<E extends Comparable<E>> {

  protected Comparable[] arrays;
  protected int size;

  public MaxPQ() {
    arrays = new Comparable[10];
  }

  public MaxPQ(int capacity) {
    arrays = new Comparable[capacity];
  }

  public MaxPQ(E[] arrays) {
    this.arrays = arrays;
  }

  public boolean greater(Comparable first, Comparable second) {
    return first.compareTo(second) > 0;
  }

  public boolean less(Comparable first, Comparable second) {
    return first.compareTo(second) < 0;
  }

  public void swap(Comparable[] sourceArr, int first, int second) {
    Comparable temp = sourceArr[first];
    sourceArr[first] = sourceArr[second];
    sourceArr[second] = temp;
  }

  public abstract void insert(E k);

  public abstract E max();

  public abstract E delMax() ;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

}
