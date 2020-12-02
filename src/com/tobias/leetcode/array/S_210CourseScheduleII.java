package com.tobias.leetcode.array;




import com.tobias.rudiment.heap.Array;

import java.util.*;

/**
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
 *
 * Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */
public class S_210CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Integer> countNumMap = new HashMap<>();
        Map<Integer, List<Integer>> relationMap = new HashMap<>();
        List<Integer> allNode = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[0];
            int value = prerequisite[1];
            if (!allNode.contains(key)) {
                allNode.add(key);
            }
            if (!allNode.contains(value)) {
                allNode.add(value);
            }
            if (!countNumMap.containsKey(value)) {
                countNumMap.put(value, 0);
            }
            countNumMap.put(key, countNumMap.getOrDefault(key, 0) + 1);
            if (!relationMap.containsKey(value)) {
                relationMap.put(value, new ArrayList<>());
            }
            List<Integer> list = relationMap.get(value);
            list.add(key);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer node : allNode) {
            if (countNumMap.get(node) == 0) {
                queue.offer(node);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            result[index++] = node;
            List<Integer> relationList = relationMap.get(node);
            if (relationList != null && relationList.size() > 0) {
                for (Integer relationNode : relationList) {
                    Integer num = countNumMap.get(relationNode);
                    if (num > 0) {
                        countNumMap.put(relationNode, num = num - 1);
                    }
                    if (num == 0) {
                        queue.offer(relationNode);
                    }
                }
            }
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < index; i++) {
            resultSet.add(result[i]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!resultSet.contains(i) && index < numCourses) {
                result[index++] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S_210CourseScheduleII courseScheduleII = new S_210CourseScheduleII();
        System.out.println(Arrays.toString(courseScheduleII.findOrder(3, new int[][]{{1,0},{1,2},{0,1}})));
        System.out.println(Arrays.toString(courseScheduleII.findOrder(3, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(courseScheduleII.findOrder(3, new int[][]{})));
        System.out.println(Arrays.toString(courseScheduleII.findOrder(7, new int[][]{{1,3},{1,4},{2,4},{3,5},{3,6},{4,6}})));
        System.out.println(Arrays.toString(courseScheduleII.findOrder(2, new int[][]{{1,0}})));
        System.out.println(Arrays.toString(courseScheduleII.findOrder(2, new int[][]{{1,0}, {0, 1}})));
        System.out.println(Arrays.toString(courseScheduleII.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
    }
}
