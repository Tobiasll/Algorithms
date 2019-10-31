package com.tobias.leetcode.array;


import java.util.Arrays;
import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units
 * of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 */
public class TrappingRainWater42 {

  public int trapByStack(int[] height) {
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
        int peekValue = height[stack.peek()];
        stack.pop();
        if (stack.isEmpty()) {
          break;
        }
        int distinct = i - stack.peek() - 1;
        int min = Math.min(height[stack.peek()], height[i]);
        result += (min - peekValue) * distinct;
      }
      stack.push(i);
    }
    return result;
  }

  public int trapByDoublePoint(int[] height) {
    int result = 0, maxLeft = 0, maxRight = 0, leftPoint = 1, rightPoint = height.length - 2;
    for (int i = 1; i < height.length - 1; i++) {
      if (height[leftPoint - 1] < height[rightPoint + 1]) {
        maxLeft = Math.max(maxLeft, height[leftPoint - 1]);
        if (maxLeft > height[leftPoint]) {
          result += (maxLeft - height[leftPoint]);
        }
        leftPoint++;
      } else {
        maxRight = Math.max(maxRight, height[rightPoint + 1]);
        if (maxRight > height[rightPoint]) {
          result += (maxRight - height[rightPoint]);
        }
        rightPoint--;
      }
    }
    return result;
  }

  public int trapByDPAndSinglePoint(int[] height) {
    int result = 0;
    int maxLeft = 0;
    int[] rightArr = new int[height.length];
    for (int i = height.length - 2; i >= 0; i--) {
      rightArr[i] = Math.max(height[i + 1], rightArr[i + 1]);
    }
    for (int i = 1; i < height.length - 1; i++) {
      maxLeft = Math.max(maxLeft, height[i - 1]);
      int min = Math.min(maxLeft, rightArr[i]);
      if (min > height[i]) {
        result += (min - height[i]);
      }
    }
    return result;
  }

  public int trapByDP(int[] height) {
    int result = 0;
    int[] leftArr = new int[height.length];
    int[] rightArr = new int[height.length];
    for (int i = 1; i < height.length; i++) {
      leftArr[i] = Math.max(leftArr[i - 1], height[i - 1]);
    }
    for (int i = height.length - 2; i >= 0; i--) {
      rightArr[i] = Math.max(height[i + 1], rightArr[i + 1]);
    }

    for (int i = 1; i < height.length - 1; i++) {
      int min = Math.min(leftArr[i], rightArr[i]);
      if (min > height[i]) {
        result += (min - height[i]);
      }
    }
    System.out.println(Arrays.toString(leftArr));
    System.out.println(Arrays.toString(rightArr));
    return result;
  }

  public int trapByViolenceCol(int[] height) {
    int result = 0;
    for (int i = 1; i < height.length - 1; i++) {
      int maxLeft = height[i - 1];
      for (int leftI = i - 2; leftI >= 0; leftI--) {
        maxLeft = Math.max(maxLeft, height[leftI]);
      }
      int maxRight = height[i + 1];
      for (int rightI = i + 2; rightI <= height.length - 1; rightI++) {
        maxRight = Math.max(maxRight, height[rightI]);
      }
      int min = Math.min(maxLeft, maxRight);
      if (min > height[i]) {
        result += (min - height[i]);
      }
    }
    return result;
  }

  public int trapByViolenceRow(int[] height) {
    // Time Limit Exceeded
    int result = 0;
    int hight = height[0];
    for (int i = 1; i < height.length; i++) {
      hight = Math.max(hight, height[i]);
    }

    for (int i = 1; i <= hight; i++) {
      int temp = 0;
      boolean isStart = false; //标记是否开始更新 temp
      for (int num : height) {
        if (isStart && num < i) {
          temp++;
        } else if (num >= i) {
          result += temp;
          temp = 0;
          isStart = true;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TrappingRainWater42 trappingRainWater42 = new TrappingRainWater42();
    System.out
        .println(trappingRainWater42.trapByStack(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    System.out.println(trappingRainWater42.trapByStack(new int[]{2, 1, 0, 2}));
    System.out.println(trappingRainWater42.trapByStack(new int[]{4, 2, 0, 3, 2, 5}));
  }
}
