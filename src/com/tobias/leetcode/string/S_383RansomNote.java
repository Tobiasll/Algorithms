package com.tobias.leetcode.string;


/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class S_383RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote == null || magazine == null) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (count[ransomNote.charAt(i) - 'a'] > 0) {
                count[ransomNote.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        S_383RansomNote ransomNote = new S_383RansomNote();
        System.out.println(ransomNote.canConstruct(null, ""));
        System.out.println(ransomNote.canConstruct("", ""));
        System.out.println(ransomNote.canConstruct("a", "b"));
        System.out.println(ransomNote.canConstruct("aa", "ab"));
        System.out.println(ransomNote.canConstruct("aa", "aab"));
    }
}
