package com.yygx.algostruct.datastructure.stack;

import com.yygx.algostruct.leetcode.LeetCode20;

public class LeetCode20Test {
    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();
        System.out.println(leetCode20.isValid("()"));
        System.out.println(leetCode20.isValid("()[]{}"));
        System.out.println(leetCode20.isValid("(]"));
        System.out.println(leetCode20.isValid("([)]"));
        System.out.println(leetCode20.isValid("{[]}"));
        System.out.println(leetCode20.isValid("{"));
        System.out.println(leetCode20.isValid("}"));
        System.out.println(leetCode20.isValid("["));
    }
}