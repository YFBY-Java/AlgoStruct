package com.yygx.algostruct.LeetCodeHot100;


/**
 * LeetCode53. 最大子数组和
 * <br>
 * 给你一个整数数组 nums，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。<br/>
 * 子数组是数组中的一个连续部分。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]<br/>
 * 输出：6<br/>
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：nums = [1]<br/>
 * 输出：1<br/>
 * <br/>
 * 示例 3：<br/>
 * 输入：nums = [5,4,-1,7,8]<br/>
 * 输出：23<br/>
 */

public class LeetCode53 {



    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0;i < nums.length;i++){
            int sum = 0;
            for(int j = i;j<nums.length;j++){
                sum += nums[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }




}
