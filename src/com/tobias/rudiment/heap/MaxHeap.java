package com.tobias.rudiment.heap;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

  private Array<E> data;

  public MaxHeap(int capacity) {
    this.data = new Array<>(capacity);
  }

  public MaxHeap() {
    this.data = new Array<>();
  }

  // 返回堆中的元素个数
  public int size() {
    return data.getSize();
  }

  // 返回一个布尔值, 表示堆中是否为空
  public boolean isEmpty() {
    return data.isEmpty();
  }

  // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
  public int parent(int index) {
    return (index - 1) / 2;
  }

  // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
  public int leftChild(int index) {
    return index * 2 + 1;
  }

  // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
  public int rightChild(int index) {
    return index * 2 + 2;
  }

  // 向堆中添加元素
  public void add(E e) {
    this.data.addLast(e);
    siftUp(data.getSize() - 1);
  }

  private void siftUp(int k) {
    while (k > 0 && data.get(parent(k)).compareTo(this.data.get(k)) < 0) {
      this.data.swap(k, parent(k));
      k = parent(k);
    }
  }

  // 看堆中的最大元素
  public E findMaxElement() {
    if (data.getSize() == 0) {
      throw new IllegalArgumentException("Can not findMax when heap is empty.");
    }
    return this.data.get(0);
  }

  // 取出堆中最大元素
  public E removeMaxElement() {
    E ret = findMaxElement();
    this.data.swap(0, this.data.getSize() - 1);
    this.data.removeLast();
    siftDown(0);
    return ret;
  }


  private void siftDown(int k) {
    while (leftChild(k) < data.getSize()) {
      int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
      if (j + 1 < data.getSize() &&
          data.get(j + 1).compareTo(data.get(j)) > 0) {
        j = rightChild(k);
      }
      // data[j] 是 leftChild 和 rightChild 中的最大值

      if (data.get(k).compareTo(data.get(j)) >= 0) {
        break;
      }

      data.swap(k, j);
      k = j;
    }
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < this.data.getSize(); i++) {
      stringBuilder.append(this.data.get(i)).append("-->");
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    MaxHeap<Integer> maxHeap = new MaxHeap<>();
    Random random = new Random();
    for (int i = 0; i < 19; i++) {
      maxHeap.add(random.nextInt(1000));
    }

    System.out.println(maxHeap);
    System.out.println(maxHeap.removeMaxElement());
    System.out.println(maxHeap);

  }

}
