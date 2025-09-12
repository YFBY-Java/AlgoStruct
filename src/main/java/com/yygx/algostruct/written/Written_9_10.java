package com.yygx.algostruct.written;



public class Written_9_10 {


    // 判断是否回文
    public static void main(String[] args) {
//        String str = "121";
        String str = "iyghuitfikbfyt";
        isPalindrome(str);
        str = "aba";
        isPalindrome(str);
    }

    // 判断是否回文
    private static void isPalindrome(String str) {
        String stringBuilder = new StringBuilder(str).reverse().toString();
        System.out.println(stringBuilder.equals(str));
    }

    private static void strToInt() {
        String str = "1234";
        char[] charArray = str.toCharArray();
        int num = 0;
        for (char c : charArray) {
            num = num * 10 + c - '0';
        }
        System.out.println(num);
    }


}