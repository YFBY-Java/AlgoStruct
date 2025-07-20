package com.yygx.algostruct.leetcode;


import com.yygx.algostruct.datastructure.stack.ArrayStack;
import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode20.有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * </P>
 */
public class LeetCode20 {


    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>(s.length());
        for (int i = 0; i < s.length() / 2 + 1; i++) {
            char c = s.charAt(i);
            // 遇到左括号，把对应的右括号放入栈
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            }
            // 遇到右括号，把它和栈顶元素对比
            // 相等弹出栈顶元素，继续对比下一项，不相等则为无效括号直接返回false
            else {
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }



    public boolean isValid2(String s) {
        // 定义一个栈,用来暂存左括号
        Stack<Character> stack = new Stack<>();
        // 转成字符串数组
        char[] array = s.toCharArray();
        // 定义一个map
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for (char c : array) {
            if (map.containsKey(c)){  // 存在键，说明当前括号为左括号
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                Character value = map.get(stack.pop());
                if(value != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}