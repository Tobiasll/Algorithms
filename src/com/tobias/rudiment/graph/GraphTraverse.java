package com.tobias.rudiment.graph;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 */
public class GraphTraverse {

  private static final Map<String, List<String>> graph = new HashMap<>();
  static {
    graph.put("A", Arrays.asList("B", "C"));
    graph.put("B", Arrays.asList("A", "C", "D"));
    graph.put("C", Arrays.asList("A", "B", "D"));
    graph.put("D", Arrays.asList("B", "C", "E", "F"));
    graph.put("E", Arrays.asList("D", "C"));
    graph.put("F", Collections.singletonList("D"));
  }

  public static Map<String, String> BFS(String start) {
    LinkedList<String> queue = new LinkedList<>();
    Set<String> set = new HashSet<>();
    Map<String, String> map = new HashMap<>();
    queue.add(start);
    set.add(start);
    map.put(start, null);
    while (!queue.isEmpty()) {
      String pollString = queue.poll();
      List<String> list = graph.get(pollString);
      for (String s : list) {
        if (!set.contains(s)) {
          queue.add(s);
          set.add(s);
          map.put(s, pollString);
        }
      }
//      System.out.println(pollString);
    }

    return map;
  }

  public static void DFS(String start) {
    Stack<String> stack = new Stack<>();
    Set<String> set = new HashSet<>();
    stack.add(start);
    set.add(start);
    while (!stack.isEmpty()) {
      String pollString = stack.pop();
      List<String> list = graph.get(pollString);
      for (String s : list) {
        if (!set.contains(s)) {
          stack.add(s);
          set.add(s);
        }
      }
//      System.out.println(pollString);
    }
  }


  public static int getMinPath(String start, String end) {
    Map<String, String> map = BFS(start);
    int count = 0;
    while (end != null) {
      System.out.println(end);
      end = map.get(end);
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(getMinPath("A", "F"));

  }
}
