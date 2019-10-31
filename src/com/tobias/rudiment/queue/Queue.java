package com.tobias.rudiment.queue;

public interface Queue<E> {

  int getSize();

  boolean isEmpty();

  void enqueue(E e);

  E dequeue();

  E getFront();
}
