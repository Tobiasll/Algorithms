package com.tobias.cat;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {

  public static void main(String[] args) {
    List<Integer> narcissisticNumbers = getNarcissisticNumbers(3);
    System.out.println(narcissisticNumbers);
  }

  private static List<Integer> getNarcissisticNumbers(int n) {
    List<Integer> result = new ArrayList<>();

    if(n == 1){
      result.add(0);
    }

    for(int i =(int) Math.pow(10,n-1); i<Math.pow(10,n);i++){

      int variesSum = 0;
      String tempStr = String.valueOf(i);
      char[] tempChars = tempStr.toCharArray();
      for (char tempChar : tempChars) {
        String tempCharString = String.valueOf(tempChar);
        int tempVaries = Integer.valueOf(tempCharString);
        variesSum = variesSum + (int)Math.pow(tempVaries,n);
      }

      if(i == variesSum){
        result.add(i);
      }

    }

    return result;
  }
}
