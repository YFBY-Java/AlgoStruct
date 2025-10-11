package com.yygx.algostruct.written.meituan;


import java.util.Scanner;

// 美团笔试
public class MeiTuan {

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(4);
        System.out.println(2);
    }

    // 大写迁移
    private static void uppercaseMigration() {
        Scanner in = new Scanner(System.in);
        String lenStr = in.nextLine();
        int len = Integer.parseInt(lenStr);
        String str = in.nextLine();
        char[] charArray = str.toCharArray();
        int x = 1;
        for (int i = 0; i < len; i++) {
            if (i + x >= len) {
                break;
            }
            char c1 = charArray[i+x];
            char c2 = charArray[i];
            if (Character.isUpperCase(c1)) {
                charArray[i + x] = Character.toLowerCase(c1);
                if (Character.isLowerCase(c2)) {
                    charArray[i] = Character.toUpperCase(c2);
                }
                x++;
            }
        }
        System.out.println(String.valueOf(charArray));
    }


}