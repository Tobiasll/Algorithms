package com.tobias.rudiment.queue;

public class LoopQueue<E> implements Queue<E> {

  private E[] data;
  private int front, tail;

  public LoopQueue(int capacity) {
    data = (E[]) new Object[capacity + 1];
    front = 0;
    tail = 0;

  }

  public LoopQueue() {
    this(10);
  }

  public int getCapacity() {
    return data.length - 1;
  }

  @Override
  public boolean isEmpty() {
    return front == tail;
  }

  @Override
  public int getSize() {
    return tail - front;
  }


  @Override
  public void enqueue(E e) {
    if (front == (tail + 1) % data.length) {
      resize(getCapacity() * 2);
    }

    data[tail] = e;
    tail = (tail + 1) % data.length;

  }


  private void resize(int newCapacity) {
    E[] newData = (E[]) new Object[newCapacity + 1];
    for (int i = 0; i < getSize(); i++) {
      newData[i] = data[(front + i) % data.length];
    }
    data = newData;
    front = 0;
    tail = getSize();
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
    }

    E oldValue = data[front];
    data[front] = null;

    if (getSize() <= data.length / 4 && data.length / 2 != 0) {
      resize(data.length / 2);
    }

    front = (front + 1) % data.length;
    return oldValue;
  }


  @Override
  public E getFront() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
    }
    return data[front];
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
    sb.append("front [");
    for (int i = front; i != tail; i = (i + 1) % data.length) {
      sb.append(data[i]);
      if (tail != (i + 1) % data.length) {
        sb.append(", ");
      }

    }

    sb.append("], tail");
    return sb.toString();
  }


  public static void main(String[] args) {

    LoopQueue<Integer> queue = new LoopQueue<>();
    for (int i = 0; i < 10; i++) {
      queue.enqueue(i);
      System.out.println(queue);

      if (i % 3 == 2) {
        queue.dequeue();
        System.out.println(queue);
      }
    }

  }
}
