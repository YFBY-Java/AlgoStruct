package com.yygx.algostruct.writtenTest;

// 米哈游笔试准备
public class MihoyoTest {

    /**
     * 字符串整体移动替换
     * <p>
     * 题意：给定一个长度为 n 的字符串 s，从左到右依次处理每个字符：
     * 1. 如果是大写字母 (A-Z)，则替换为字母表中的下一个字母，Z 替换为 A。
     * 2. 如果是小写字母 (a-z)，则替换为字母表中的上一个字母，a 替换为 z。
     * 3. 如果是数字字符 (0-9)，则替换为该数字加 1，9 替换为 0。
     * 4. 如果是其他字符，则替换为下划线 "_"。
     */
    public static String transform(String s) {
        // 用StringBuilder存储
        StringBuilder stringBuilder = new StringBuilder();
        // 处理字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                if (c == 'Z'){
                    stringBuilder.append('Z');
                }else {
                    stringBuilder.append((char) (c+1));
                }
            }else if(c >= 'a' && c <= 'z'){
                if(c == 'a'){
                    stringBuilder.append('z');
                }else {
                    stringBuilder.append((char)(c - 1));
                }
            }else if(c >= '0' && c <= '9'){
                if(c == '9'){
                    stringBuilder.append('0');
                }else {
                    stringBuilder.append((char) (c+1));
                }
            }else {
                stringBuilder.append('_');
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(transform("Ab1!"));
        System.out.println(transform("Z1a2b3c4d5e6f7g8h9i0j"));
    }


}