package com.yygx.algostruct.datastructure.stack;


import java.util.LinkedList;

/**
 * 中缀表达式 <P></P>
 */
public class InfixExpression {
    /*
    1.遇到非运算符 直接入栈
    2.遇到 + - * /
          优先级比栈顶运算符高，入栈
          否则把栈里优先级 >= 这个操作符的都出栈，再把这个操作符入栈
    3.遍历完成，栈里剩余元素依次出栈
    4. 带()
        左括号 直接入栈，左括号优先级最低
        右括号把栈内元素依次弹出，直到遇到左括号停止
     */


    static int priority(char c) {
        return switch (c) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            case '(' -> 0;
            default -> throw new IllegalArgumentException("参数错误");
        };
    }

    // 方法: 将中缀表达式转换为后缀表达式（逆波兰表达式）
    public String infixExpression(String exp) {
        // 使用 LinkedList 作为操作符栈，存放遇到的运算符
        LinkedList<Character> stack = new LinkedList<>();
        // StringBuilder 用于拼接输出的后缀表达式字符
        StringBuilder stringBuilder = new StringBuilder(exp.length());
        // 遍历输入的中缀表达式每个字符
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                // 如果是运算符 + - * /
                case '+', '-', '*', '/' -> {
                    // 栈空时，直接入栈
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        // 栈顶运算符优先级低于当前运算符，则当前运算符入栈
                        if (priority(c) > priority(stack.peek())) {
                            stack.push(c);
                        } else {
                            // 否则，不断弹出栈顶运算符并追加到输出，直到遇到更低优先级或栈空
                            while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                                Character pop = stack.pop();
                                stringBuilder.append(pop);
                            }
                            stack.push(c); // 循环结束后，将当前运算符入栈
                        }
                    }
                }
                case '(' -> {
                    stack.push(c);
                }
                case ')' -> {
                    // 把操作符依次弹出，直到遇到左括号
                    while (!stack.isEmpty() && stack.peek() != '('){
                        Character pop = stack.pop();
                        stringBuilder.append(pop);
                    }
                    stack.pop(); // 移除左括号
                }
                // 如果是操作数（数字或变量），直接追加到输出
                default -> stringBuilder.append(c);
            }
        }
        // 遍历结束后，将栈中剩余运算符全部弹出并追加到输出
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        // 返回生成的后缀表达式字符串
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        InfixExpression infixExpression = new InfixExpression();
        System.out.println(infixExpression.infixExpression("1+2*3-4/5"));
        System.out.println(infixExpression.infixExpression("1+2*3-4/5*6"));
        System.out.println(infixExpression.infixExpression("1+2*3-4/5*6+7"));
        System.out.println(infixExpression.infixExpression("1+2*3-4/5*6+7-8"));

        System.out.println(infixExpression.infixExpression("1+2*3-4/5*6+7-8*(9+10)"));
    }
}