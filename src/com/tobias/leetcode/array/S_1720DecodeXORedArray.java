package com.tobias.leetcode.array;


import java.util.Arrays;

/**
 * There is a hidden integer array arr that consists of n non-negative integers.
 *
 * It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then encoded = [1,2,3].
 *
 * You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].
 *
 * Return the original array arr. It can be proved that the answer exists and is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: encoded = [1,2,3], first = 1
 * Output: [1,0,2,1]
 * Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * Example 2:
 *
 * Input: encoded = [6,2,7,3], first = 4
 * Output: [4,2,0,7,4]
 *
 *
 * Constraints:
 *
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 */
public class S_1720DecodeXORedArray {


    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = result[i] ^ encoded[i];
        }

        return result;
    }

    /**
     * You are here!
     * Your memory usage beats 79.99 % of java submissions.
     */
    public int[] decodeOn2(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            for (int j = 0; j < Integer.MAX_VALUE; j++) {
                if ((first ^ j) == encoded[i]) {
                    first = j;
                    break;
                }
            }
            result[i + 1] = first;
        }

        return result;
    }

    public static void main(String[] args) {
        S_1720DecodeXORedArray decodeXORedArray = new S_1720DecodeXORedArray();
        System.out.println(Arrays.toString(decodeXORedArray.decode(new int[]{1,2,3}, 1)));
        System.out.println(Arrays.toString(decodeXORedArray.decode(new int[]{6,2,7,3}, 4)));
    }
}
