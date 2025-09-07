package com.yygx.algostruct.algorithm.dualpointers;


// 回文串
public class Palindrome {

    // 双指针法
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 字符串反转法
    public static boolean isPalindromeTest(String s){
//        return new StringBuilder(s).reverse().toString().equals(s);
        return new StringBuilder(s).reverse().toString().equals(s);

    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abcd"));
    }

}