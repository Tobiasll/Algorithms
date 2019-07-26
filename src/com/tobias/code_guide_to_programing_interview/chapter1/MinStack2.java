package com.tobias.code_guide_to_programing_interview.chapter1;


import java.util.Stack;

public class MinStack2 {

  private Stack<Integer> stackData = new Stack<>();
  private Stack<Integer> stackMin = new Stack<>();

  public void push(int num) {
    if (stackMin.isEmpty()) {
      stackMin.push(num);
    } else if (num < stackMin.peek()) {
      stackMin.push(num);
    } else {
      stackMin.push(stackMin.peek());
    }
    stackData.push(num);
  }

  public int pop() {
    assert stackData.isEmpty();
    stackMin.pop();
    return stackData.pop();
  }

  public int getMin() {
    assert stackMin.isEmpty();
    return stackMin.peek();
  }

  @Override
  public String toString() {
    return "MinStack2{" +
        "stackData=" + stackData +
        ", stackMin=" + stackMin +
        '}';
  }

  public static void main(String[] args) {

  }

}
