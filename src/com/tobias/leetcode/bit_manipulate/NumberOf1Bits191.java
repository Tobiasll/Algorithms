package com.tobias.leetcode.bit_manipulate;

/**
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 *
 */
public class NumberOf1Bits191 {

    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count ++;
            }
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int result = 0;
        while (n != 0) {
            // 不断累加n 是否 == 1
            result += (n & 1);
            // 因为n的取值范围包括负数，所以我们需要使用无符号右移来得到二进制，不能使用普通的右移或n / 2来获取二进制，右移正整数情况下符号位为0，所以高位右移为0，而负数为+1所以高位为1
            // 负数右移首先获取正整数二进制码，然后获取符号位码，即补码（+1），然后进行取反，将正整数的二进制的0变1，1变0，然后最后位加1，
            // 此时就可以得到负数的二进制了，然后开始右移多少位就在高位加多少个1，然后在减1就可以得到补码了
            n >>>= 1;
        }

        return result ;
    }

    public static void main(String[] args) {


        NumberOf1Bits191 bits191 = new NumberOf1Bits191();
        System.out.println(bits191.hammingWeight1(-3));
        System.out.println(bits191.hammingWeight1(-2));
        System.out.println(bits191.hammingWeight1(-4));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(-4));
    }
}
