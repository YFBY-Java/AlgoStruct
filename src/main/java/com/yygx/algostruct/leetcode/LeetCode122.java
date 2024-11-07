package com.yygx.algostruct.leetcode;


/**
 * LeetCode.122 买股票的最佳时间||
 * <p>
 *     给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润
 * </p>
 */
public class LeetCode122 {

    private int res;

    public int maxProfitRecursion(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        this.res = 0;
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    /**
     * 递归深度搜索
     * @param prices 数组
     * @param index 当前索引
     * @param len 总长度
     * @param status 0表示未持有股票，1表示持有股票
     * @param profit 利润
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {
        if(index == len){
            this.res = Math.max(this.res,profit);
            return;
        }
        dfs(prices,index+1,len,status,profit);
        if(status == 0){
            // 可以尝试转向1
            dfs(prices,index+1,len,1,profit-prices[index]);
        }else {
            // 此时status == 1，可以尝试转向0
            dfs(prices,index+1,len,0,profit+prices[index]);
        }
    }



    public int maxProfitDP(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        // dp[i][0] 表示第i天不持有股票的最大利润
        // dp[i][1] 表示第i天持有股票的最大利润
        int[][] dp = new int[len][2];

        // 初始状态
        dp[0][0] = 0;   // 第一天不持有股票，利润为0
        dp[0][1] = -prices[0];   // 第一天持有股票，利润为 -股票价格 （买股票花的钱）

        for (int i = 1; i < len; i++) {
            // 0为不持有股票，1为持有股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);   // 比较 前一天不持有股票的利润 和 昨天持有股票今天卖出的利润 最大的为今天不持有股票的利润
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);   // 比较 昨天持有股票，今天不卖出 和 昨天不持有今天买入的利润    最大值为持有股票的利润
        }
        // 最后一天不持有股票的最大利润就是答案
        return dp[len - 1][0];
    }



    public int maxProfitDpPro(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        int dp0 = 0;
        int dp1 = -prices[0];

        // 状态转移
        for (int i = 1; i < len; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0,dp1+prices[i]);
            dp1 = Math.max(dp1,temp-prices[i]);
        }
        return dp0;
    }



    public int maxProfitGreedy(int[] prices) {
        int sum = 0;   // 累计的最大利润
        int current = prices[0];
        for (int price : prices) {
            // 如果当前价格高于昨天的价格就卖出
            if (price > current) {
                sum += price - current;   // 计算利润
            }
            current = price;   // 更新当前的价格
        }
        return sum;  // 返回最大利润
    }




    public static void main(String[] args) {
/*        LeetCode122 leetCode122 = new LeetCode122();
        int[] prices = {7,1,5,3,6,4};
        int res = leetCode122.maxProfitDP(prices);
        System.out.println(res);*/

/*        LeetCode122 leetCode122 = new LeetCode122();
        int[] prices = {7,1,5,3,6,4};
        int res = leetCode122.maxProfitDpPro(prices);
        System.out.println(res);*/

        LeetCode122 leetCode122 = new LeetCode122();
        int[] prices = {7,1,5,3,6,4};
        int res = leetCode122.maxProfitGreedy(prices);
        System.out.println(res);
    }


}