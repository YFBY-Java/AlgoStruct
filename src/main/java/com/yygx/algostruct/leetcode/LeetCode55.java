package com.yygx.algostruct.leetcode;


/**
 * LeetCode55.跳跃游戏
 * <p>
 *     给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * </p>
 */
public class LeetCode55 {

    public boolean canJump(int[] nums) {
        // 记录所能到达的最大的点
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > farthest) return false;   // 当前点比所能到达的远的点还大，直接返回错误
            farthest = Math.max(farthest,i+nums[i]);  // 比较 当前点之前的点能到达的最远的距离 和 当前点能到达的最远的位置
        }
        return true;
    }

    public boolean canJumpPro(int[] nums) {
        int farthest = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            farthest = Math.max(farthest,i+nums[i]);
            if(farthest > length) return true;
        }
        return false;
    }

}