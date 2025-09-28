package com.yygx.algostruct.written.diezhi;


import java.util.Scanner;

// 叠纸笔试
public class DieZhi {

    public static void main(String[] args) {
        System.out.println();
    }



    private static void palindrome() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        // 去除非字母数字
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)){
                stringBuilder.append(Character.toLowerCase(c));
            }
        }
        // 2.转小写后直接比较
        String string = stringBuilder.toString();
        String rev = stringBuilder.reverse().toString();
        System.out.println(string.equals(rev));
    }




}