package com.yygx.algostruct.LeetCodeHot100;

/**
 * 9.回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        // 负数不是回文数
        if(x < 0){
            return false;
        }
        // 反转回文数
        int current = 0;
        int num = x;
        while (num!=0){
            current = current* 10 + num % 10;
            num /= 10;
        }
        return current == x;
    }


    public boolean isPalindrome2(int x){
        // 负数不是回文数
        if(x< 0) return false;
        String reverse = String.valueOf(new StringBuilder(String.valueOf(x)).reverse());
        return reverse.equals(String.valueOf(x));
    }




    public static void main(String[] args) {
        LeetCode9 leetCode9 = new LeetCode9();
        System.out.println(leetCode9.isPalindrome(121));
        System.out.println(leetCode9.isPalindrome(1221));
        System.out.println(leetCode9.isPalindrome(123));
        System.out.println(leetCode9.isPalindrome(-121));
        System.out.println(leetCode9.isPalindrome(10));
        System.out.println(leetCode9.isPalindrome2(1233333321));
    }
}