package com.yygx.algostruct.leetcode;

import java.util.Arrays;

/**
 * 9.回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        // 如果 x 是负数，则不可能是回文数，直接返回 false
        if (x < 0) {
            return false;
        }

        // 用于保存反转后的数字
        int current = 0;
        // 创建一个 num 变量以保留 x 的副本
        int num = x;

        // 逐位反转 num，直到所有位数处理完
        while (num != 0) {
            // 取 num 的最后一位，并添加到 current 的末尾
            current = current * 10 + num % 10;
            // 去掉 num 的最后一位
            num = num / 10;
        }

        // 如果反转后的数字与原始数字相等，则说明 x 是回文数
        return current == x;
    }




    public static void main(String[] args) {
        LeetCode9 leetCode9 = new LeetCode9();
        System.out.println(leetCode9.isPalindrome(121));
    }
}