package com.yygx.algostruct.leetcode;


/**
 * LeetCode263.丑数
 * <p>
 *     丑数 就是只包含质因数 2、3 和 5 的 正 整数。
 *
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * </p>
 */
public class LeetCode263 {

    public boolean isUgly(int n){
        if(n <= 0) return false;
        int[] factors = {2,3,5};
        for (int factor : factors) {
            while (n % factor == 0){
                n /= factor;
            }
        }
        return n == 1;
    }


    public static void main(String[] args) {
        LeetCode263 leetCode263 = new LeetCode263();
        for (int i = 0; i < 100; i++) {
            System.out.println(i + ": " +leetCode263.isUgly(i));
        }
    }

}