package com.tobias.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of
 * dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so
 * on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each
 * letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." +
 * "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 *
 * Example: Input: words = ["gin", "zen", "gig", "msg"] Output: 2 Explanation: The transformation of
 * each word is: "gin" -> "--...-." "zen" -> "--...-." "gig" -> "--...--." "msg" -> "--...--."
 *
 * There are 2 different transformations, "--...-." and "--...--.".
 */
public class UniqueMorseCodeWords804 {

  public static void main(String[] args) {
    System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
  }

  private static int uniqueMorseRepresentations(String[] words) {
    String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
        ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--.."};
    Set<String> codeSet = new HashSet<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      for (char c : word.toCharArray()) {
        sb.append(codes[c - 'a']);
      }
      codeSet.add(sb.toString());
    }

    return codeSet.size();
  }

}
