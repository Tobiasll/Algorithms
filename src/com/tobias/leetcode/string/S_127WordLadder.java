package com.tobias.leetcode.string;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
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
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class S_127WordLadder {

  private int depth = 2;

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return 0;
    }
    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    Set<String> visited = new HashSet<>();
    beginSet.add(beginWord);
    endSet.add(endWord);

    int depth = 1;
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      if (beginSet.size() > endSet.size()) {
        Set<String> temp = beginSet;
        beginSet = endSet;
        endSet = temp;
      }
      Set<String> extendSet = new HashSet<>();
      for (String word : beginSet) {
        for (int i = 0; i < word.length(); i++) {
          char[] chars = word.toCharArray();
          for (char ch = 'a'; ch <= 'z'; ch++) {
            chars[i] = ch;
            String newWord = new String(chars);
            if (endSet.contains(newWord)) {
              return depth + 1;
            }
            if (!visited.contains(newWord) && wordList.contains(newWord)) {
              extendSet.add(newWord);
              visited.add(newWord);
            }
          }
        }
      }
      depth++;
      beginSet = extendSet;
    }

    return 0;
  }
  public int ladderLengthByDoubleWeySearch(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return 0;
    }
    Set<String> beginSet = new HashSet<>();
    beginSet.add(beginWord);
    Set<String> dict = new HashSet<>(wordList);
    Set<String> endSet = new HashSet<>();
    endSet.add(endWord);
    return doubleWeySearchBFS(beginSet, endSet, dict) ? depth : 0;
  }

  private boolean doubleWeySearchBFS(Set<String> beginSet, Set<String> endSet, Set<String> dict) {

    if (beginSet.isEmpty()) {
      return false;
    }
    if (beginSet.size() > endSet.size()) {
      return doubleWeySearchBFS(endSet, beginSet, dict);
    }
    dict.removeAll(beginSet);
    dict.removeAll(endSet);

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

          if (endSet.contains(word)) {
            return true;
          }
          if (dict.contains(word)) {
            extendSet.add(word);
          }
        }
      }
    }
    if (extendSet.size() > 0) {
      depth++;
    }
    return doubleWeySearchBFS(endSet, extendSet, dict);
  }

  public int ladderLengthByBFS(String beginWord, String endWord, List<String> wordList) {
    int depth = 0;
    boolean isFound = false;
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    Set<String> dict = new HashSet<>(wordList);

    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      Set<String> subVisited = new HashSet<>();
      depth++;
      for (int i = 0; i < queueSize; i++) {
        String pollStr = queue.poll();
        List<String> neighbors = S_126WordLadderII.getNeighbor(pollStr, dict);
        for (String neighbor : neighbors) {
          if (!visited.contains(neighbor)) {

            if (neighbor.equals(endWord)) {
              isFound = true;
            }
            queue.offer(neighbor);
            subVisited.add(neighbor);
          }
        }
      }
      visited.addAll(subVisited);
      if (isFound) {
        break;
      }
    }

    return isFound ? depth + 1 : 0;
  }

  public static void main(String[] args) {
    S_127WordLadder wordLadder = new S_127WordLadder();
    System.out.println(wordLadder.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));





  }
}
