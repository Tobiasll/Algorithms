package com.tobias.leetcode.array;


import java.util.Arrays;

/**
 *You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 *
 *
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 *  0,1,0,0,0,1
 *  0,0,0,1,0,1
 *  0,1,0,0,0,1
 * Constraints:
 *
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */
public class S_605CanPlaceFlowers {


    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Can Place Flowers.
     * Memory Usage: 40.8 MB, less than 32.23% of Java online submissions for Can Place Flowers.
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int zeroCount = 1;
        for (int fast = 0; fast <= flowerbed.length; fast++) {
            if (fast < flowerbed.length && flowerbed[fast] != 0) {
                zeroCount = 0;
                continue;
            }
            if (zeroCount == 2 ) {
                if (--n == 0) {
                    return true;
                }
                zeroCount = 1;
            } else {
                zeroCount++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        S_605CanPlaceFlowers canPlaceFlowers = new S_605CanPlaceFlowers();
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,0,1,0,0}, 2));
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2));
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0,0,0,1,0,1}, 1));
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,0,0,0,1}, 2));
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0,0,1,0,1}, 1));
    }

}
