package com.tobias.rudiment.string;

public class RKMatch {

  public static void main(String[] args) {
    System.out.println(match("qdabcd", "abcd"));
    System.out.println(match("qdabcd", "jj"));
  }

  private static int match(String origin, String keyword) {
    int index = -1;
    int hashCode = keyword.hashCode();
    int length = keyword.length();
    String subString;
    for (int i = 0; i < origin.length(); i++) {
      if (i + length > origin.length()) {
        break;
      }
      subString = origin.substring(i, length + i);
      if (subString.hashCode() == hashCode) {
        for (int j = 0; j < keyword.length(); j++) {
          if (subString.charAt(j) != keyword.charAt(j)) {
            break;
          }
          if (j == keyword.length() - 1) {
            index = i;
          }
        }
      }

    }

    return index;
  }
}
