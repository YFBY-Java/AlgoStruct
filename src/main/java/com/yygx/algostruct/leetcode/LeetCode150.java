package com.yygx.algostruct.leetcode;

import java.util.LinkedList;

/**
 *逆波兰表达式求值
 * <p>
 *给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 *
 * 请你计算该表达式。返回一个表示表达式值的整数。
 *
 * 注意：
 *
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示
 * */
public class LeetCode150 {

    public int evalRPN(String[] tokens){
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token){
                case "+" -> {
                    // 先弹出来的是右操作数
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2 + num1);
                }
                case "-" ->{
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2 - num1);
                }
                case "*" ->{
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2 * num1);
                }
                case "/" ->{
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2 / num1);
                }
                default -> {  // 数字直接入栈
                    int i = Integer.parseInt(token);
                    stack.push(i);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        LeetCode150 leetCode150 = new LeetCode150();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(leetCode150.evalRPN(tokens));
    }

}