package rudiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class ForEachTest {

  @Test
  public void test1() {
    for (int i =0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        System.out.print(" # ");
      }
      System.out.println();
    }
  }

  @Test
  public void test2() {
    for (int i =0; i < 11; i++) {
      for (int j = 0; j < i; j++) {
        System.out.print(" # ");
      }
      System.out.println();
    }
  }

  @Test
  public void test3() {
    for (int i =1; i < 56; i <<= 1) {
      for (int j = 0; j < i; j++) {
        System.out.print(" # ");
      }
      System.out.println();
    }
  }


  @Test
  public void test4() {
    System.out.println(32 << 1);
  }

  @Test
  public void test5() {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6};
    reverse(arr,0, 5);
    System.out.println(Arrays.toString(arr));
  }


  private void reverse(int[] arr, int low, int hight) {
    if (low < hight) {
      int temp = arr[low];
      arr[low] = arr[hight];
      arr[hight] = temp;
      reverse(arr, ++low, ++hight);
    }
  }

  @Test
  public void test6() {
    int i = 0;
    test(++i);

    for (int x = 0; x < 10; x++) {
      int temp;
      temp = i++;
      System.out.println(temp + "  " + i);
    }

    int[] arr = new int[]{1, 2, 3, 4, 5, 6};
    int low = 0;
    int hight = arr.length - 1;

    while (low < hight) {
      int temp = arr[low];
      arr[low++] = arr[hight];
      arr[hight--] = temp;
    }
    System.out.println(Arrays.toString(arr));
  }

  private void test(int i) {
    System.out.println(i);
  }

  @Test
  public void test7() {
    int f = 0; int g = 1;
    int n = 8;
    while (0 < n--) {
      g = g + f;
      f = g - f;
    }
    System.out.println(g);
  }

  @Test
  public void test8() {
//    int[] arrs = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
    int[] arrs = new int[300];
    List<Integer> list = new ArrayList<>(300);
    for (int i = 0; i < 300; i++) {
      arrs[i] = i;
      list.add(i);
    }
    Collections.shuffle(list);
    Collections.sort(list);
    Arrays.sort(arrs);
    System.out.println(Arrays.toString(arrs));
  }

  @Test
  public void test9() {
//    System.out.println(knapsack2(new int[]{2, 2, 4, 6, 3}, 5, 9));
    System.out.println(knapsack3(new int[]{2, 2, 4, 6, 3}, new int[]{3, 4, 8, 9, 6}, 5, 9));
  }

  public static int knapsack2(int[] items, int n, int w) {
    boolean[] states = new boolean[w+1]; // 默认值 false
    states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
    states[items[0]] = true;
    for (int i = 1; i < n; ++i) { // 动态规划
      for (int j = w-items[i]; j >= 0; --j) {// 把第 i 个物品放入背包
        if (states[j]) {
          states[j + items[i]] = true;
        }
      }
    }
    for (int i = w; i >= 0; --i) { // 输出结果
      if (states[i]) return i;
    }
    return 0;
  }

  private static int knapsack3(int[] weight, int[] value, int n, int w) {
    int[][] states = new int[n][w+1];
    for (int i = 0; i < n; ++i) { // 初始化 states
      for (int j = 0; j < w+1; ++j) {
        states[i][j] = -1;
      }
    }
    states[0][0] = 0;
    states[0][weight[0]] = value[0];
    for (int i = 1; i < n; ++i) { // 动态规划，状态转移
      for (int j = 0; j <= w; ++j) { // 不选择第 i 个物品
        if (states[i-1][j] >= 0) {
          states[i][j] = states[i-1][j];
        }
      }
      for (int j = 0; j <= w-weight[i]; ++j) { // 选择第 i 个物品
        if (states[i-1][j] >= 0) {
          int v = states[i-1][j] + value[i];
          if (v > states[i][j+weight[i]]) {
            states[i][j+weight[i]] = v;
          }
        }
      }
    }
    // 找出最大值
    int maxvalue = -1;
    for (int j = 0; j <= w; ++j) {
      if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
    }
    return maxvalue;
  }

  @Test
  public void test10() {

    int x = 2;
    int y = 3;

    System.out.println((x & 1) == 0);
    System.out.println((y & 1) == 0);

    x = x ^ y;
    y = x ^ y;
    x = x ^ y;

    System.out.println(x);
    System.out.println(y);

    System.out.println((x & 1) == 0);
    System.out.println((y & 1) == 0);

  }


  @Test
  public void test11() {
    List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    Iterator<Integer> iterator = integers.iterator();

    while (iterator.hasNext()) {
      iterator.remove();
      iterator.next();
    }

    System.out.println(integers);
  }



}
