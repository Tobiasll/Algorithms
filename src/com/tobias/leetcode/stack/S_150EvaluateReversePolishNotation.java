package com.tobias.leetcode.stack;


import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 *
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class S_150EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if (tokens != null && tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        int result = 0;

        if (tokens != null) {
            Stack<String> stack = new Stack<>();
            for (String token : tokens) {
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    int calculate = calculate(a, b, token.charAt(0));
                    stack.push(calculate + "");
                    result = calculate;
                } else {
                    stack.push(token);
                }
            }
        }
        return result;
    }

    private int calculate(int a, int b, char token) {
        switch (token) {
            case '+' :
                return b + a;
            case '-' :
                return b - a;
            case '*' :
                return b * a;
            case '/' :
                return b / a;
        }
        return 0;
    }

    public static void main(String[] args) {
        S_150EvaluateReversePolishNotation evaluateReversePolishNotation = new S_150EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evaluateReversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evaluateReversePolishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
