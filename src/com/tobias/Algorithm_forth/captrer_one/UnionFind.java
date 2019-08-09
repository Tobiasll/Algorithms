package com.tobias.Algorithm_forth.captrer_one;

import java.util.Arrays;

public class UnionFind {

  private int[] ids;
  private int count;
  private int[] weight;

  public UnionFind(int N) {
    this.count = N;
    this.ids = new int[N];
    for (int i = 0; i < N; i++) {
      ids[i] = i;
      weight[i] = 1;
    }
  }

  public int getCount() {
    return this.count;
  }

  public void printIds() {
    System.out.println(Arrays.toString(ids));
  }

  public boolean connect(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    return quickUnionFind(p);
  }

  public void union(int p, int q) {
    quickUnion(p, q);
  }

  private void quickUnionWithWeight(int p, int q) {
    int i = quickUnionFind(p);
    int j = quickUnionFind(q);
    if (weight[i] < weight[j]) {
      ids[i] = j;
      weight[j] += weight[i];
    } else {
      ids[j] = i;
      weight[i] = weight[j];
    }
  }


  private void quickUnion(int p, int q) {
    int pRoot = quickUnionFind(p);
    int qRoot = quickUnionFind(q);
    if (pRoot == qRoot) {
      return;
    }
    ids[pRoot] = qRoot;
    count--;
  }

  private int quickUnionFind(int p) {
    while (ids[p] != p) {
      p = ids[p];
    }
    return p;
  }

  public void unionQuickFind(int p, int q) {
    int pID = ids[p];
    int qID = ids[q];

    if (pID == qID) {
      return;
    }

    for (int i = 0; i < ids.length; i++) {
      if (pID == ids[i]) {
        ids[i] = qID;
      }
    }
    count--;
  }

  private int quickFind(int p) {
    return ids[p];
  }

  //    private static int[] targets = {9, 0, 3, 4, 5, 8, 7, 2, 2, 1, 5, 7, 0, 3, 4, 2};
  private static int[] targets = {4, 3, 3, 8, 6, 5, 9, 4, 2, 1, 8, 9, 5, 0, 7, 2, 6, 1, 1, 0, 6, 7};

  public static void main(String[] args) {
    UnionFind uf = new UnionFind(10);
    for (int i = 0; i < targets.length; i += 2) {
      if (uf.connect(targets[i], targets[i + 1])) {
        continue;
      }
      uf.union(targets[i], targets[i + 1]);
      uf.printIds();
    }
    System.out.println("uf count : " + uf.getCount());
  }

}
