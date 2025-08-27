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



    public int maxSubArrayPro(int[] nums) {
        // 定义一个 从某个元素到当前元素的前一个元素 的累加和，初始为0
        int pre = 0;
        // 定义最大的累加和
        int maxSub = nums[0];
        for (int num : nums) {
            // 判断当前元素是否比 前面几个元素+当前元素 都大
            // 如果大于前面几个累加和，说明前面几个累加起来是负数，不如从当前元素开始计算
            pre = Math.max(pre+num,num);
            maxSub = Math.max(maxSub,pre);
        }
        return maxSub;
    }



    public int maxSubArrayTest(int[] nums){
        // 定义一个 从某个元素到当前元素的前一个元素的累加和，初始为0
        int pre = 0;
        // 定义最大的累加和
        int maxSub = nums[0];
        for (int num : nums) {
            // 判断当前元素是否比 前面几个元素 + 当前元素  大
            // 如果大于前面几个累加和，说明前面几个累加起来是负数，不如从当前元素开始计算
            pre = Math.max(pre + num,num);
            maxSub = Math.max(maxSub,pre);  // 更新最大的连续子数组和
        }
        return  maxSub;
    }






}
