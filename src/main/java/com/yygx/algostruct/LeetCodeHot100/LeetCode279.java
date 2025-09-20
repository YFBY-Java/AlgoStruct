package com.yygx.algostruct.LeetCodeHot100;


import java.util.ArrayList;

/**
 * LeetCode279. 完全平方数
 * <br/>
 * 给你一个整数 n，返回和为 n 的完全平方数的最少数量。<br/>
 * 完全平方数是一个整数，其值等于另一个整数的平方；例如 1、4、9、16 等。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：n = 12<br/>
 * 输出：3<br/>
 * 解释：12 = 4 + 4 + 4。<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：n = 13<br/>
 * 输出：2<br/>
 * 解释：13 = 4 + 9。<br/>
 */
public class LeetCode279 {


    public int numSquares(int n) {
        // dp[i] 表示组成整数i的最少完全平方数 的量
        int[] dp = new int[n + 1];
        // 初始化，除了 dp[0] = 0，其余先设为一个较大的值
        for (int i = 1; i <= n; i++) {
            dp[i] = i;  // 1也是完全平方数，最多 n个1
        }
        // 遍历每个目标数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // 状态转移，取最小值
                // 判断有没有使用目前最大的那个完全平方数，如果使用了，减去这个数
                // 获取 （当前数 - 当前最大平方数） 这个数用了几次 ，+1 （加的是当前最大平方数使用一次）
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode279 leetCode279 = new LeetCode279();
        System.out.println(leetCode279.numSquares(12));
    }


}