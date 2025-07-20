package com.yygx.algostruct.LeetCodeHot100;

/**
 * LeetCode13
 * 将罗马数字字符串转换为整数<br/>
 * <br/>
 * 罗马数字包含字符：I、V、X、L、C、D、M，分别代表 1、5、10、50、100、500、1000。<br/>
 * <br/>
 * 特殊规则（小值在大值左边表示减法）包括：<br/>
 * - I 可在 V 和 X 左边：IV = 4, IX = 9<br/>
 * - X 可在 L 和 C 左边：XL = 40, XC = 90<br/>
 * - C 可在 D 和 M 左边：CD = 400, CM = 900<br/>
 * <br/>
 * 其余情况下按从左至右累加数值。<br/>
 * <br/>
 * 示例：<br/>
 * "III" -> 3<br/>
 * "IV" -> 4<br/>
 * "IX" -> 9<br/>
 * "LVIII" -> 58 （50 + 5 + 1 + 1 + 1）<br/>
 * "MCMXCIV" -> 1994 （1000 + 900 + 90 + 4）<br/>
 *
 * @param
 * @return 转换后的整数值
 */

public class LeetCode13 {

    public int romanToInt(String s) {
        int sum = 0;
        // 拿到第一个字符的值
        int pre = getValue(s.charAt(0));  //记录前一个数的值
        for (int i = 1;i<s.length();i++){
            int value = getValue(s.charAt(i));    // 拿到当前数的值
            if(value > pre){    // 当前数比前一个数大  减去前一个数
                sum -= pre;
            }else {
                sum += pre;    // 当前数比前一个数小 加上前一个数
            }
            pre = value;   // 更新前一个数
        }
        return sum + pre;   // 加上最后一位数
    }


    private int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

}