package com.tobias.leetcode.string;


import com.tobias.rudiment.map.Map;

import java.util.ArrayList;
import java.util.List;

/**
 * For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence. The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence. If word is not a substring of sequence, word's maximum k-repeating value is 0.
 *
 * Given strings sequence and word, return the maximum k-repeating value of word in sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: sequence = "ababc", word = "ab"
 * Output: 2
 * Explanation: "abab" is a substring in "ababc".
 * Example 2:
 *
 * Input: sequence = "ababc", word = "ba"
 * Output: 1
 * Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".
 * Example 3:
 *
 * Input: sequence = "ababc", word = "ac"
 * Output: 0
 * Explanation: "ac" is not a substring in "ababc".
 *
 *
 * Constraints:
 *
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence and word contains only lowercase English letters.
 */
public class S_1668MaximumRepeatingSubstring {

    public int maxRepeating(String sequence, String word) {
        int total = 0;
        int tempTotal = 0;

        while (sequence.length() > 0) {
            int indexOf = sequence.indexOf(word);
            if (indexOf == -1) {
                break;
            } else {
                if (tempTotal == 0) {
                    tempTotal++;
                } else if (indexOf != 0) {
                    tempTotal = 1;
                } else {
                    tempTotal++;
                }
                total = Math.max(total, tempTotal);
                sequence = sequence.substring(indexOf + word.length());
            }
        }

        return total;
    }

    public static void main(String[] args) {
        S_1668MaximumRepeatingSubstring maximumRepeatingSubstring = new S_1668MaximumRepeatingSubstring();
        System.out.println(maximumRepeatingSubstring.maxRepeating("acaab","a"));
        System.out.println(maximumRepeatingSubstring.maxRepeating("bacaaaacabcaccccaacbcccccbcaaaacaabbaabbcababacca","ac"));
        System.out.println(maximumRepeatingSubstring.maxRepeating("bbaa", "ba"));
        System.out.println(maximumRepeatingSubstring.maxRepeating("baba", "b"));
        System.out.println(maximumRepeatingSubstring.maxRepeating("aaa", "a"));
        System.out.println(maximumRepeatingSubstring.maxRepeating("ababc", "ab"));
        System.out.println(maximumRepeatingSubstring.maxRepeating("ababc", "ba"));
        System.out.println(maximumRepeatingSubstring.maxRepeating("ababc", "ac"));
    }
}
