package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.List;

/**
 *You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element. Notice that the index of the elements may change after the removal.
 *
 * For example, if nums = [6,1,7,4,1]:
 *
 * Choosing to remove index 1 results in nums = [6,7,4,1].
 * Choosing to remove index 2 results in nums = [6,1,4,1].
 * Choosing to remove index 4 results in nums = [6,1,7,4].
 * An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.
 *
 * Return the number of indices that you could choose such that after the removal, nums is fair.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,1,6,4]  2 0, 2 1, 8 1, 8 5
 * Output: 1
 * 8 - 2 = 6 + 0  == 5 - 0 + 0 leftEven = 2, leftOdd = 0
 * 6 - 0 + 0 == 5 - 1 + 2 leftEven 2, leftOdd = 1
 * 6 - 6 = 0 + 1 == 4 - 0 + 2  leftEven = 8, leftOdd = 1
 * 0 - 0 = 0 + 1 == 2
 * Explanation:
 * Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair. 8 - 2  == 5 - 0
 * Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair. 8 - 2 == 5 - 1 | 6 + 0 == 4 + 2
 * Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
 * Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
 * There is 1 index that you can remove to make nums fair.
 * Example 2:
 *
 * Input: nums = [1,1,1] 1 0, 1 1, 2 1
 *  2 - 1 == 1 - 0, 2 - 1 == 1 - 1 | 1 + 0 == 0 + 1, 2 - 2 == 1 - 1 | 0 + 1 == 0 + 1
 * Output: 3
 * Explanation: You can remove any index and the remaining array is fair.
 * Example 3:
 *
 * Input: nums = [1,2,3] 1 0, 1 2, 4 2
 * 4 - 1 == 2 - 0, 4 - 1 == 2 - 2 | 3 + 0 == 0 + 1, 4 - 4 == 2 - 2 | 2 1
 * Output: 0
 * Explanation: You cannot make a fair array after removing any index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class S_1664WaysToMakeAFairArray {


    public int waysToMakeFair(int[] nums) {
        int rightEvenSum = 0, rightOddSum = 0, leftEvenSum = 0, leftOddSum = 0, total = 0;
        for (int i = 0; i < nums.length; i += 2) {
            rightEvenSum += nums[i];
            if (i + 1 < nums.length) {
                rightOddSum += nums[i + 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 ==  0) {
                rightEvenSum -= nums[i];
            } else {
                rightOddSum -= nums[i];
            }
            System.out.println(leftEvenSum + rightOddSum + " = " + (leftOddSum + rightEvenSum));
            if (leftEvenSum + rightOddSum == leftOddSum + rightEvenSum) {
                total++;
            }
            if (i % 2 == 0) {
                leftEvenSum += nums[i];
            } else {
                leftOddSum += nums[i];
            }

        }
        return total;
    }

    public int waysToMakeFairByObject(int[] nums) {
        List<Pair> list = new ArrayList<>(nums.length + 1);
        int total = 0;
        int even = 0;
        int odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even += nums[i];
            } else {
                odd += nums[i];
            }
            list.add(new Pair(even, odd));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                int tempEven = even - list.get(0).even;
                int tempOdd = odd - list.get(0).odd;
                System.out.println(tempEven + " = " + tempOdd);
                if (tempEven == tempOdd) {
                    total++;
                }
            } else {
                int tempEven = even - list.get(i).even;
                int tempOdd = odd - list.get(i).odd;
                System.out.println(tempEven + list.get(i - 1).odd + " = " + (tempOdd + list.get(i - 1).even));
                if (tempEven + list.get(i - 1).odd == tempOdd + list.get(i - 1).even) {
                    total++;
                }
            }
        }
        return total;
    }

    static class Pair {
        int even;int odd;

        public Pair(int even, int odd) {
            this.even = even;
            this.odd = odd;
        }

    }

    /**
     * Status: Time Limit Exceeded
     */
    public int waysToMakeFairWithForce(int[] nums) {
        int total = 0;
        int even = 0;
        int odd = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int innerEven = 0;
            int innerOdd = 0;
            boolean innerFlag = flag;
            for (int j = i + 1; j < nums.length; j++) {
                if (!(innerFlag = !innerFlag)) {
                    innerOdd += nums[j];
                } else {
                    innerEven += nums[j];
                }
            }
            System.out.println((innerEven + even) + " = " + (innerOdd + odd));
            if (innerEven + even == innerOdd + odd) {
                total++;
            }
            if (!(flag = !flag)) {
                odd += nums[i];
            } else {
                even += nums[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        S_1664WaysToMakeAFairArray waysToMakeAFairArray = new S_1664WaysToMakeAFairArray();
        System.out.println(waysToMakeAFairArray.waysToMakeFair(new int[]{2,1,6,4}));
        System.out.println(waysToMakeAFairArray.waysToMakeFair(new int[]{1,1,1}));
        System.out.println(waysToMakeAFairArray.waysToMakeFair(new int[]{1,2,3}));
    }
}
