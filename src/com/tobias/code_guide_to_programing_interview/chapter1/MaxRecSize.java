package com.tobias.code_guide_to_programing_interview.chapter1;

import java.util.Arrays;
import java.util.Stack;

public class MaxRecSize {

  public int getMaxRecSize(int[][] map) {
    if (map == null || map.length == 0 || map[0].length == 0) {
      return 0;
    }
    int maxRecSzie = 0;
    int[] highs = new int[map[0].length];
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        highs[j] = map[i][j] == 0 ? 0 : highs[j] + 1;
      }
      System.out.println(Arrays.toString(highs));
      maxRecSzie = Math.max(maxRecFromBottom(highs) ,maxRecSzie);
    }

    return maxRecSzie;
  }

  public int maxRecFromBottom(int[] highs) {
    int maxRecSize = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < highs.length; i++) {
      while (!stack.isEmpty() && highs[i] <= highs[stack.peek()]) {
        Integer j = stack.pop();
        int k = stack.isEmpty() ? -1 : stack.peek();
        maxRecSize = Math.max((i - k - 1) * highs[j], maxRecSize);
      }
      stack.push(i);
    }
    System.out.println(maxRecSize);
    System.out.println(stack);
    while (!stack.isEmpty()) {
      Integer j = stack.pop();
      int k = stack.isEmpty() ? -1 : stack.peek();
      maxRecSize = Math.max((highs.length - k - 1) * highs[j], maxRecSize);
    }
    System.out.println(stack);
    return maxRecSize;
  }


  public static void main(String[] args) {
    MaxRecSize object = new MaxRecSize();
//    int maxRecSize = object.getMaxRecSize(new int[][]{{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}});
    int maxRecSize = object.maxRecFromBottom(new int[]{1,8,6,2,5,4,8,3,7});
    System.out.println(maxRecSize);

  }


}
