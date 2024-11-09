package com.yygx.algostruct.leetcode;


import java.util.Arrays;

/**
 * LeetCode45.跳跃游戏
 */
public class LeetCode45 {

    public int jump(int[] nums) {

        int jumpTimes = 0;   // 跳跃次数
        int start = 0;   // 起跳位置
        int end = 1;   // 下一次跳跃在第几个点跳跃

        while (end < nums.length){
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                // 能跳到的最远的距离
                maxPos = Math.max(maxPos,i+nums[i]);
            }
            start = end;  // 下一次起跳点范围开始的格子
            end = maxPos + 1;   // 下次起跳范围结束的格子
            jumpTimes++;  // 跳跃次数
        }
        return jumpTimes;
    }


    public int jump2(int[] nums) {
        int jumpTimes = 0;  // 跳跃次数
        int end = 0;  // 当前跳跃的最远边界
        int maxPos = 0;  // 当前能跳到的最远位置
        // 遍历数组，找到最少跳跃次数
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新当前索引处能跳到的最远位置
            maxPos = Math.max(nums[i] + i, maxPos);
            // 如果到达了当前跳跃边界
            if (i == end) {
                // 更新跳跃边界
                end = maxPos;
                // 增加跳跃次数
                jumpTimes++;
            }
        }
        return jumpTimes;
    }

}