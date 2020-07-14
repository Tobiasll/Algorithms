package com.tobias.leetcode.string;


import java.util.HashSet;
import java.util.Set;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class S_415AddStrings {

    public String addStrings(String num1, String num2) {
        return null;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        System.out.println(set.stream().findFirst().orElse(null));
    }

}
