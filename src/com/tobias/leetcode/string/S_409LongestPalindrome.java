package com.tobias.leetcode.string;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class S_409LongestPalindrome {

    public int longestPalindrome(String s) {
        int result = 0;
        int[] count = new int[128];
        boolean hasSingleNumber = false;
        for (int i = 0; i < s.length(); i++) {
            if (++count[s.charAt(i)] == 2) {
                result += 2;
                count[s.charAt(i)] = 0;
            } else {
                hasSingleNumber = true;
            }

        }
        return  hasSingleNumber ? result + 1 : result;
    }

    public int longestPalindromeByMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int result = 0;
        boolean hasSingleNumber = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                if (entry.getValue() % 2 != 0) {
                    result += entry.getValue() - 1;
                    hasSingleNumber = true;
                } else {
                    result += entry.getValue();
                }
            } else {
                hasSingleNumber = true;
            }
        }

        return  hasSingleNumber ? result + 1 : result;
    }

    public static void main(String[] args) {
        S_409LongestPalindrome longestPalindrome = new S_409LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome.longestPalindrome("bananas"));
    }
}
