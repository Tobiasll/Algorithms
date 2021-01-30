package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array consists of non-negative integers,
 * your task is to count the number of triplets chosen from the array
 * that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 * <p>
 * the rule is the sum of any two sides should always be greater than the third side alone.
 * i.e. a + b > c a + b>c, b + c > a  b+c>a, a + c > b a+c>b.
 *
 * TODO try to understand use binary search and line search to solve this problem
 */
public class S_611ValidTriangleNumber {




    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int l = 0; l < nums.length - 2; l++) {
            int k = l + 2;
            for (int r = k + 1; r < nums.length; r++) {
                k = binarySearch(nums, k, r, nums[k] + nums[r]);
                count += k - r + 1;
            }
        }
        return count;
    }

    private int binarySearch(int[] nums, int l, int r, int x) {
        System.out.println(x);
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int triangleNumber1(int[] nums) {
        int count = 0;
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                for (int c = b + 1; c < nums.length; c++) {
                    if (nums[a] + nums[b] > nums[c] && nums[b] + nums[c] > nums[a] && nums[a] + nums[c] > nums[b]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static class Solution {
        int binarySearch(int nums[], int l, int r, int x) {
            while (r >= l && r < nums.length) {
                int mid = (l + r) / 2;
                if (nums[mid] >= x) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
        public int triangleNumber(int[] nums) {
            int count = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int k = i + 2;
                for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                    k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                    // ? incomprehension this formula
                    count += k - j - 1;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
//        S_611ValidTriangleNumber validTriangleNumber = new S_611ValidTriangleNumber();
//        System.out.println(validTriangleNumber.triangleNumber(new int[]{2, 2, 3, 4}));
//        System.out.println(validTriangleNumber.triangleNumber(new int[]{1, 3, 5, 8, 9, 10, 11, 11, 13, 20}));
        Solution solution = new Solution();
        System.out.println(solution.triangleNumber(new int[]{2, 2, 3, 4}));
//        System.out.println(solution.triangleNumber(new int[]{1, 3, 5, 8, 9, 10, 11, 11, 13, 20}));
    }

}
