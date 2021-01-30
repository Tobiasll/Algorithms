package com.tobias.rudiment.union_find;

public class UnionFind implements UF {

  private final int[] parent;
  private final int[] rank;

  public UnionFind(int size) {
    parent = new int[size];
    rank = new int[size];

    for (int i = 0; i < size; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }

  private int find(int p) {
    if (p < 0 || p >= parent.length) {
      throw new IllegalArgumentException("p is out of bound.");
    }

    while (p != parent[p]) {
      parent[p] = parent[parent[p]];
      p = parent[p];
    }

    return p;

  }

  @Override
  public int getSize() {
    return parent.length;
  }

  @Override
  public boolean isConnected(int p, int q) {
    if (p < 0 || p >= parent.length) {
      throw new IllegalArgumentException("p is out of bound.");
    }
    return find(p) == find(q);
  }

  @Override
  public void unionElements(int p, int q) {

    int pRoot = find(p);
    int qRoot = find(q);

    if (pRoot == qRoot) {
      return;
    }

    if (rank[pRoot] < rank[qRoot]) {
      parent[pRoot] = qRoot;
    } else if (rank[qRoot] < rank[pRoot]) {
      parent[qRoot] = pRoot;
    } else {
      parent[pRoot] = qRoot;
      rank[qRoot]++;
    }

  }
}
