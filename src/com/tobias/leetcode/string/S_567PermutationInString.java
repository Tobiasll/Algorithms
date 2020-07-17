package com.tobias.leetcode.string;


/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 * Constraints:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class S_567PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
       int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        int low = 0, height = 0, match = s1.length();

        while (height < s2.length()) {
            if (count[s2.charAt(height++) - 'a']-- > 0) {
                match--;
            }
            if (match == 0) {
                return true;
            }
            if (height - low == s1.length()) {
                if (count[s2.charAt(low++) - 'a']++ >= 0) {
                    match++;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        S_567PermutationInString permutationInString = new S_567PermutationInString();
        System.out.println(permutationInString.checkInclusion("ab", "eidbaooo"));
        System.out.println(permutationInString.checkInclusion("ab", "eidboaoo"));
        System.out.println(permutationInString.checkInclusion("ab", "ab"));
        System.out.println(permutationInString.checkInclusion("abc","bbbca"));
    }
}
