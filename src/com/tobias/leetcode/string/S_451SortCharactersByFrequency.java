package com.tobias.leetcode.string;


import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class S_451SortCharactersByFrequency {


    /**
     * Runtime: 8 ms, faster than 91.29% of Java online submissions for Sort Characters By Frequency.
     * Memory Usage: 39.6 MB, less than 95.68% of Java online submissions for Sort Characters By Frequency.
     */
    public String frequencySort(String s) {
        int[][] counts = new int[128][2];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)][1]++;
            counts[s.charAt(i)][0] = s.charAt(i);
        }

        Arrays.sort(counts, Comparator.comparing((int[] a) -> -1 * a[1]));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < counts.length && counts[i][1] > 0; i++) {
            int length = counts[i][1];
            for (int j = 0; j < length; j++) {
                sb.append((char)counts[i][0]);
            }
        }

        return sb.toString();
    }

    /**
     * Runtime: 50  ms, faster than 30.29% of Java online submissions for Sort Characters By Frequency.
     * Memory Usage: 52.3 MB, less than 40.68% of Java online submissions for Sort Characters By Frequency.
     */
    public String frequencySortByPQ(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(map.size() + 2, (o1, o2) -> o2.getValue() - o1.getValue());

        priorityQueue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        int size = priorityQueue.size();
        for (int i = 0; i < size; i++) {
            Map.Entry<Character, Integer> entry = priorityQueue.poll();
            for (int j = 0; entry != null && j < entry.getValue(); j++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        S_451SortCharactersByFrequency sortCharactersByFrequency = new S_451SortCharactersByFrequency();
        System.out.println(sortCharactersByFrequency.frequencySort("raaeaedere"));
        System.out.println(sortCharactersByFrequency.frequencySort("tree"));
        System.out.println(sortCharactersByFrequency.frequencySort("cccaaa"));
        System.out.println(sortCharactersByFrequency.frequencySort("Aabb"));
        System.out.println((int) 'Z');
        System.out.println((int) 'z');
    }

}
