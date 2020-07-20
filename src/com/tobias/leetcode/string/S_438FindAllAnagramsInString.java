package com.tobias.leetcode.string;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class S_438FindAllAnagramsInString {


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() == 0 || p.length() == 0 || p.length() > s.length()) {
            return result;
        }

        int[] pCounts = new int[26], sCounts = new int[26];
        int left = 0, right = 0;
        for (int i = 0; i < p.length(); i++) {
            pCounts[p.charAt(i) - 'a']++;
        }

        while (right < p.length()) {
            sCounts[s.charAt(right++) - 'a']++;
        }
        while (right < s.length()) {
            if (judge(pCounts, sCounts)) {
                result.add(left);
            }
            sCounts[s.charAt(left) - 'a']--;
            sCounts[s.charAt(right) - 'a']++;
            left++;
            right++;
        }
        if (judge(pCounts, sCounts)) {
            result.add(left);
        }
        return result;
    }

    private boolean judge(int[] pCounts, int[] sCounts) {
        for (int i = 0; i < pCounts.length; i++) {
            if (pCounts[i] != sCounts[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Runtime: 2603 ms, faster than 5.01% of Java online submissions for Find All Anagrams in a String.
     * Memory Usage: 52.5 MB, less than 5.04% of Java online submissions for Find All Anagrams in a String.
     */
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p == null || p.length() == 0) {
            return result;
        }

        if (p.length() == 1) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == p.charAt(0)) {
                    result.add(i);
                }
            }
            return result;
        }

        int[] counts = help(p);

        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] > 0) {
                counts[s.charAt(i) - 'a']--;
                int match = p.length() - 1;
                for (int j = i + 1; j < s.length(); j++) {
                    if (counts[s.charAt(j) - 'a'] > 0) {
                        match--;
                        counts[s.charAt(j) - 'a']--;
                    } else {
                        counts = help(p);
                        break;
                    }
                    if (match == 0) {
                        result.add(i);
                        counts = help(p);
                        break;
                    }
                }
            }
        }
        return result;
    }

    private int[] help(String p) {
        int[] counts = new int[26];

        for (int i = 0; i < p.length(); i++) {
            counts[p.charAt(i) - 'a']++;
        }
        return counts;
    }

    public static void main(String[] args) {
        S_438FindAllAnagramsInString findAllAnagramsInString = new S_438FindAllAnagramsInString();
        System.out.println(findAllAnagramsInString.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
        System.out.println(findAllAnagramsInString.findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAllAnagramsInString.findAnagrams("", "a"));
        System.out.println(findAllAnagramsInString.findAnagrams("abab", "ab"));
        System.out.println(findAllAnagramsInString.findAnagrams("acdcaeccde","c"));
    }
}
