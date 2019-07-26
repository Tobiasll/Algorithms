package com.tobias.code_guide_to_programing_interview.chapter1;

import java.util.Arrays;
import java.util.Stack;

public class RecursionStack extends Stack<Integer> {

  {
    addAll(Arrays.asList(1, 2, 9, 4, 5, 3));
  }

  public int getLastElement() {
    return getAndRemoveLastElement(this);
  }


  private int getAndRemoveLastElement(Stack<Integer> stack) {
    Integer result = stack.pop();
    if (stack.isEmpty()) {
      return result;
    } else {
      int lastElement = getAndRemoveLastElement(stack);
      stack.push(result);
      return lastElement;
    }

  }

  public void reverse() {
    reverse(this);
  }

  private void reverse(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return;
    }
    int lastElement = getAndRemoveLastElement(stack);
    reverse(stack);
    stack.push(lastElement);
  }


  public void sort() {
    Stack<Integer> help = new Stack<>();
    while (!isEmpty()) {
      Integer current = pop();
      while (!help.isEmpty() && current > help.peek()) {
        push(help.pop());
      }
      help.push(current);
    }
    while (!help.isEmpty()) {
      push(help.pop());
    }
  }

  public static void main(String[] args) {
    RecursionStack stack = new RecursionStack();
    System.out.println(stack);
    stack.sort();
    System.out.println(stack);
  }

}
