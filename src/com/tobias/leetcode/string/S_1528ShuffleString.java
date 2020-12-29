package com.tobias.leetcode.string;


import com.tobias.rudiment.heap.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 *Given a string s and an integer array indices of the same length.
 *
 * The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Return the shuffled string.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * Output: "leetcode"
 * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 * Example 2:
 *
 * Input: s = "abc", indices = [0,1,2]
 * Output: "abc"
 * Explanation: After shuffling, each character remains in its position.
 * Example 3:
 *
 * Input: s = "aiohn", indices = [3,1,4,2,0]
 * Output: "nihao"
 * Example 4:
 *
 * Input: s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
 * Output: "arigatou"
 * Example 5:
 *
 * Input: s = "art", indices = [1,0,2]
 * Output: "rat"
 */
public class S_1528ShuffleString {


    /**
     *
     */
    public String restoreString(String s, int[] indices) {
        char[] chars = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }

    /**
     * error
     */
    public String restoreStringUseSort(String s, int[] indices) {
        char[] chars = s.toCharArray();
        quickSort(indices, 0, indices.length - 1, chars);
        return new String(chars);
    }

    public void quickSort(int[] arr, int begin, int end, char[] chars) {
        if (begin >= end) {
            return;
        }
        int j = partition(arr, begin, end, chars);
        quickSort(arr, begin, j - 1, chars);
        quickSort(arr, j + 1, end, chars);

    }

    private int partition(int[] arr, int begin, int end, char[] chars) {
        int i = begin, j = end + 1, firstValue = arr[begin];
        while (true) {
            while (arr[++i] < firstValue && i != end){}
            while (arr[--j] > firstValue && j != begin){}
            if (i >= j) {
                break;
            }
            swap(arr, chars, i, j);
        }
        swap(arr, chars, begin, j);
        return j;
    }

    private void swap(int[] arr, char[] chars, int i, int j) {
        char tempChar = chars[arr[i]];
        chars[arr[i]] = chars[arr[j]];
        chars[arr[j]] = tempChar;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * Runtime: 8 ms, faster than 6.61% of Java online submissions for Shuffle String.
     * Memory Usage: 39.4 MB, less than 26.70% of Java online submissions for Shuffle String.
     */
    public String restoreStringUseArr(String s, int[] indices) {
        StringBuilder result = new StringBuilder();
        int[][] arr = new int[indices.length][2];

        for (int i = 0; i < indices.length; i++) {
            arr[i][0] = indices[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        for (int[] i : arr) {
            result.append(s.charAt(i[1]));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        S_1528ShuffleString shuffleString = new S_1528ShuffleString();
        System.out.println(shuffleString.restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
        String s = "codeleet";
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            System.out.println( aChar & 1);
        }
    }
}
