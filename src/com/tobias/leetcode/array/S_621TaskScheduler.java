package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order.
 Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

 However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array),
 that is that there must be at least n units of time between any two same tasks.

 Return the least number of units of times that the CPU will take to finish all the given tasks.

 Example 1:

 Input: tasks = ['A','A','A','B','B','B'], n = 2
 Output: 8
 Explanation:
 A -> B -> idle -> A -> B -> idle -> A -> B
 There is at least 2 units of time between any two same tasks.
 Example 2:

 Input: tasks = ['A','A','A','B','B','B'], n = 0
 Output: 6
 Explanation: On this case any permutation of size 6 would work since n = 0.
 ['A','A','A','B','B','B']
 ['A','B','A','B','A','B']
 ['B','B','B','A','A','A']
 ...
 And so on.
 Example 3:

 Input: tasks = ['A','A','A','A','A','A','B','C','D','E','F','G'], n = 2
 Output: 16
 Explanation:
 One possible solution is
 A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A


 Constraints:

 1 <= task.length <= 104
 tasks[i] is upper-case English letter.
 The integer n is in the range [0, 100].
 */
public class S_621TaskScheduler {


    /**
     * use node:
     * Runtime: 27 ms, faster than 23.99% of Java online submissions for Task Scheduler.
     * Memory Usage: 40 MB, less than 79.25% of Java online submissions for Task Scheduler.
     *
     * use map:
     * Runtime: 40 ms, faster than 14.73% of Java online submissions for Task Scheduler.
     * Memory Usage: 39.8 MB, less than 89.25% of Java online submissions for Task Scheduler.
     */
    public int leastInterval(char[] tasks, int n) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(map.entrySet());

        while (!queue.isEmpty()) {
            List<Map.Entry<Character, Integer>> tempQueue = new ArrayList<>();
            Map.Entry<Character, Integer> fistNode = queue.poll();
            fistNode.setValue(fistNode.getValue() - 1);
            result++;
            if (fistNode.getValue() == 0 && queue.isEmpty()) {
                return result;
            }
            for (int i = 0; i < n; i++) {
                if (fistNode.getValue() == 0 && queue.isEmpty() && tempQueue.isEmpty()) {
                    return result;
                }
                if (!queue.isEmpty() && queue.peek().getKey() != fistNode.getKey()) {
                    Map.Entry<Character, Integer> poll = queue.poll();
                    poll.setValue(poll.getValue() - 1);
                    if (poll.getValue() > 0) {
                        tempQueue.add(poll);
                    }
                }
                result++;
            }
            queue.addAll(tempQueue);
            if (fistNode.getValue() > 0) {
                queue.offer(fistNode);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        S_621TaskScheduler taskScheduler = new S_621TaskScheduler();
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }
}
