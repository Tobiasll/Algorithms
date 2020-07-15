package com.tobias.leetcode.array;


import java.util.HashSet;
import java.util.Set;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 *
 *
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 *
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 *
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class S_84LargestRectangleInHistogram {


    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Set<Integer> heightSet = new HashSet<>(heights.length);

        for (int height : heights) {
            heightSet.add(height);
        }
        int result = 0;
        for (Integer hSet : heightSet) {

            int width = 0;
            int maxWidth = 1;
            for (int height : heights) {
                if (height >= hSet) {
                    width++;
                } else {
                    maxWidth = Math.max(maxWidth, width);
                    width = 0;
                }
            }
            maxWidth = Math.max(maxWidth, width);
            result = Math.max(result, maxWidth * hSet);

        }

        return result;
    }

    public static void main(String[] args) {
        S_84LargestRectangleInHistogram largestRectangleInHistogram = new S_84LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
