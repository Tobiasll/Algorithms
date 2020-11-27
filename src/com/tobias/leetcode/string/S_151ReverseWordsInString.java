package com.tobias.leetcode.string;


/**
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
public class S_151ReverseWordsInString {


    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverseEachWord(chars);
        return clearSpace(chars);
    }

    public String clearSpace(char[] chars) {
        int i = 0, j = 0;
        while (i < chars.length) {
            while (j < chars.length && chars[j] == ' ') {
                j++;
            }
            if (j == chars.length) {
                break;
            }
            while (j < chars.length && chars[j] != ' ') {
                chars[i++] = chars[j++];
            }
            if (i < chars.length) {
                chars[i++] = ' ';
            }
        }
        return new String(chars, 0, i).trim();
    }


    private void reverseEachWord(char[] chars) {
        int i = 0, j = 0;
        while (i < chars.length) {
            while (i < chars.length && chars[i] == ' ') {
                i++;
                j = i;
            }
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            reverse(chars,i, j - 1);
            i = j;
        }
    }

    public void reverse(char[] chars, int begin, int end) {
        while (begin < end) {
            char temp = chars[begin];
            chars[begin++] = chars[end];
            chars[end--] = temp;
        }
    }

    public String reverseWords1(String s) {
        StringBuilder result = new StringBuilder(" ");

        String[] split = s.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].equals("")) {
                result.append(split[i]).append(' ');
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        S_151ReverseWordsInString s_151ReverseWordsInString = new S_151ReverseWordsInString();
        System.out.println(s_151ReverseWordsInString.reverseWords("the sky is blue"));
    }

}
