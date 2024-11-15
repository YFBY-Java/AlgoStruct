package com.yygx.algostruct.leetcode;


/**
 * LeetCode191.位1的个数
 * 给定一个正整数 n，编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中
 * 设置位
 *  的个数（也被称为汉明重量）。
 */
public class LeetCode191 {

    public int hammingWeight(int n) {
        int res = 0;
        while (n > 0){
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }


    /**
     * 优化
     * @param n
     * @return
     */
    public int hammingWeightPro(int n) {
        int res = 0;
        while (n>0){
            res++;
            n &= (n-1);
        }
        return res;
    }


    // 十进制转二进制
    public static String decimalToBinary(int decimal) {
        String binary = "";
        while (decimal > 0) {
            binary = decimal % 2 + binary;
            decimal = decimal / 2;
        }
        return binary;
    }


    public static void main(String[] args) {
        int n = 11;
        System.out.println(decimalToBinary(n));
        LeetCode191 leetCode191 = new LeetCode191();
        System.out.println(leetCode191.hammingWeight(n));
        System.out.println(leetCode191.hammingWeightPro(n));

    }
}