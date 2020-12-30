package com.tobias.leetcode.array;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 * <p>
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */
public class S_316RemoveDuplicateLetters {


    /**
     * Runtime: 5 ms, faster than 15.75% of Java online submissions for Smallest Subsequence of Distinct Characters.
     * Memory Usage: 37.4 MB, less than 37.69% of Java online submissions for Smallest Subsequence of Distinct Characters.
     */
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> lastPotMap = new HashMap<>();
        // 找到每个字符最后出现的一次的下标
        for (int i = 0; i < s.length(); i++) {
            lastPotMap.put(s.charAt(i), i);
        }
        // 初次获取第一个最小下标
        int begin = 0, end = getLastPotIndex(lastPotMap);
        char[] result = new char[lastPotMap.size()];
        // 循环
        for (int i = 0; i < s.length() && end >= 0; i++) {
            // 定义一个最大的小写字母
            char minChar = 'z' + 1;
            // 从初次获取的范围下标中找出最小字母
            for (int j = begin; j <= end; j++) {
                // 因为找出字母后会对其从map中移除，所以这里判断是否存在，不存在则跳过不做对比，说明之前以及比过了
                if (lastPotMap.containsKey(s.charAt(j)) && minChar > s.charAt(j)) {
                    // 设定为当前最小字符，并从小界定开始范围
                    minChar = s.charAt(j);
                    begin = j;
                }
            }
            // 结果赋值
            result[i] = minChar;
            // 判断是否达到结果长度
            if (i == result.length - 1) {
                break;
            }
            // 不断移除掉最小的字符，获取下一个的最小下标，并设置为下次遍历的结束范围
            lastPotMap.remove(minChar);
            end = getLastPotIndex(lastPotMap);

        }
        return new String(result);
    }

    private int getLastPotIndex(Map<Character, Integer> lastPotMap) {
        if (lastPotMap == null || lastPotMap.isEmpty()) {
            return -1;
        }
        int minCharIndex = Integer.MAX_VALUE;
        for (Integer value : lastPotMap.values()) {
            minCharIndex = Math.min(minCharIndex, value);
        }
        return minCharIndex;
    }

//    The basic idea is to find out the smallest result letter by letter (one letter at a time).
//    Here is the thinking process for input "cbacdcbc":
//    step one
//    find out the last appeared position for each letter;
//    c - 7
//    b - 6
//    a - 2
//    d - 4
//    step two
//    find out the smallest index from the map in step 1 (a - 2);
//    the first letter in the final result must be the smallest letter from index 0 to index 2;

//    repeat step 2 to 3 to find out remaining letters.
//    the smallest letter from index 0 to index 2: a
//    the smallest letter from index 3 to index 4: c
//    the smallest letter from index 4 to index 4: d
//    the smallest letter from index 5 to index 6: b
//    so the result is "acdb"
//
//    Notes:
//
//    after one letter is determined in step 3, it need to be removed from the "last appeared position map",
//    and the same letter should be ignored in the following steps
//    in step 3, the beginning index of the search range should be the index of previous determined letter plus one

    public static void main(String[] args) {
        S_316RemoveDuplicateLetters removeDuplicateLetters = new S_316RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("cbacdcbc"));
    }
}
