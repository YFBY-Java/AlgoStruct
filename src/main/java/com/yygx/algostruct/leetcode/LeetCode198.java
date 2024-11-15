package com.yygx.algostruct.leetcode;


/**
 * LeetCode.198打家劫舍
 * <p>
 *     你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * </p>
 */
public class LeetCode198 {


    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length - 1];
    }


    /**
     * 动态规划，滚动数组优化
     * @param nums
     * @return
     */
    public int robPro(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int twoAgo = nums[0];
        int oneAgo = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // 记录前一家金额
            int temp = oneAgo;
            // 两家前的最大的金额+当前偷的金额  和  前一家不偷的金额   比较
            oneAgo = Math.max(twoAgo + nums[i],oneAgo);
            // 移动 两家前
            twoAgo = temp;
        }
        return oneAgo;
    }
}