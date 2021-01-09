package com.tobias.leetcode.array;


import java.util.*;
import java.util.function.Supplier;

/**
 * Implement the RandomizedSet class:
 *
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * Follow up: Could you implement the functions of the class with each function works in average O(1) time?
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 *
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * At most 105 calls will be made to insert, remove, and getRandom.
 * There will be at least one element in the data structure when getRandom is called.
 */
public class S_380InsertDeleteGetRandomO1 {

    /**
     * use set :
     * Runtime: 341 ms, faster than 5.18% of Java online submissions for Insert Delete GetRandom O(1).
     * Memory Usage: 45.6 MB, less than 12.38% of Java online submissions for Insert Delete GetRandom O(1).
     *
     * use map :
     * Runtime: 8 ms, faster than 80.48% of Java online submissions for Insert Delete GetRandom O(1).
     * Memory Usage: 43.9 MB, less than 72.53% of Java online submissions for Insert Delete GetRandom O(1).
     */
    static class RandomizedSet {

        private final Random random = new Random();
        private final Map<Integer, Integer> map;
        private final List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            Integer index = map.get(val);
            if (index == null) {
                return false;
            }
            // 防止集合内部数组向前移动产生的copy，进行与最后一个元素swap位置
            int temp = list.get(list.size() -1);
            list.set(index, temp);
            map.put(temp, index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

    public static void main(String[] args) {
        /**
         ["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
         [[],[0],[1],[0],[2],[1],[]]
         */
        RandomizedSet randomizedSet = new RandomizedSet();
//        System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
//        System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
//        System.out.println(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
//        System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
//        System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
//        System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
//        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
        /**
         * ["RandomizedSet","insert","insert","remove","insert","insert","insert","remove","remove","insert","remove","insert","insert","insert","insert","insert","getRandom","insert","remove","insert","insert"]
         * [[],[3],[-2],[2],[1],[-3],[-2],[-2],[3],[-1],[-3],[1],[-2],[-2],[-2],[1],[],[-2],[0],[-3],[1]]
         * Output:
         * [null,true,true,false,true,true,false,true,true,true,true,false,true,false,false,false,-3,false,false,true,false]
         * Expected:
         * [null,true,true,false,true,true,false,true,true,true,true,false,true,false,false,false,-1,false,false,true,false]
         */
        System.out.println(randomizedSet.insert(3));
        System.out.println(randomizedSet.insert(-2));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.insert(-3));
        System.out.println(randomizedSet.insert(-2));
        System.out.println(randomizedSet.remove(-2));
        System.out.println(randomizedSet.remove(3));
        System.out.println(randomizedSet.insert(-1));
        System.out.println(randomizedSet.remove(-3));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.insert(-2));
        System.out.println(randomizedSet.insert(-2));
        System.out.println(randomizedSet.insert(-2));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.getRandom());
    }
}
