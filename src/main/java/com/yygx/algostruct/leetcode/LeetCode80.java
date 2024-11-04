package com.yygx.algostruct.leetcode;


/**
 * LeetCode80.删除有序数组中的重复项
 *
 * <P>
 *     给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * </P>
 */
public class LeetCode80 {



    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return n;
        }
        int left = 2, right = 2;
        while (right < n){
            if(nums[left-2] != nums[right]){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}