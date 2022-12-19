package com.wkr.ge116;

import com.wkr.Utils;

import java.util.Stack;

/**
 * @Description:
 * @date: 2022/12/19 9:55
 * @author: wangkun
 */
public class C150EvalRP {
    public static void main(String[] args) {
        Utils.check(evalRPN(new String[]{"2","1","+","3","*"}), 9);
        Utils.check(evalRPN(new String[]{"4","13","5","/","+"}), 6);
        Utils.check(evalRPN(new String[]{"4","5","-"}), -1);
        Utils.check(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}), 22);
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop()+stack.pop());
            } else if (tokens[i].equals("-")) {
                int back = stack.pop();
                stack.push(stack.pop()-back);
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop()*stack.pop());
            } else if (tokens[i].equals("/")) {
                int back = stack.pop();
                stack.push(stack.pop()/back);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
