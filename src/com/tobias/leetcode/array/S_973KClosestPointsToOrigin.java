package com.tobias.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class S_973KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {

        int[][] result = new int[K][2];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(points.length + 1, Comparator.comparingInt(this::calculateDistance));

        for (int[] point : points) {
            priorityQueue.offer(point);
        }

        for (int i = 0; i < K; i++) {
            result[i] = priorityQueue.poll();
        }

        return result;
    }

    private int calculateDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosestByArray(int[][] points, int K) {

        int[][] result = new int[K][2];
        int[][] distances = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            distances[i][0] = calculateDistance(points[i]);
            distances[i][1] = i;
        }

        Arrays.sort(distances, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < K; i++) {
            int index = distances[i][1];
            result[i] = points[index];
        }

        return result;
    }


    public static void main(String[] args) {
        S_973KClosestPointsToOrigin kClosestPointsToOrigin = new S_973KClosestPointsToOrigin();
//        int[][] ints = kClosestPointsToOrigin.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        int[][] ints = kClosestPointsToOrigin.kClosest(new int[][]{{3,3}, {5,-1}, {-2,4}}, 2);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
