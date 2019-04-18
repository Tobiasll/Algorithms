package com.tobias.cat;

public class Solution4 {

  public static void main(String[] args) {
    aplusb(5 ,7 );
    int a = 5;
    int b = 17;
    System.out.println(a & b);
    System.out.println(a ^ b);
    System.out.println(a & b);
  }

  private static int aplusb(int a, int b) {
    if(a==0) return b;
    if(b==0) return a;
    int sum,i;
    i=a^b;
    sum=(a&b)<<1;
    return aplusb(sum,i);
  }

}
