package com.tobias.Algorithm_forth.chapter_three.part_one;

public class BinarySearchFind<K extends Comparable<K>, V>  {

  private K[] keys;
  private V[] values;
  private int size;

  public BinarySearchFind(int capacity) {
    keys = (K[]) new Comparable[capacity];
    values = (V[]) new Comparable[capacity];
  }


  public BinarySearchFind() {
    this(20);
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }

  public void put(K key, V value) {
    int rank = rank(key);
    if (rank < size && keys[rank].compareTo(key) == 0) {
      values[rank] = value;
    } else {
      for (int i = size; i >= rank; i--) {
        keys[i + 1] = keys[i];
        values[i + 1] = values[i];
      }
      keys[rank] = key;
      values[rank] = value;
      size++;
    }
  }

  public V get(K key) {
    if (isEmpty()) {
      return null;
    }
    int rank = rank(key);
    if (rank < size) {
      return values[rank]; }

    return null;
  }

  public V delete(K key) {
    int rank = rank(key);
    if (rank < size && key.compareTo(keys[rank]) == 0) {
      V result = values[rank];
      for (int i = rank; i < size; i++) {
        keys[i] = keys[i + 1];
        values[i] = values[i + 1];
      }
      keys[size - 1] = null;
      values[size - 1] = null;
      size--;
      return result;
    }
    return null;
  }

  private int rank(K key) {
    int low = 0, hi = size - 1;
    while (low <= hi) {
      int mid = (low + hi) / 2;
      if (keys[mid].compareTo(key) > 0) {
        hi = mid - 1;
      } else if (keys[mid].compareTo(key) < 0) {
         low = mid + 1;
      } else {
        return mid;
      }
    }
    return low;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append(keys[i]).append(" : ").append(values[i]).append(", ");
    }
    return sb.toString().substring(0, sb.length() - 2);
  }

  public static void main(String[] args) {
    BinarySearchFind<Character, Integer> bsf = new BinarySearchFind<>();
    bsf.put('A', 1);
    bsf.put('D', 4);
    bsf.put('B', 2);
    bsf.put('C', 3);
    System.out.println(bsf);
    System.out.println(bsf.get('A'));
    System.out.println(bsf.delete('A'));
    System.out.println(bsf);
  }

}
