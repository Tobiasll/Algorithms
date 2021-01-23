package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 *
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.
 * Example 4:
 *
 * Input: k = 3, n = 2
 * Output: []
 * Explanation: There are no valid combinations.
 * Example 5:
 *
 * Input: k = 9, n = 45
 * Output: [[1,2,3,4,5,6,7,8,9]]
 * Explanation:
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
 * There are no other valid combinations.
 *
 *
 * Constraints:
 *
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
public class S_216CombinationSumIII {

    /**
     * Runtime: 1 ms, faster than 24.65% of Java online submissions for Combination Sum III.
     * Memory Usage: 36.7 MB, less than 42.89% of Java online submissions for Combination Sum III.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Combination Sum III.
     * Memory Usage: 36.3 MB, less than 89.99% of Java online submissions for Combination Sum III.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, 0, k, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int end, int sum, int k, List<List<Integer>> result, List<Integer> tempList) {
        if (sum == end) {
            if (tempList.size() == k) {
                result.add(new ArrayList<>(tempList));
            }

        }

//        for (int i = start; i <= end; i++) {
        // Only numbers 1 through 9 are used. 不能等于end，题目指明只有1到9会出现，等于end会超时
        for (int i = start; i <= 9; i++) {
            tempList.add(i);
            if (sum < end) {
                backtrack(i + 1, end, sum + i, k, result, tempList);
            }
            tempList.remove(new Integer(i));
        }
    }

    public static void main(String[] args) {
        S_216CombinationSumIII combinationSumIII = new S_216CombinationSumIII();
//        List<List<Integer>> lists = combinationSumIII.combinationSum3(2, 3);
        List<List<Integer>> lists = combinationSumIII.combinationSum3(9, 45);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
