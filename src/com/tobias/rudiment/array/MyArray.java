package com.tobias.rudiment.array;

/**
 * @author Tobias
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class MyArray<E extends Number> {

  private int[] data;
  private int size;
  private static final int CAPACITY = 10;
  private static final int REDUCE_MULTIPLE = 4;


  public MyArray(int capacity) {
    this.data = new int[capacity];
  }

  public MyArray() {
    this(CAPACITY);
  }

  public int getCapacityLength() {
    // 获取数组的容量
    return data.length;
  }

  public int getSize() {
    // 获取数组中的元素个数
    return size;
  }

  public boolean isEmpty() {
    // 返回数组是否为空
    return size == 0;
  }

  public void addLast(int element) {
    // 向所有元素后添加一个新元素
    add(size, element);
  }

  public void addFirst(int element) {
    // 在所有元素前添加一个新元素
    add(0, element);
  }

  public void insert(int index, int element) {
    // 在index索引的位置插入一个新元素e
    add(index, element);
  }

  private void add(int index, int element) {
    if (size == data.length) {
      throw new IllegalArgumentException("Add failed. Array is full.");
    }

    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
    }

    if (size - index >= 0) {
      System.arraycopy(data, index, data, index + 1, size - index);
    }

    data[index] = element;
    size++;

    if (size == data.length) {
      resize(data.length * 2);
    }
  }

  public int get(int index) {
    // 获取index索引位置的元素
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Get failed. Require index >= 0 and index <= size.");
    }
    return data[index];
  }

  public int set(int index, int element) {
    // 修改index索引位置的元素为e
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Set failed. Require index >= 0 and index <= size.");
    }
    int oldElement = data[index];
    data[index] = element;
    return oldElement;
  }

  public boolean contain(int element) {
    // 查找数组中是否有元素e
    for (int i = 0; i < size; i++) {
      if (data[i] == element) {
        return true;
      }
    }
    return false;
  }

  public int findElement(int element) {
    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    for (int i = 0; i < size; i++) {
      if (data[i] == element) {
        return i;
      }
    }
    return -1;
  }

  public int removeIndex(int index) {
    // 从数组中删除index位置的元素, 返回删除的元素
    if (index < 0 || index > size) {
      throw new IllegalArgumentException(
          "removeIndex failed. Require index >= 0 and index <= size.");
    }

    int elementOfRemove = data[index];
    if (size - index >= 0) {
      System.arraycopy(data, index + 1, data, index, size - index);
    }
    size--;
    if (size == data.length / REDUCE_MULTIPLE && data.length > CAPACITY) {
      resize(data.length / 2);
    }
    return elementOfRemove;
  }

  public int removeFirst() {
    // 从数组中删除第一个元素, 返回删除的元素
    return removeIndex(0);
  }

  public int removeLast() {
    // 从数组中删除最后一个元素, 返回删除的元素
    return removeIndex(size - 1);
  }

  public void removeElement(int element) {
    // 从数组中删除元素e
    int resultIndex = findElement(element);
    if (resultIndex != -1) {
      removeIndex(resultIndex);
    }
  }

  private void resize(int capacity) {
    // 扩容
    int[] newData = new int[capacity];
    System.arraycopy(data, 0, newData, 0, size);
    data = newData;
  }

  public int getSum() {
    int result = 0;
    for (int i : data) {
      result += i;
    }
    return result;
  }

  @Override
  public String toString() {
    if (size > 0) {
      StringBuilder result = new StringBuilder("[");
      for (int i = 0; i < size; i++) {
        result.append(data[i]);
        if (i == size - 1) {
          break;
        }
        result.append(", ");
      }
      result.append(']');
      return result.toString();
//      return result.toString().substring(0, result.length() - 2) + "]";
    }
    return "[]";
  }
}
