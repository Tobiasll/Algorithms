package com.tobias.leetcode.array;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 *
 * Note:
 *
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 */
public class S_1047RemoveAllAdjacentDuplicatesInString {


    /**
     * Runtime: 3 ms, faster than 99.51% of Java online submissions for Remove All Adjacent Duplicates In String.
     * Memory Usage: 39.2 MB, less than 97.12% of Java online submissions for Remove All Adjacent Duplicates In String.
     */
    public String removeDuplicates(String S) {
            int slow = 0;
            char[] chars = S.toCharArray();
            for (int fast = 1; fast < S.length(); fast++){
                if (slow >= 0 && chars[fast] == chars[slow]){
                    slow--;
                } else {
                    chars[++slow] = chars[fast];
                }
            }
            return new String(chars, 0, slow + 1);
    }


    /**
     * Runtime: 19 ms, faster than 50.07% of Java online submissions for Remove All Adjacent Duplicates In String.
     * Memory Usage: 39.7 MB, less than 40.15% of Java online submissions for Remove All Adjacent Duplicates In String.
     */
    public String removeDuplicatesUseStack(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        S_1047RemoveAllAdjacentDuplicatesInString removeAllAdjacentDuplicatesInString = new S_1047RemoveAllAdjacentDuplicatesInString();
        System.out.println(removeAllAdjacentDuplicatesInString.removeDuplicates("azxxzy"));
        System.out.println(removeAllAdjacentDuplicatesInString.removeDuplicates("abbaca"));
    }
}
