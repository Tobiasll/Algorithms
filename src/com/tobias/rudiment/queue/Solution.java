package com.tobias.rudiment.queue;

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {

  public List<Integer> topKFrequent(int[] nums, int k) {

    TreeMap<Integer, Integer> map = new TreeMap<>();

    for (int num : nums) {
      if (map.get(num) == null) {
        map.put(num, 1);
      } else {
        map.put(num, map.get(num) + 1);
      }
    }
    System.out.println(map);

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int key : map.keySet()) {
      if (pq.size() < k) {
        pq.add(key);
      } else if (map.get(key) > map.get(pq.peek())) {
        pq.remove();
        pq.add(key);
      }
    }
    System.out.println(pq);
    return null;
  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 4, 2, 2, 3};

    Solution solution = new Solution();
    solution.topKFrequent(arr, 3);

  }

}
