package com.tobias.leetcode.array;


import java.util.HashSet;
import java.util.Set;

/**
 * You are given a string s of even length. Split this string into two halves of equal lengths,
 * and let a be the first half and b be the second half.
 *
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
 * Notice that s contains uppercase and lowercase letters.
 *
 * Return true if a and b are alike. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "book"
 * Output: true
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
 * Example 2:
 *
 * Input: s = "textbook"
 * Output: false
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
 * Notice that the vowel o is counted twice.
 * Example 3:
 *
 * Input: s = "MerryChristmas"
 * Output: false
 * Example 4:
 *
 * Input: s = "AbCdEfGh"
 * Output: true
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 1000
 * s.length is even.
 * s consists of uppercase and lowercase letters.
 */
public class S_1704DetermineIfStringHalvesAreAlike {


    /**
     * Runtime: 3 ms, faster than 81.24% of Java online submissions for Determine if String Halves Are Alike.
     * Memory Usage: 37.4 MB, less than 84.70% of Java online submissions for Determine if String Halves Are Alike.
     *
     * todo: use (case:) statement to improve the method
     */
    public boolean halvesAreAlikeUseSet(String s) {
        int half = s.length() / 2;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int count1 = 0, count2 = 0;
        for (int i = 0; i < half; i++) {
            if (set.contains(s.charAt(i))) {
                count1++;
            }
            if (set.contains(s.charAt(i + half))) {
                count2++;
            }
        }
        return count1 == count2;
    }

    /**
     * Runtime: 1 ms, faster than 99.95% of Java online submissions for Determine if String Halves Are Alike.
     * Memory Usage: 37.5 MB, less than 77.73% of Java online submissions for Determine if String Halves Are Alike.
     */
    public boolean halvesAreAlike(String s) {
        int half = s.length() / 2;
        boolean[] flags = new boolean[53];
        flags['a' - 'A'] = true;
        flags['e' - 'A'] = true;
        flags['i' - 'A'] = true;
        flags['o' - 'A'] = true;
        flags['u' - 'A'] = true;
        flags[0] = true;
        flags['E' - 'A'] = true;
        flags['I' - 'A'] = true;
        flags['O' - 'A'] = true;
        flags['U' - 'A'] = true;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < half; i++) {
            int index1 = s.charAt(i) - 'A';
            if (index1 < flags.length && flags[index1]) {
                count1++;
            }
            int index2 = s.charAt(i + half) - 'A';
            if (index2 < flags.length && flags[index2]) {
                count2++;
            }
        }
        return count1 == count2;
    }

    public static void main(String[] args) {
        S_1704DetermineIfStringHalvesAreAlike determineIfStringHalvesAreAlike = new S_1704DetermineIfStringHalvesAreAlike();
        System.out.println(determineIfStringHalvesAreAlike.halvesAreAlike("book"));
        System.out.println(determineIfStringHalvesAreAlike.halvesAreAlike("textbook"));
        System.out.println(determineIfStringHalvesAreAlike.halvesAreAlike("MerryChristmas"));
        System.out.println(determineIfStringHalvesAreAlike.halvesAreAlike("AbCdEfGh"));
        System.out.println('i' - 'A');
        System.out.println('o' - 'A');
        System.out.println('u' - 'A');
    }
}
