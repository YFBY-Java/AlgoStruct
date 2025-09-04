package com.yygx.algostruct.leetcode;


import java.util.Stack;

/**
 * LeetCode394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。<br/>
 * <br/>
 * 编码规则：k[encoded_string] 表示其中方括号内部的 encoded_string 正好重复 k 次。<br/>
 * k 保证为正整数。<br/>
 * 输入字符串总是有效；没有多余空格，且方括号格式正确。<br/>
 * 原始数据不包含数字，所有数字只表示重复次数 k。<br/>
 * 测试用例保证输出长度不会超过 10^5。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入："3[a]2[bc]"<br/>
 * 输出："aaabcbc"<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入："3[a2[c]]"<br/>
 * 输出："accaccacc"<br/>
 * <br/>
 * 示例 3：<br/>
 * 输入："2[abc]3[cd]ef"<br/>
 * 输出："abcabccdcdcdef"<br/>
 */
public class LeetCode394 {

    public String decodeString(String s) {
        // 用于存储重复次数
        Stack<Integer> numStack = new Stack<>();
        // 用于存储字符串片段
        Stack<StringBuilder> strStack = new Stack<>();
        // 用于构建当前层级的字符串
        StringBuilder currentString = new StringBuilder();
        // 用于累加数字
        int k = 0;

        // 遍历输入的字符串
        for (char ch : s.toCharArray()) {
            // 如果是数字
            if (Character.isDigit(ch)) {
                // 累加数字，处理多位数
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // 如果是左方括号
                // 将当前数字入栈
                numStack.push(k);
                // 将当前字符串入栈
                strStack.push(currentString);
                // 重置，开始处理新层级的字符串
                currentString = new StringBuilder();
                // 重置数字
                k = 0;
            } else if (ch == ']') {
                // 如果是右方括号
                // 弹出重复次数
                int repeatTimes = numStack.pop();
                // 弹出上一层级的字符串
                StringBuilder prevString = strStack.pop();
                // 循环指定次数
                for (int i = 0; i < repeatTimes; i++) {
                    // 将当前字符串追加到上一层级的字符串
                    prevString.append(currentString);
                }
                // 更新当前字符串为拼接后的结果
                currentString = prevString;
            } else {
                // 如果是字母
                // 将字母追加到当前字符串
                currentString.append(ch);
            }
        }
        // 返回最终解码的字符串
        return currentString.toString();
    }


    // 3[a2[c]]
    public String decodeStringTest(String s) {
        // 双栈法， 一个计数栈，一个字符栈
        Stack<String> stack = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();
        // 定义一个 num 表示当前的数字，定义一个 StringBuilder用来记录当前的字符串
        int num = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');    // 计算当前数字
            } else if (c == '[') {   // 一个数字对应一个左括号，遇到左括号时数字入栈
                stackNum.push(num);  // 数字入栈
                stack.push(String.valueOf(c));   // 括号入栈
                num = 0;  // // 重置数字
            } else if (c == ']') {   // 遇到右括号时把字符出栈组合，并把数字出栈一个，进行重复
                while (!"[".equals(stack.peek())) {   // 不是左括号说明还有 字符
                    String pop = stack.pop();
                    stringBuilder.insert(0, pop);   // StringBuilder的 insert方法，从索引0的位置插入
                }
                int popNum = stackNum.pop();   // 出栈已经用过的数字
                stack.pop();  // 弹出左括号
                // String 的 repeat 方法，把字符串重复 n 次
                String repeat = stringBuilder.toString().repeat(popNum);
                stack.push(repeat); // 把重复后的字符串放回栈中
                stringBuilder = new StringBuilder();  // 重置 用来组合的 StringBuilder对象
            } else {
                stack.push(String.valueOf(c));  // 字母直接入栈
            }
        }
        if (stackNum.isEmpty()) {  // 数字栈空 说明 不是 2[2a[2a]] 的结构，而是 2[a]2[a]的结构
            while (!stack.isEmpty()) {   // 2[a]2[a]的结构  最后在字符栈中会有多个元素，需要遍历
                String pop = stack.pop();
                stringBuilder.insert(0, pop);  // 依次出栈进行拼接
            }
            return String.valueOf(stringBuilder);
        } else {
            // 数字栈有元素，说明是 2[2a[2a]] 的结构，直接弹出两个栈元素进行重复
            return stack.pop().repeat(stackNum.pop());
        }
    }


    public String decodeStringTest2(String s) {
        //双栈法，数字栈和字母栈
        Stack<String> stackStr = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();
        // 定义用来暂存字母组合
        StringBuilder stringBuilder = new StringBuilder();
        int num = 0; // 暂存数字
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (Character.isDigit(c)) {  // 数字直接进行拼接
                num = num * 10 + (c - '0');
            } else if ('[' == c) {
                stackNum.push(num);  // 一个数字对应一个左括号，所以可以用左括号来分隔数字
                stackStr.push(String.valueOf(c));
                num = 0; // 重置 num
            } else if (']' == c) {
                while (!"[".equals(stackStr.peek())) {
                    stringBuilder.insert(0, stackStr.pop());
                }
                stackStr.pop();   // 左括号出栈
                stackStr.push(stringBuilder.toString().repeat(stackNum.pop()));
                stringBuilder = new StringBuilder();
            } else {   // 字母直接入栈
                stackStr.push(String.valueOf(c));
            }
        }
        if (stackNum.isEmpty()) {
            while (!stackStr.isEmpty()) {
                stringBuilder.insert(0, stackStr.pop());
            }
            return stringBuilder.toString();
        }
        return stackStr.pop().repeat(stackNum.pop());
    }


    public static void main(String[] args) {
        LeetCode394 leetCode394 = new LeetCode394();
//        System.out.println(leetCode394.decodeString("3[a2[c]]"));
        System.out.println(leetCode394.decodeStringTest2("3[a]2[bc]"));
    }


}