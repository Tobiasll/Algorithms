package com.tobias.rudiment.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

  static class Node{
    char value;
    int weight;

    public Node() {
    }

    public Node(char value, int weight) {
      this.value = value;
      this.weight = weight;
    }
  }

  private static Map<Character, List<Node>> graph = new HashMap<>();

  static {
    graph.put('A', Arrays.asList(new Node('B', 5), new Node('C', 1)));
    graph.put('B', Arrays.asList(new Node('A', 5), new Node('C', 2), new Node('D', 1)));
    graph.put('C', Arrays.asList(new Node('B', 2), new Node('A', 1),
        new Node('D', 4), new Node('E', 8)));
    graph.put('D', Arrays.asList(new Node('B', 1), new Node('C', 4),
        new Node('E', 3), new Node('F', 6)));
    graph.put('E', Arrays.asList(new Node('C', 8), new Node('D', 3)));
    graph.put('F', Collections.singletonList(new Node('D', 6)));
  }

  public static Map<String, Object> dijkstra(char start, char end) {
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
    pq.add(new Node(start, 0));
    boolean[] seen = new boolean[graph.size()];

    char[] parent = new char[graph.size()];
    parent[start - 'A'] = ' ';
    int[] distance = new int[graph.size()];
    for (char s : graph.keySet()) {
      if (s != start) {
        distance[s - 'A'] = Integer.MAX_VALUE;
      }
    }
    while (!pq.isEmpty()) {
      Node pair = pq.poll();
      int dist = pair.weight;
      char vertex = pair.value;
      seen[vertex - 'A'] = true;
      List<Node> nodes = graph.get(vertex);
      for (Node node : nodes) {
        if (!seen[node.value - 'A']) {
          if (dist + node.weight < distance[node.value - 'A']) {
            node.weight += dist;
            pq.add(node);
            parent[node.value - 'A'] =  vertex;
            distance[node.value - 'A'] =  node.weight;
          }
        }
      }

    }
    Map<String, Object> result = new HashMap<>(2);
    result.put("mintPath", distance[end - 'A']);
    StringBuilder sb = new StringBuilder();
    while (end != ' ') {
      sb.append(end).append(" -> ");
      end = parent[end - 'A'];
    }
    result.put("path", sb.substring(0, sb.length() - 3));
    return result;
  }

  public static Map<String, Object> getMinPathAndPrintPath(char start, char end) {
    return dijkstra(start, end);

  }

  public static void main(String[] args) {
    System.out.println(getMinPathAndPrintPath('A', 'F'));
  }
}
