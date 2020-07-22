package com.tobias.leetcode.string;


/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 *
 *
 * Note: You may assume the string contains only lowercase English letters.
 */
public class S_387FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        S_387FirstUniqueCharacterInString firstUniqueCharacterInString = new S_387FirstUniqueCharacterInString();
        System.out.println(firstUniqueCharacterInString.firstUniqChar("leetcode"));
        System.out.println(firstUniqueCharacterInString.firstUniqChar("loveleetcode"));
        System.out.println(firstUniqueCharacterInString.firstUniqChar("oaaaoqqqsssddd"));
    }
}
