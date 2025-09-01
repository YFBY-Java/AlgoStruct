package com.yygx.algostruct.leetcode;


import org.junit.Test;

import java.util.Arrays;

/**
 * LeetCode. 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回数组 answer，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。<br/>
 * <br/>
 * 题目数据保证数组 nums 之中任意元素的全部前缀元素和后缀的乘积都在 32 位整数范围内。<br/>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入: nums = [1,2,3,4]<br/>
 * 输出: [24,12,8,6]<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入: nums = [-1,1,0,-3,3]<br/>
 * 输出: [0,0,9,0,0]<br/>
 */

public class LeetCode238 {

    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        pre[0] = post[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            pre[i + 1] = pre[i] * nums[i];
        }
        for (int i = nums.length - 1,j = 0; i > 0; i--,j++) {
            post[j + 1] = post[j] * nums[i];
        }
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = pre[i] * post[ nums.length - 1 - i];
        }
        return answer;
    }



    public int[] productExceptSelfPro(int[] nums) {
        // 结果数组（结果数组先作为左数组），和右数组
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            left[i + 1] = left[i] * nums[i];
        }
        for (int length = nums.length - 2; length >= 0; length--) {
            right[length] = right[length + 1] * nums[length + 1];
            left[length] = left[length] * right[length];
        }
        return left;
    }



        public static void main(String[] args) {
        LeetCode238 leetCode238 = new LeetCode238();
//        System.out.println(Arrays.toString(leetCode238.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(leetCode238.productExceptSelfPro(new int[]{1, 2, 3, 4})));
    }

}