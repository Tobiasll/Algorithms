package com.tobias.leetcode.stack;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class S_232ImplementQueueUsingStacks {

    private final Stack<Integer> stackA = new Stack<>();
    private final Stack<Integer> stackB = new Stack<>();


    /** Initialize your data structure here. */
    public S_232ImplementQueueUsingStacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stackA.isEmpty() && stackB.isEmpty()) {
            stackA.push(x);
        } else {
            stackA.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }

    public static void main(String[] args) {
        S_232ImplementQueueUsingStacks s_232ImplementQueueUsingStacks = new S_232ImplementQueueUsingStacks();
        s_232ImplementQueueUsingStacks.push(1);
        s_232ImplementQueueUsingStacks.push(2);
        System.out.println(s_232ImplementQueueUsingStacks.peek());
        System.out.println(s_232ImplementQueueUsingStacks.pop());
        System.out.println(s_232ImplementQueueUsingStacks.empty());
        System.out.println(s_232ImplementQueueUsingStacks.pop());
        System.out.println(s_232ImplementQueueUsingStacks.empty());
        s_232ImplementQueueUsingStacks.push(3);
        s_232ImplementQueueUsingStacks.push(4);
        s_232ImplementQueueUsingStacks.push(5);
        System.out.println(s_232ImplementQueueUsingStacks.pop());
        System.out.println(s_232ImplementQueueUsingStacks.pop());
        System.out.println(s_232ImplementQueueUsingStacks.peek());
        System.out.println(s_232ImplementQueueUsingStacks.pop());
    }
}
