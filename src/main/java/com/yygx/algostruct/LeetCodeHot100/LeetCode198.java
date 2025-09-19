package com.yygx.algostruct.LeetCodeHot100;


/**
 * LeetCode198. 打家劫舍
 * <br/>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金。<br/>
 * 唯一的约束条件是相邻的房屋装有相互连通的防盗系统，<br/>
 * 如果同一晚上闯入了相邻的两间房屋，系统会自动报警。<br/>
 * 给定一个代表每个房屋存放金额的非负整数数组，<br/>
 * 计算在不触动警报装置的情况下，一夜之内能够偷窃到的最高金额。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：[1,2,3,1]<br/>
 * 输出：4<br/>
 * 解释：偷窃 1 号房屋(金额 = 1)，再偷窃 3 号房屋(金额 = 3)，总金额 = 4。<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：[2,7,9,3,1]<br/>
 * 输出：12<br/>
 * 解释：偷窃 1 号房屋(金额 = 2)，再偷窃 3 号房屋(金额 = 9)，再偷窃 5 号房屋(金额 = 1)，总金额 = 12。<br/>
 */
public class LeetCode198 {

    public int rob(int[] nums) {
        // 特殊情况，数组为空 直接返回0
        if(nums == null || nums.length == 0) return 0;
        // 特殊情况，只有一个房子时，直接返回该房子金额
        if(nums.length == 1) return nums[0];
        // twoAgo 表示偷到前前一个房子时的最大金额
        int twoAgo = nums[0];
        // oneAgo 表示偷到前一个房子时的最大金额
        int oneAgo = Math.max(nums[0],nums[1]);

        // 从第三个房子开始遍历
        for (int i = 2; i < nums.length; i++) {
            // 临时保存 oneAgo,用于更新 twoAgo
            int temp = oneAgo;
            // 状态流传，要么偷当前 房子+twoAgo，要么不偷当前房子，取两者最大值
            oneAgo = Math.max(twoAgo + nums[i],oneAgo);
            twoAgo = temp;
        }
        // oneAgo保存了偷到最后一个房子时的最大金额
        return oneAgo;
    }


}