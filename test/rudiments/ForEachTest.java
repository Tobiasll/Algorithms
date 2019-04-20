package rudiments;

import java.util.Arrays;
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

}
