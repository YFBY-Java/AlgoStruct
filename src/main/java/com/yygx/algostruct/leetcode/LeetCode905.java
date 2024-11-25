package com.yygx.algostruct.leetcode;


/**
 * LeetCode905.按奇偶排序数组
 * <p>
 *     给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 *
 * 返回满足此条件的 任一数组 作为答案。
 * </p>
 */
public class LeetCode905 {


    /**
     * 双指针法
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        int even = 0;
        int odd = nums.length-1;
        int[] array = new int[nums.length];
        for (int num : nums) {
            if(num % 2 == 0){
                array[even++] = num;
            }else {
                array[odd--] = num;
            }
        }
        return array;
    }
}