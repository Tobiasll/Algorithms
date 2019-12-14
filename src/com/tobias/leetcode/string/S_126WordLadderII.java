package com.tobias.leetcode.string;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class S_126WordLadderII {

  private int depth;

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    if (!wordList.contains(endWord)) {
      return result;
    }
    Map<String, List<String>> memo = new HashMap<>();
    doubleSearchBFS(beginWord, endWord, wordList, memo);
    List<String> tempList = new ArrayList<>();
    tempList.add(beginWord);
    findLadders(beginWord, endWord, tempList, result, memo);
    return result;
  }

  private void findLadders(String beginWord, String endWord, List<String> tempList,
      List<List<String>> result, Map<String, List<String>> memo) {

    List<String> neighborWords = memo.getOrDefault(beginWord, new ArrayList<>());
    for (String neighborWord : neighborWords) {
      tempList.add(neighborWord);
      findLadders(neighborWord, endWord, tempList, result, memo);
      tempList.remove(tempList.size() - 1);
    }
  }

  private void doubleSearchBFS(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> memo) {
    Set<String> beginSet = new HashSet<>();
    beginSet.add(beginWord);
    Set<String> endSet = new HashSet<>();
    endSet.add(endWord);
    Set<String> dict  = new HashSet<>(wordList);
    doubleSearchBFS(beginSet, endSet, dict, true, memo);

  }

  private boolean doubleSearchBFS(Set<String> beginSet, Set<String> endSet, Set<String> dict, boolean direction, Map<String, List<String>> memo) {
    depth++;
    if (beginSet.isEmpty()) {
      return false;
    }
    if (beginSet.size() > endSet.size()) {
      return doubleSearchBFS(endSet, beginSet, dict, !direction, memo);
    }
    dict.removeAll(beginSet);
    dict.removeAll(endSet);

    boolean isDone = false;

    Set<String> extendSet = new HashSet<>();
    for (String beginWord : beginSet) {
      for (int i = 0; i < beginWord.length(); i++) {
        char[] chars = beginWord.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
          if (ch == chars[i]) {
            continue;
          }
          chars[i] = ch;
          String word = new String(chars);

          String key = direction ? beginWord : word;
          String value = direction ? word : beginWord;

          List<String> list = memo.containsKey(key) ? memo.get(key) : new ArrayList<>();

          if (endSet.contains(word)) {
            isDone = true;
            list.add(value);
            memo.put(key, list);
          }

          if (!isDone && dict.contains(word)) {
            extendSet.add(word);
            list.add(value);
            memo.put(key, list);
          }
        }
      }

    }
    return isDone || doubleSearchBFS(endSet, extendSet, dict, !direction, memo);
  }


  public List<List<String>> findLaddersByBFS(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    if (!wordList.contains(endWord)) {
      return result;
    }

    bfs(beginWord, endWord, wordList, result);
    return result;
  }

  private void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> result) {
    List<String> insideList = new ArrayList<>();
    insideList.add(beginWord);
    Queue<List<String>> queue = new LinkedList<>();
    queue.offer(insideList);
    Set<String> dict = new HashSet<>(wordList);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    boolean isFound = false;

    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      Set<String> subVisited = new HashSet<>();
      for (int i = 0; i < queueSize; i++) {
        List<String> pollList = queue.poll();
        String lastStr = pollList.get(pollList.size() - 1);
        List<String> neighbors = getNeighbor(lastStr, dict);
        for (String neighbor : neighbors) {
          if (!visited.contains(neighbor)) {
            if (neighbor.equals(endWord)) {
              isFound = true;
              pollList.add(neighbor);
              result.add(new ArrayList<>(pollList));
              pollList.remove(pollList.size() - 1);
            }
            pollList.add(neighbor);
            queue.offer(new ArrayList<>(pollList));
            pollList.remove(pollList.size() - 1);
            subVisited.add(neighbor);
          }
        }
      }
      visited.addAll(subVisited);
      if (isFound) {
        break;
      }
    }
  }


  public List<List<String>> findLaddersByDFS(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    if (!wordList.contains(endWord)) {
      return result;
    }
    Map<String, List<String>> map = new HashMap<>();
    bfs(beginWord, endWord, map, wordList);
    List<String> tempList = new ArrayList<>();
    tempList.add(beginWord);
    findLadders(beginWord, endWord, tempList, map, result);
    return result;
  }

  private void findLadders(String beginWord, String endWord,
      List<String> tempList, Map<String, List<String>> map, List<List<String>> result) {
    if (beginWord.equals(endWord)) {
      result.add(new ArrayList<>(tempList));
      return;
    }

    List<String> neighborWords = map.getOrDefault(beginWord, new ArrayList<>());
    for (String neighborWord : neighborWords) {
      tempList.add(neighborWord);
      findLadders(neighborWord, endWord, tempList, map, result);
      tempList.remove(tempList.size() - 1);
    }
  }

  private void bfs(String beginWord, String endWord, Map<String, List<String>> map, List<String> wordList) {
    boolean isFound = false;
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    Set<String> dict = new HashSet<>(wordList);
    int deepth = 0;
    while (!queue.isEmpty()) {
      int queueSizer = queue.size();
      deepth++;
      Set<String> subVisited = new HashSet<>();
      for (int i = 0; i < queueSizer; i++) {

        String pollStr = queue.poll();
        List<String> neighborList = getNeighbor(pollStr, dict);
        Iterator<String> iterator = neighborList.iterator();

        while (iterator.hasNext()) {
          String next = iterator.next();
          if (!visited.contains(next)) {
            if (next.equals(endWord)) {
              isFound = true;
            }
            queue.offer(next);
            subVisited.add(next);
          } else {
            iterator.remove();
          }
        }
        map.put(pollStr, neighborList);

      }
      visited.addAll(subVisited);
      if (isFound) {
        break;
      }
    }
  }

  static List<String> getNeighbor(String pollStr, Set<String> dict) {
    List<String> result = new ArrayList<>();
    char[] chars = pollStr.toCharArray();
    for (char ch = 'a'; ch <= 'z'; ch++) {
      for (int i = 0; i < chars.length; i++) {
        if (ch == chars[i]) {
          continue;
        }
        char oldChar = chars[i];
        chars[i] = ch;
        if (dict.contains(new String(chars))) {
          result.add(String.valueOf(chars));
        }
        chars[i] = oldChar;
      }
    }
    return result;
  }


  public static void main(String[] args) {
    S_126WordLadderII wordLadderII = new S_126WordLadderII();

    List<List<String>> ladders = wordLadderII.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
    for (List<String> ladder : ladders) {
      System.out.println(ladder);
    }
    System.out.println(wordLadderII.depth + 1);


  }
}
