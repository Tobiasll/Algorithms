package com.tobias.leetcode.string;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG".
 *  When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example 1:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 *
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 105
 * s[i] is 'A', 'C', 'G', or 'T'.
 */
public class S_187RepeatedDNASequences {

    /**
     * Runtime: 16 ms, faster than 74.96% of Java online submissions for Repeated DNA Sequences.
     * Memory Usage: 43.3 MB, less than 98.24% of Java online submissions for Repeated DNA Sequences.
     *
     * int digits = 0, 0 <<= 3 -> 0000
     * s[i] & 7 -> 1000001 & 0000111 -> 001
     * key |= s[i] & 7 -> 0000 | 001 -> 001
     * key &= 0x3fffffff -> 001 &= 111111111111111111111111111111 -> 001
     * int digits = 1, 0 <<= 3 -> 1000
     * s[i] & 7 -> 1000011 & 0000111 -> 011
     * key |= s[i] & 7 -> 1000 | 011 -> 1011
     * key &= 0x3fffffff -> 1011 &= 111111111111111111111111111111 -> 1011
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return result;
        }
        Set<Integer> set = new HashSet<>();
        int digits = 0;
        for (int i = 0; i < 10; i++) {
            digits <<= 3;
            int sDigits = s.charAt(i) & 7;
            digits |= sDigits;
        }
        set.add(digits);
        for (int i = 10; i < s.length(); i++) {
            digits <<= 3;
            int sDigits = s.charAt(i) & 7;
            digits |= sDigits;
            // 不断截取后面的30位
            digits &= 0x3fffffff;
            if (!set.contains(digits)) {
                set.add(digits);
            } else {
                String substring = s.substring(i - 9, i + 1);
                if (!result.contains(substring)) {
                    result.add(substring);
                }
            }
        }
        return result;
    }

    /**
     * Runtime: 15 ms, faster than 85.88% of Java online submissions for Repeated DNA Sequences.
     * Memory Usage: 48.1 MB, less than 31.97% of Java online submissions for Repeated DNA Sequences.
     */
    public List<String> findRepeatedDnaSequencesBySubString(String s) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (!set.contains(substring)) {
                set.add(substring);
            } else if (!result.contains(substring)){
                result.add(substring);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S_187RepeatedDNASequences repeatedDNASequences = new S_187RepeatedDNASequences();
        System.out.println(repeatedDNASequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(repeatedDNASequences.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        System.out.println(repeatedDNASequences.findRepeatedDnaSequences("AAAAAAAAAAA"));

    }
}
