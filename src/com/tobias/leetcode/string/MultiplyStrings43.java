package com.tobias.leetcode.string;


/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1
 * and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3" Output: "6" Example 2:
 *
 * Input: num1 = "123", num2 = "456" Output: "56088" Note:
 *
 * The length of both num1 and num2 is < 110. Both num1 and num2 contain only digits 0-9. Both num1
 * and num2 do not contain any leading zero, except the number 0 itself. You must not use any
 * built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings43 {

  public String multiplyByVertical(String num1, String num2) {
    StringBuilder result = new StringBuilder();
    int[] pos = new int[num1.length() + num2.length()];
    for (int i = num1.length() - 1; i >= 0; i--) {
      for (int j = num2.length() - 1; j >= 0; j--) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int sum = pos[i + j + 1] + mul;
        pos[i + j] += sum / 10;
        pos[i + j + 1] = sum % 10;
      }
    }

    for (int i = 0; i < pos.length; i++) {
      if (i == 0 && pos[i] == 0) {
        continue;
      }
      result.append(pos[i]);
    }
    return result.toString();
  }

  public String multiply(String num1, String num2) {
    if ("0".equals(num1) || "0".equals(num2)) {
      return "0";
    }

    String result = "";
    int zeroize = 0;
    for (int i = num2.length() - 1; i >= 0; i--) {
      int digit1 = num2.charAt(i) - '0';
      int carry = 0;
      StringBuilder resultPart = new StringBuilder();
      for (int j = num1.length() - 1; j >= 0; j--) {
        int digit2 = num1.charAt(j) - '0';
        int sum = digit1 * digit2 + carry;
        resultPart.insert(0, sum % 10);
        carry = sum / 10;
      }
      if (carry > 0) {
        resultPart.insert(0, carry);
      }
      for (int k = 0; k < zeroize; k++) {
        resultPart.append('0');
      }
      zeroize++;
      System.out.println(resultPart.toString());
      result = sumString(result, resultPart.toString());
    }
    return result;
  }

  private String sumString(String result, String resultPart) {
    int firstIndex = result.length() - 1;
    int secondIndex = resultPart.length() - 1;
    int carry = 0;
    StringBuilder resultBuilder = new StringBuilder();
    while (firstIndex >= 0 || secondIndex >= 0) {
      int sum = calculateSum(result, resultPart, firstIndex, secondIndex, carry);
      carry = sum / 10;
      resultBuilder.insert(0, sum % 10);
      firstIndex--;
      secondIndex--;
    }

    if (carry > 0) {
      resultBuilder = resultBuilder.insert(0, carry);
    }
    return resultBuilder.toString();
  }

  static int calculateSum(String result, String resultPart, int firstIndex, int secondIndex,
      int carry) {
    int digit1 = firstIndex >= 0 ? result.charAt(firstIndex) - '0' : 0;
    int digit2 = secondIndex >= 0 ? resultPart.charAt(secondIndex) - '0' : 0;
    return digit1 + digit2 + carry;
  }

  public static void main(String[] args) {
    MultiplyStrings43 multiplyStrings43 = new MultiplyStrings43();
//    System.out.println(multiplyStrings43.multiply("1123", "245"));
    System.out.println(multiplyStrings43.multiplyByVertical("123", "45"));
  }
}
