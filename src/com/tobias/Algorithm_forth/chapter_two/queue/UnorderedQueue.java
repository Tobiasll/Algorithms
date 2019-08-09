package com.tobias.Algorithm_forth.chapter_two.queue;

/**
 * 无序优先队列实现
 * @author Tobias
 */
public class UnorderedQueue extends MaxPQ {

  private int maxIndex = 0;
  private volatile boolean isLatestData = false;

  public UnorderedQueue() {
    super();
  }

  public UnorderedQueue(int capacity) {
    super(capacity);
  }

  public UnorderedQueue(Comparable[] arrays) {
    super(arrays);
  }

  @Override
  public void insert(Comparable k) {
    arrays[size()] = k;
    size++;
    isLatestData = false;
  }

  @Override
  public Comparable max() {
    if (isEmpty()) {
      throw new IllegalCallerException("current queue hasn't element!");
    }
    Comparable max = arrays[0];
    for (int i = 1; i < size(); i++) {
      if (greater(arrays[i], max)) {
        max = arrays[i];
        maxIndex = i;
      }
    }
    isLatestData = true;
    return max;
  }

  @Override
  public Comparable delMax() {
    if (isEmpty()) {
      throw new IllegalCallerException("current queue hasn't element!");
    }
    if (!isLatestData) {
      max();
      isLatestData = false;
    }
    Comparable max = arrays[maxIndex];
    arrays[maxIndex] = arrays[size() - 1];
    arrays[size() - 1] = null;
    size--;
    return max;
  }

  @Override
  public String toString() {
    if (isEmpty()) {
      return "[]";
    }
    StringBuilder result = new StringBuilder("[");
    for (int i = 0; i < size(); i++) {
      result.append(arrays[i]).append(", ");
    }
    return result.toString().substring(0, result.length() - 2) + "]";
  }

  public static void main(String[] args) {
    UnorderedQueue unorderedQueue = new UnorderedQueue();
    System.out.println(unorderedQueue);
    unorderedQueue.insert("A");
    unorderedQueue.insert("G");
    unorderedQueue.insert("B");
    System.out.println(unorderedQueue);
    System.out.println(unorderedQueue.delMax());
    System.out.println(unorderedQueue);
  }
}
