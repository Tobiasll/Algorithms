package com.tobias.leetcode.array;


/**
 *Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class S_209MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int begin = 0;
        int end = n;
        int mid;

        while (begin <= end) {
            mid = (begin + end) >>> 1;
            int maxSum = getMaxSum(mid, nums);
            if (maxSum >= s) {
                end = mid - 1;
                min = mid;
            } else {
                begin = mid + 1;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private int getMaxSum(int mid, int[] nums) {
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < mid; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for (int i = mid; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - mid];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }


    public int minSubArrayLen1(int s, int[] nums) {

        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int[] sums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            int toFindNum = s + sums[i - 1];
            int bound = lowerBound(sums, 0, n, toFindNum);
            if (bound != n) {
                min = Math.min(min, bound - i - 1);
                break;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * template<class ForwardIt, class T> ForwardIt lower_bound(ForwardIt first, ForwardIt last, const T& value)
     * {
     *     ForwardIt it;
     *     typename std::iterator_traits<ForwardIt>::difference_type count, step;
     *     count = std::distance(first, last);
     *
     *     while (count > 0) {
     *         it = first;
     *         step = count / 2;
     *         std::advance(it, step);
     *         if (*it < value) {
     *             first = ++it;
     *             count -= step + 1;
     *         }
     *         else
     *             count = step;
     *     }
     *     return first;
     * }

     */

    private int lowerBound(int[] arr, int begin, int end, int value) {
        int it, count, step;
        count = end - begin;

        while (count > 0) {
            it = begin;
            step = count / 2;
            it += step;
            if (arr[it] < value) {
                begin = ++it;
                count -= step + 1;
            } else {
                count = step;
            }
        }
        return begin;
    }

    public int minSubArrayLenWithTwoPoint(int s, int[] nums) {

        int n = nums.length;
        int left = 0;
        int right;
        int min = Integer.MAX_VALUE;

        while (left < n) {
            int sum = 0;
            right = left;
            while (right < n) {
                sum += nums[right];
                right++;
                if (sum >= s) {
                    min = Math.min(min, right - left);
                    break;
                }
            }
            left++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLenWithViolence(int s, int[] nums) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            int sum = 0;
            int start = i;

            while (start < nums.length) {
                sum += nums[start];
                start++;
                if (sum >= s) {
                    min = Math.min(min, start - i);
                    break;
                }

            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public static void main(String[] args) {
        S_209MinimumSizeSubarraySum s_209MinimumSizeSubarraySum = new S_209MinimumSizeSubarraySum();
        System.out.println(s_209MinimumSizeSubarraySum.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
