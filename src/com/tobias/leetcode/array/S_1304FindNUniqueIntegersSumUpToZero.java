package com.tobias.leetcode.array;


import java.util.Arrays;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 *
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 */
public class S_1304FindNUniqueIntegersSumUpToZero {

    public int[] sumZero(int n) {
        int[] result = new int[n];
        for (int i = 1; i <= n / 2; i++) {
                result[i - 1] = i;
                result[n - i] = -i;
        }
        return result;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.
     * Memory Usage: 36.9 MB, less than 99.16% of Java online submissions for Find N Unique Integers Sum up to Zero.
     */
    public int[] sumZero2(int n) {
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result[i] = i + 1;
            } else {
                result[i] = -i;
            }
        }
        if (n % 2 != 0) {
            result[n - 1] = 0;
        }
        return result;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.
     * Memory Usage: 37.7 MB, less than 20.94% of Java online submissions for Find N Unique Integers Sum up to Zero.
     */
    public int[] sumZero1(int n) {
        int[] result = new int[n];
        int count = 0;
        if (n % 2 != 0) {
            result[0] = 0;
            count++;
        }
        boolean positive = false;
        int num = 1;
        while (count < n) {
            if (positive = !positive) {
                result[count++] = num;
            } else {
                result[count++] = -num++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        S_1304FindNUniqueIntegersSumUpToZero findNUniqueIntegersSumUpToZero = new S_1304FindNUniqueIntegersSumUpToZero();
        System.out.println(Arrays.toString(findNUniqueIntegersSumUpToZero.sumZero(4)));
    }
}
