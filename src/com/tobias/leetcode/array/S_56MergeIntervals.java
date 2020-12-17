package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]] Explanation: Since intervals
 * [1,3] and [2,6] overlaps, merge them into [1,6]. Example 2:
 * <p>
 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are considered
 * overlapping. NOTE: input types have been changed on April 15, 2019. Please reset to default code
 * definition to get new method signature.
 */
public class S_56MergeIntervals {

     static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals.length == 0) {
            return null;
        }
        //将第一个节点加入，作为合并好的节点列表
        ans.add(new Interval(intervals[0][0], intervals[0][1]));
        //遍历其他的每一个节点
        for (int i = 1; i < intervals.length; i++) {
            Interval start = null;
            Interval end = null;
            //新加入节点的左端点
            int i_start = intervals[i][0];
            //新加入节点的右端点
            int i_end = intervals[i][1];

            //情况 6，保存囊括的节点，便于删除
            List<Interval> in = new ArrayList<>();
            //遍历合并好的每一个节点
            for (Interval an : ans) {
                //找到左端点在哪个节点内
                if (i_start >= an.start && i_start <= an.end) {
                    start = an;
                }
                //找到右端点在哪个节点内
                if (i_end >= an.start && i_end <= an.end) {
                    end = an;
                }
                //判断新加入的节点是否囊括当前旧节点，对应情况 6
                if (i_start < an.start && i_end > an.end) {
                    in.add(an);
                }

            }
            //删除囊括的节点
            if (in.size() != 0) {
                for (Interval interval : in) {
                    ans.remove(interval);
                }
            }
            //equals 函数作用是在 start 和 end 有且只有一个 null，或者 start 和 end 是同一个节点返回 true，相当于情况 2 3 4 中的一种
            if (equals(start, end)) {
                //如果 start 和 end 都不等于 null 就代表情况 4

                // start 等于 null 的话相当于情况 3
                int s = start == null ? i_start : start.start;
                // end 等于 null 的话相当于情况 2
                int e = end == null ? i_end : end.end;
                ans.add(new Interval(s, e));
                // start 和 end 不是同一个节点，相当于情况 1
            } else if (start != null) {
                ans.add(new Interval(start.start, end.end));
                // start 和 end 都为 null，相当于情况 5 和 情况 6 ，加入新节点
            }else {
                ans.add(new Interval(i_start, i_end));
            }
            //将旧节点删除
            if (start != null) {
                ans.remove(start);
            }
            if (end != null) {
                ans.remove(end);
            }

        }
        int[][] resultInt = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            resultInt[i][0] = ans.get(i).start;
            resultInt[i][1] = ans.get(i).end;
        }
        return resultInt;
    }

    private boolean equals(Interval start, Interval end) {
        if (start == null && end == null) {
            return false;
        }
        if (start == null || end == null) {
            return true;
        }
        return start.start == end.start && start.end == end.end;
    }


    /**
     * Wrong Answer
     * Details
     * Input
     * [[1,4],[2,3]]
     * Output
     * [[1,4],[2,3]]
     * Expected
     * [[1,4]]
     */
    public int[][] mergeWrongAnswer(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
//    sort(intervals);

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (int i = 0; i < intervals.length; i++) {
            int firstNum = intervals[i][0];
            int secondNum = intervals[i][1];

            while (i + 1 < intervals.length && secondNum <= intervals[i + 1][1] && secondNum >= intervals[
                    i + 1][0]) {
                secondNum = intervals[i + 1][1];
                i++;
            }

            result.add(new int[]{firstNum, secondNum});
        }
        int[][] resultInt = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultInt[i] = result.get(i);
        }
        return resultInt;
    }

    private int[][] sort(int[][] intervals) {
        sort(intervals, 0, intervals.length - 1);
        return intervals;
    }

    private void sort(int[][] intervals, int l, int h) {
        if (l >= h) {
            return;
        }
        int j = partition(intervals, l, h);
        sort(intervals, l, j - 1);
        sort(intervals, j + 1, h);

    }

    private int partition(int[][] intervals, int l, int h) {
        //8, 9, 1, 7, 2, 3, 5, 4, 6, 0
        int i = l, j = h + 1;
        int firstValue = intervals[l][0];

        while (true) {
            while (true) {
                if (intervals[++i][0] >= firstValue || i == h) {
                    break;
                }
            }
            while (true) {
                if (intervals[--j][0] <= firstValue || j == l) {
                    break;
                }

            }
            if (i >= j) {
                break;
            }
            int[] temp = intervals[i];
            intervals[i] = intervals[j];
            intervals[j] = temp;

        }
        int[] temp = intervals[l];
        intervals[l] = intervals[j];
        intervals[j] = temp;
        return j;
    }


    public static void main(String[] args) {
        S_56MergeIntervals s_56MergeIntervals = new S_56MergeIntervals();
//        int[][] merge = s_56MergeIntervals.merge(new int[][]{{1,4},{2,3}});
        int[][] merge = s_56MergeIntervals.merge(new int[][]{{1,6},{8,12},{5,9},{15,12}});
//        int[][] merge = s_56MergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
//    int[][] merge = s_56MergeIntervals.merge(new int[][]{{1, 4}, {0, 4}});
//    int[][] merge = s_56MergeIntervals.merge(new int[][]{{1, 4}, {1, 5}});
        for (int[] insideArray : merge) {
            System.out.println(Arrays.toString(insideArray));
        }
    }

}
