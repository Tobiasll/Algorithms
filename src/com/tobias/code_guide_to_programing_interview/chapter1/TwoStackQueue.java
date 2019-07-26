package com.tobias.code_guide_to_programing_interview.chapter1;

import java.util.Stack;

public class TwoStackQueue {

  private Stack<Integer> stackPush = new Stack<>();
  private Stack<Integer> stackPop = new Stack<>();

  public void push(int value) {
    stackPush.push(value);
  }

  public int pop() {
    assert stackPush.isEmpty() & stackPop.isEmpty();
    while (!stackPush.isEmpty()) {
      stackPop.push(stackPush.pop());
    }
    return stackPop.pop();
  }

  public int peek() {
    assert stackPush.isEmpty() & stackPop.isEmpty();
    while (!stackPush.isEmpty()) {
      stackPop.push(stackPush.pop());
    }
    return stackPop.peek();
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Integer push : stackPush) {
      stringBuilder.append(push).append(" : ");
    }
    for (Integer pop : stackPop) {
      stringBuilder.append(pop).append(" : ");
    }
    return stringBuilder.toString().substring(0, stringBuilder.length() - 3);
  }

  public static void main(String[] args) {
    TwoStackQueue stackQueue = new TwoStackQueue();
    stackQueue.push(1);
    stackQueue.push(2);
    stackQueue.push(3);
    stackQueue.push(4);
    stackQueue.push(5);
    System.out.println(stackQueue.pop());
    System.out.println(stackQueue);
    System.out.println(stackQueue.peek());
  }

}
