package com.yygx.algostruct.leetcode;


import java.util.Arrays;

/**
 * LeetCode414.第三大的数
 * <P>
 *     给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * </P>
 */
public class LeetCode414 {


    public int thirdMax(int[] nums) {
        // 将数组排序
        Arrays.sort(nums);
        // 去除重复的数
        int count = 1; // 用来计数唯一数的个数
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                count++;
            }
            if (count == 3) {
                return nums[i];
            }
        }
        // 如果没有第三大的数，返回最大的数
        return nums[nums.length - 1];
    }

}