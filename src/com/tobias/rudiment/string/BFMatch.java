package com.tobias.rudiment.string;

public class BFMatch {

  public static void main(String[] args) {
    System.out.println(match("qdabcd", "abcd"));
    System.out.println(match("qdabcd", "jj"));
  }

  private static int match(String originText, String keyword) {
    int index = -1;

    for (int i = 0; i < originText.length(); i++) {
      boolean flag = false;
      for (int j = 0; j < keyword.length(); j++) {
        if (i + j >= originText.length()) {
          break;
        }
        if (originText.charAt(i + j) != keyword.charAt(j)) {
          break;
        }
          if (j == keyword.length() - 1) {
              index = i;
              flag = true;
              break;
          }
      }
      if (flag) {
        break;
      }
    }
    return index;
  }
}
