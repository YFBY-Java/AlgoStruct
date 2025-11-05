package com.yygx.algostruct.written.huanxin;


import java.util.Scanner;

// 10.31 欢忻网络
public class HuanXin {


    // 回文子串
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j + i < s.length(); j++) {
                String substring = s.substring(i, i + j); 
                boolean palindrome = isPalindrome(substring);
                if (palindrome) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isPalindrome(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        String string = stringBuilder.reverse().toString();
        return str.equals(string);
    }

}