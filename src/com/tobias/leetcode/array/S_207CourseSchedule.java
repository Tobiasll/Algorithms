package com.tobias.leetcode.array;


import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 1 <= numCourses <= 10^5
 *
 * [1,3],[1,4],[2,4],[3,5],[3,6],[4,6]
 */
public class S_207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> inNode = new HashMap<>();
        Set<Integer> allNode = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[0];
            int value = prerequisite[1];
            allNode.add(key);
            allNode.add(value);
            if (!map.containsKey(key)) {
                map.put(key, 0);
            }
            if (!map.containsKey(value)) {
                map.put(value, 0);
            }
            Integer num = map.get(key);
            map.put(key, num + 1);

            if (!inNode.containsKey(value)) {
                inNode.put(value, new ArrayList<>());
            }
            List<Integer> list = inNode.get(value);
            list.add(key);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer node : allNode) {
            if (map.get(node) == 0) {
                queue.offer(node);
            }
        }
        System.out.println(map);
        System.out.println(inNode);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> list = inNode.get(poll);
            if (list != null && list.size() > 0) {
                for (Integer node : list) {
                    Integer num = map.get(node);
                    if (num > 0) {
                        map.put(node, num = num - 1);
                    }
                    if (num == 0) {
                        queue.offer(node);
                    }
                }
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        S_207CourseSchedule courseSchedule = new S_207CourseSchedule();
        System.out.println(courseSchedule.canFinish(3, new int[][]{{1,0},{1,2},{0,1}}));
        System.out.println(courseSchedule.canFinish(2, new int[][]{{1,3},{1,4},{2,4},{3,5},{3,6},{4,6}}));
        System.out.println(courseSchedule.canFinish(2, new int[][]{{1,0}}));
        System.out.println(courseSchedule.canFinish(2, new int[][]{{1,0}, {0, 1}}));
        System.out.println(courseSchedule.canFinish(2, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
    }
}
