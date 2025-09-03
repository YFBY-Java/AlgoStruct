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
        Stack<String> stack = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();
        // 定义一个 num 表示当前的数字，定义一个 StringBuilder用来记录当前的字符串
        int num = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                stackNum.push(num);
                stack.push(String.valueOf(c));
                // 重置
                num = 0;
                stringBuilder = new StringBuilder();
            } else if (c == ']') {
                while (!"[".equals(stack.peek())) {
                    String pop = stack.pop();
                    stringBuilder.insert(0, pop);
                }
                int popNum = stackNum.pop();
                stack.pop();
                String repeat = stringBuilder.toString().repeat(popNum);
                stack.push(repeat);
                stringBuilder = new StringBuilder();
            } else {
                stack.push(String.valueOf(c));
            }
        }
        if (stackNum.isEmpty()) {
            while (!stack.isEmpty()) {
                String pop = stack.pop();
                stringBuilder.insert(0, pop);
            }
            return String.valueOf(stringBuilder);
        } else {
            return stack.pop().repeat(stackNum.pop());
        }
    }


    public static void main(String[] args) {
        LeetCode394 leetCode394 = new LeetCode394();
//        System.out.println(leetCode394.decodeString("3[a2[c]]"));
        System.out.println(leetCode394.decodeStringTest("3[a]2[bc]"));
    }


}