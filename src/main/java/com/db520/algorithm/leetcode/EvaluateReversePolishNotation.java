package com.db520.algorithm.leetcode;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 *
 * @author zhuyl
 * @version 2019-06-14
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        String[] tokens4 = {"2", "1", "+", "3", "*"};
        String[] tokens5 = {"18"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] tokens2 = {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26",
                "-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/",
                "-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21",
                "28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/",
                "-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens2));
    }


    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        boolean first = true;
        for (int i = 0; i < tokens.length ; i++) {
            if(isOper(tokens[i])) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(tokens[i].equals("+")) {
                    result = num2 + num1;
                } else if(tokens[i].equals("-")) {
                    result = num2 - num1;
                } else if(tokens[i].equals("*")) {
                    result = num2 * num1;
                } else if(tokens[i].equals("/")) {
                    result = num2 / num1;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return result;
    }

    private boolean isOper(String str) {
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
}
