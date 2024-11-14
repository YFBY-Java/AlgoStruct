package com.yygx.algostruct.leetcode;


/**
 * 力扣13.罗马数字转整数
 */
public class LeetCode13 {

    public int romanToInt(String s) {
        int sum = 0;  // 用于累加最终的整数值
        int preNum = getValue(s.charAt(0));  // 获取第一个字符的数值
        // 从第二个字符开始遍历
        for (int i = 1; i < s.length(); i++) {
            int value = getValue(s.charAt(i));  // 获取当前字符的数值
            // 如果前一个数值小于当前数值（例如 IV、IX 等情况）
            if (preNum < value) {
                sum -= preNum;  // 将前一个数值减去（如 IV 中的 I，需要减去 I）
            } else {
                sum += preNum;  // 否则，加上前一个数值
            }
            // 更新前一个数值为当前数值
            preNum = value;
        }
        // 最后加上最后一个字符的数值（因为循环中未处理最后一个字符）
        return sum + preNum;
    }


    private int getValue(char ch) {
        switch (ch) {
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }

    public static void main(String[] args) {
        LeetCode13 leetCode13 = new LeetCode13();
        System.out.println(leetCode13.romanToInt("MCMXCIV"));
    }
}