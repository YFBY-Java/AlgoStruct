package com.yygx.algostruct.leetcode;


import java.util.Arrays;

/**
 * 121.买股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class LeetCode121 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int max = 0;
        if(length < 2){
            return 0;
        }
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(prices[i] - min,max);
            min = Math.min(prices[i],min);
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int low = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices){
            low = Math.min(low, price);
            max = Math.max(max, price-low);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        LeetCode121 leetCode121 = new LeetCode121();
        System.out.println(leetCode121.maxProfit(prices));
    }

}