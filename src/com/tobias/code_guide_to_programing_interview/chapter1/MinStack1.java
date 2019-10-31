package com.tobias.code_guide_to_programing_interview.chapter1;


import java.util.Stack;

public class MinStack1 {

  private Stack<Integer> stackData = new Stack<>();
  private Stack<Integer> stackMin = new Stack<>();

  public void push(int num) {
    if (stackMin.isEmpty()) {
      stackMin.push(num);
    } else if (num <= stackMin.peek()) {
      stackMin.push(num);
    }
    stackData.push(num);
  }

  public int pop() {
    assert stackData.isEmpty();
    Integer value = stackData.pop();
    if (stackMin.peek().equals(value)) {
      stackMin.pop();
    }
    return value;
  }

  public int getMin() {
    assert stackMin.isEmpty();
    return stackMin.peek();
  }

  public static void main(String[] args) {
    MinStack2 minStack1 = new MinStack2();
    int[] nums = {3, 4, 5, 1, 2, 1};
    for (int num : nums) {
      minStack1.push(num);
    }
    System.out.println(minStack1.pop());
    System.out.println(minStack1.pop());
    System.out.println(minStack1.pop());
    System.out.println(minStack1.getMin());
  }

}
