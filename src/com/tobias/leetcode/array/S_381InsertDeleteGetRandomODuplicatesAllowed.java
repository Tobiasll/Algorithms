package com.tobias.leetcode.array;


import java.util.*;

/**
 *Design a data structure that supports all following operations in average O(1) time.
 *
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 * Example:
 *
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 *
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 *
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 *
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 *
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 *
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 */
public class S_381InsertDeleteGetRandomODuplicatesAllowed {


    /**
     * Runtime: 13 ms, faster than 30.95% of Java online submissions for Insert Delete GetRandom O(1) - Duplicates allowed.
     * Memory Usage: 46.3 MB, less than 15.22% of Java online submissions for Insert Delete GetRandom O(1) - Duplicates allowed.
     */
    static class RandomizedCollection {

        private final Random random = new Random();
        private final Map<Integer, Set<Integer>> map;
        private final List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /**  Inserts a value to the collection. Returns true if the collection did not already contain the specified element.. */
        public boolean insert(int val) {
            list.add(val);
            if (map.containsKey(val)) {
                map.get(val).add(list.size() - 1);
                return false;
            }
            Set<Integer> set = new LinkedHashSet<>();
            set.add(list.size() - 1);
            map.put(val, set);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            Set<Integer> set = map.get(val);
            if (set == null || set.size() == 0) {
                return false;
            }

            Integer removeIndex = set.iterator().next();
            int lastIndex = list.size() - 1;
            Integer lastElement = list.get(lastIndex);
            list.set(removeIndex, lastElement);
            set.remove(removeIndex);
            map.get(lastElement).add(removeIndex);
            map.get(lastElement).remove(lastIndex);
            list.remove(lastIndex);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    /**
     * Your RandomizedCollection object will be instantiated and called as such:
     * RandomizedCollection obj = new RandomizedCollection();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */

    public static void main(String[] args) {
        /**
         *
         * ["RandomizedCollection","insert","remove","insert","remove","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom"]
         * [[],[0],[0],[-1],[0],[],[],[],[],[],[],[],[],[],[]]
         */

        RandomizedCollection instance = new RandomizedCollection();
//        System.out.println(instance.insert(4));
//        System.out.println(instance.insert(3));
//        System.out.println(instance.insert(4));
//        System.out.println(instance.insert(2));
//        System.out.println(instance.insert(4));
//        System.out.println(instance.remove(4));
//        System.out.println(instance.remove(3));
//        System.out.println(instance.remove(4));
//        System.out.println(instance.remove(4));

        System.out.println(instance.insert(0));
        System.out.println(instance.remove(0));
        System.out.println(instance.insert(-1));
        System.out.println(instance.remove(0));
        System.out.println(instance.getRandom());



    }
}
