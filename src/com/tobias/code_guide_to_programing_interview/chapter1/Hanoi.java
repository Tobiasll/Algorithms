package com.tobias.code_guide_to_programing_interview.chapter1;

public class Hanoi {

  public int hanoiProblem(int num, String from, String to) {
    return process(num, "left", "mid", "right", from, to);
  }

  private int process(int num, String left, String mid, String right, String from, String to) {
    if (num == 1) {
      if (from.equals(mid) | to.equals(mid)) {
        System.out.println("Move " + 1 + " from " + from + " to " + to);
        return 1;
      } else {
        System.out.println("Move " + 1 + " from " + from + " to " + mid);
        System.out.println("Move " + 1 + " from " + mid + " to " + to);
        return 2;
      }
    } else {
      if (from.equals(mid) | to.equals(mid)) {
        String another = (from.equals(left) | to.equals(left)) ? right : left;
        int part1 = process(num - 1, left, mid, right, from, another);
        System.out.println("Move " + num + " from " + from + " to " + to);
        int part2 = 1;
        int part3 = process(num - 1, left, mid, right, another, to);
        return part1 + part2 + part3;
      } else {
        int part1 = process(num - 1, left, mid, right, from, to);
        int part2 = 1;
        System.out.println("Move " + num + " from " + from + " to " + mid);
        int part3 = process(num - 1, left, mid, right, to, from);
        System.out.println("Move " + num + " from " + mid + " to " + to);
        int part4 = 1;
        int part5 = process(num - 1, left, mid, right, from, to);
        return part1 + part2 + part3 + part4 + part5;
      }
    }
  }

  public static void main(String[] args) {
    Hanoi hanoi = new Hanoi();
    System.out.println(hanoi.hanoiProblem(2, "left", "right"));
  }

}
