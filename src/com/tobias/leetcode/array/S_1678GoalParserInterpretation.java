package com.tobias.leetcode.array;


/**
 *You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.
 *
 * Given the string command, return the Goal Parser's interpretation of command.
 *
 *
 *
 * Example 1:
 *
 * Input: command = "G()(al)"
 * Output: "Goal"
 * Explanation: The Goal Parser interprets the command as follows:
 * G -> G
 * () -> o
 * (al) -> al
 * The final concatenated result is "Goal".
 * Example 2:
 *
 * Input: command = "G()()()()(al)"
 * Output: "Gooooal"
 * Example 3:
 *
 * Input: command = "(al)G(al)()()G"
 * Output: "alGalooG"
 *
 *
 * Constraints:
 *
 * 1 <= command.length <= 100
 * command consists of "G", "()", and/or "(al)" in some order.
 */
public class S_1678GoalParserInterpretation {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Goal Parser Interpretation.
     * Memory Usage: 36.9 MB, less than 95.13% of Java online submissions for Goal Parser Interpretation.
     */
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == ')') {
                if (command.charAt(i - 1) == '(') {
                    sb.append('o');
                }
            } else if (command.charAt(i) != '(') {
                sb.append(command.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        S_1678GoalParserInterpretation goalParserInterpretation = new S_1678GoalParserInterpretation();
        System.out.println(goalParserInterpretation.interpret("G()(al)"));
        System.out.println(goalParserInterpretation.interpret("G()()()()(al)"));
        System.out.println(goalParserInterpretation.interpret("(al)G(al)()()G"));
    }
}
