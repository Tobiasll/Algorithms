package com.tobias.leetcode.array;


/**
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
 *
 * Example :
 * Input:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 * Note:
 *
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].
 */
public class S_792NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;
        for (String word : words) {
            int i = 0, j = 0;
            while (i < S.length() && j < word.length()) {
                if (S.charAt(i) == word.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == word.length()) {
                System.out.println(word);
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S_792NumberOfMatchingSubsequences numberOfMatchingSubsequences = new S_792NumberOfMatchingSubsequences();
        System.out.println(numberOfMatchingSubsequences.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
}
