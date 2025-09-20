package com.yygx.algostruct.LeetCodeHot100;


import java.util.Arrays;

/**
 * LeetCode322. 零钱兑换
 * <br/>
 * 给你一个整数数组 coins，表示不同面额的硬币；以及一个整数 amount，表示总金额。<br/>
 * 计算并返回可以凑成总金额所需的最少硬币个数。<br/>
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。<br/>
 * 假设每种硬币的数量是无限的。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：coins = [1,2,5], amount = 11<br/>
 * 输出：3<br/>
 * 解释：11 = 5 + 5 + 1。<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：coins = [2], amount = 3<br/>
 * 输出：-1<br/>
 * <br/>
 * 示例 3：<br/>
 * 输入：coins = [1], amount = 0<br/>
 * 输出：0<br/>
 */
public class LeetCode322 {


    public int coinChange(int[] coins, int amount) {
        // 初始化dp数组，dp[i]表示 金额 i 的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 遍历所有的 硬币面额
        for (int coin : coins) {
            // 对每个金额 i ,从 coin 到 amount(目标数额)  更新最少硬币数
            for (int i = coin; i <= amount; i++) {
                // dp[i - coin] 表示，使用了一次当前金额，去寻找减去当前硬币面额之后的 金额 最少需要多少硬币
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);  // +1 表示使用当前面额一次
            }
        }
        // 判断是否找到了可行组合，如果没有可行组合，返回 -1
        return dp[amount] > amount ? -1 : dp[amount];
    }


}