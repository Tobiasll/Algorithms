package com.tobias.cat;

public class Solution1775 {

  public static void main(String[] args) {
    System.out.println(getSum(3, 7));
    System.out.println(getSum(3, 3));
    System.out.println(getSum(4, 4));
    int a = 2, b = 4, h = 4;

    System.out.println((a + b) * h / 2.0);
  }

  private static int getSum(int A, int B) {
    int result = 0;

    if (A == B && A % 3 == 0) {
      return A;
    }

    for (int i = A; i < B; i++) {
      if (i % 3 == 0) {
        result += i;
      }
    }
    return result;
  }

}
