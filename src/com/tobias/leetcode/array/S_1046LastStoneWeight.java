package com.tobias.leetcode.array;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.
 * Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class S_1046LastStoneWeight {


    /**
     * Runtime: 1 ms, faster than 83.04% of Java online submissions for Last Stone Weight.
     * Memory Usage: 36.3 MB, less than 80.12% of Java online submissions for Last Stone Weight.
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, (o1, o2) -> o2 - o1);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            Integer remove1 = pq.remove();
            Integer remove2 = pq.remove();
            if (!remove1.equals(remove2)) {
                pq.offer(remove1 - remove2);
            }
        }

        return pq.size() == 1 ? pq.remove() : 0;
    }

    public static void main(String[] args) {
        S_1046LastStoneWeight lastStoneWeight = new S_1046LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
