package com.yygx.algostruct.leetcode;


import cn.hutool.core.annotation.AnnotationUtil;

import java.util.Arrays;

/**
 * LeetCode75. 颜色分类
 * <br/>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。<br/>
 * <br/>
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。<br/>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：nums = [2,0,2,1,1,0]<br/>
 * 输出：[0,0,1,1,2,2]<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：nums = [2,0,1]<br/>
 * 输出：[0,1,2]<br/>
 */
public class LeetCode75 {

    public void sortColors(int[] nums) {
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[point];
                nums[point] = temp;
                point++;
            }
        }
        for (int i = point;i<nums.length;i++){
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[point];
                nums[point] = temp;
                point++;
            }
        }
    }


    public static void main(String[] args) {
        LeetCode75 leetCode75 = new LeetCode75();
//        int[] nums = {2, 0, 2, 1, 1, 0};
//        int[] nums = {0,1};
        // [1,2,0]
        int[] nums = {1, 2, 0};
        leetCode75.sortColors(nums);

    }


}