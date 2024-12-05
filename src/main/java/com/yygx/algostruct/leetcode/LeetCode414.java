package com.yygx.algostruct.leetcode;


import java.nio.file.LinkOption;
import java.util.Arrays;

/**
 * LeetCode414.第三大的数
 * <p>
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * </P>
 */
public class LeetCode414 {


    public int thirdMax(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int count = 1;   // 用来计数（不同元素个数）
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                count++;
            }
            if (count == 3) {
                return nums[i];
            }
        }
        // 如果没有第三大的数。返回最大的数
        return nums[nums.length - 1];
    }


    public int thirdMaxPro(int[] nums) {
        long max1 = (long) Integer.MIN_VALUE - 1;
        long max2 =  max1;
        long max3 = max2;
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == Integer.MIN_VALUE){
                a = 1;
            }
            if(nums[i] >= max1){
                if(nums[i] == max1){
                    continue;
                }
                // 向下移动最小的
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] >= max2){
                if(nums[i] == max2){
                    continue;
                }
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] >= max3){
                max3 = nums[i];
            }
        }
        return max3 > (long) Integer.MIN_VALUE-1 ? (int)max3:(int) max1;
    }

}