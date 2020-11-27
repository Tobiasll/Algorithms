package com.tobias.leetcode.string;


/**
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 * Example 2:
 *
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 * Output: false
 * Example 3:
 *
 * Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * Output: true
 *
 * ["abc","d","defg"]
 * ["abcddef"]
 * false
 *
 * ["ab","c"]
 * ["a","bcd"]
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] and word2[i] consist of lowercase letters.
 */
public class S_1662CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null || word2 == null || word1.length == 0 || word2.length == 0) {
            return false;
        }
        int wi1 = 0, wj1 = 0, wi2 = 0, wj2 = 0, total1 = 0, total2 = 0;

        while (wi1 < word1.length && wi2 < word2.length) {
            String str1 = word1[wi1];
            String str2 = word2[wi2];
            if (str1.charAt(wj1) != str2.charAt(wj2)) {
                return false;
            }
            if (wj1 == str1.length() - 1) {
                wi1++;
                wj1 = 0;
                total1 += str1.length();
            } else {
                wj1 ++;
            }
            if (wj2 == str2.length() - 1) {
                wi2++;
                wj2 = 0;
                total2 += str2.length();
            } else {
                wj2 ++;
            }

        }
        return total1 == total2;
    }

    public static void main(String[] args) {
        S_1662CheckIfTwoStringArraysAreEquivalent checkIfTwoStringArraysAreEquivalent = new S_1662CheckIfTwoStringArraysAreEquivalent();
        System.out.println(checkIfTwoStringArraysAreEquivalent.arrayStringsAreEqual(new String[]{"ab","c"}, new String[]{"a","bcd"}));
        System.out.println(checkIfTwoStringArraysAreEquivalent.arrayStringsAreEqual(new String[]{"abc","d","defg"}, new String[]{"abcddef"}));
        System.out.println(checkIfTwoStringArraysAreEquivalent.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"ab", "c"}));
        System.out.println(checkIfTwoStringArraysAreEquivalent.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
        System.out.println(checkIfTwoStringArraysAreEquivalent.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }
}
