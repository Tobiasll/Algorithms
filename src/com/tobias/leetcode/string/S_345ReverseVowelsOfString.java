package com.tobias.leetcode.string;


import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 *
 *
 */
public class S_345ReverseVowelsOfString {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
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
        char[] chars = s.toCharArray();
        for (int begin = 0, end = chars.length - 1; begin < end; begin++, end--) {
            while (begin < chars.length && !set.contains(chars[begin])) {
                begin++;
            }
            while (end >= 0 && !set.contains(chars[end])) {
                end--;
            }
            if (begin < end) {
                char temp = chars[begin];
                chars[begin] = chars[end];
                chars[end] = temp;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        S_345ReverseVowelsOfString reverseVowelsOfString = new S_345ReverseVowelsOfString();
        System.out.println(reverseVowelsOfString.reverseVowels(".,"));
        System.out.println(reverseVowelsOfString.reverseVowels("hello"));
        System.out.println(reverseVowelsOfString.reverseVowels("leetcode"));
        System.out.println(reverseVowelsOfString.reverseVowels("aA"));
    }
}
