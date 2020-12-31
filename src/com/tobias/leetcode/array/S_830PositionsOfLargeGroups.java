package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a string s of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".
 *
 * A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group.
 * In the above example, "xxxx" has the interval [3,6].
 *
 * A group is considered large if it has 3 or more characters.
 *
 * Return the intervals of every large group sorted in increasing order by start index.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the only large group with start index 3 and end index 6.
 * Example 2:
 *
 * Input: s = "abc"
 * Output: []
 * Explanation: We have groups "a", "b", and "c", none of which are large groups.
 * Example 3:
 *
 * Input: s = "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * Explanation: The large groups are "ddd", "eeee", and "bbb".
 * Example 4:
 *
 * Input: s = "aba"
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s contains lower-case English letters only.
 */
public class S_830PositionsOfLargeGroups {


    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Positions of Large Groups.
     * Memory Usage: 39 MB, less than 77.35% of Java online submissions for Positions of Large Groups.
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int begin = 0;
        while (begin < s.length()) {
            int i = begin + 1, count = 1;
            char currentChar = s.charAt(begin);
            while (i < s.length() && s.charAt(i) == currentChar) {
                i++;
                count++;
            }
            if (count >= 3) {
                result.add(Arrays.asList(begin , i - 1));
            }
            begin = i;
        }
        return result;
    }

    public static void main(String[] args) {
        S_830PositionsOfLargeGroups positionsOfLargeGroups = new S_830PositionsOfLargeGroups();
        System.out.println(positionsOfLargeGroups.largeGroupPositions("abbxxxxzzy"));
        System.out.println(positionsOfLargeGroups.largeGroupPositions("abc"));
        System.out.println(positionsOfLargeGroups.largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(positionsOfLargeGroups.largeGroupPositions("aba"));
    }
}
