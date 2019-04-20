package com.tobias.cat;


import java.util.List;

class Interval {

  int start, end;

  Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}


/**
 * 920. 会议室 给定一系列的会议时间间隔，包括起始和结束时间[[s1,e1]，[s2,e2]，…(si < ei)，确定一个人是否可以参加所有会议。 样例 样例1
 *
 * 输入: intervals = [(0,30),(5,10),(15,20)] 输出: false 解释: (0,30), (5,10) 和 (0,30),(15,20) 这两对会议会冲突
 * 样例2
 *
 * 输入: intervals = [(5,8),(9,15)] 输出: true 解释: 这两个时间段不会冲突
 */
public class Solution920 {

  public static void main(String[] args) {

  }

  public static boolean canAttendMeetings(List<Interval> intervals) {
    // Write your code here
    for (int i = 0; i < intervals.size(); i++) {
      for (int j = i; i < intervals.size(); j++) {
        Interval intervalI = intervals.get(i);
        Interval intervalJ = intervals.get(j);
        if (intervalJ.start >= intervalI.start && intervalJ.start <= intervalI.end) {
          return false;
        } else if (intervalJ.end >= intervalI.start && intervalJ.end <= intervalI.end) {
          return false;
        }
      }
    }
    return true;
  }

}
