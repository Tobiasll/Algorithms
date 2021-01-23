package com.tobias.leetcode.array;


/**
 *Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 * Example 1:
 *
 * Input: num = 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 *
 * Input: num = 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 *
 * Constraints:
 *
 * The given integer num is guaranteed to fit within the range of a 32-bit signed integer.
 * num >= 1
 * You could assume no leading zero bit in the integer’s binary representation.
 * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class S_476NumberComplement {

    public int findComplement(int num) {
        int result = 0;
        int count = 0;

        while (result < num) {
            result += Math.pow(2, count++);
        }

        return result - num;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Number Complement.
     * Memory Usage: 35.9 MB, less than 51.25% of Java online submissions for Number Complement.
     */
    public int findComplement1(int num) {
        if (num == 0) {
            return 1;
        }
        int result = 0;
        int length = num / 2;
        int count = length;
        while (num > 0) {
            if (num % 2 == 0) {
                result += Math.pow(2, length - count);
            }
            count--;
            num /= 2;
        }
        return result;
    }

    /**
     * Runtime: 1 ms, faster than 27.35% of Java online submissions for Number Complement.
     * Memory Usage: 36.2 MB, less than 18.79% of Java online submissions for Number Complement.
     */
    public int findComplementWithStupid(int num) {
        String binaryString = Integer.toBinaryString(num);
        char[] chars = binaryString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                chars[i] = '1';
            } else {
                chars[i] = '0';
            }
        }

        return Integer.parseInt(new String(chars), 2);
    }

    public static void main(String[] args) {
        S_476NumberComplement numberComplement = new S_476NumberComplement();

        System.out.println(numberComplement.findComplement(11));
        System.out.println(numberComplement.findComplement(5));
        System.out.println(numberComplement.findComplement(6));
        System.out.println(numberComplement.findComplement(2));
        System.out.println(Integer.toBinaryString(11));


    }
}
