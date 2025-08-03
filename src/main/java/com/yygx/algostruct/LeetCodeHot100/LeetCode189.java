package com.yygx.algostruct.LeetCodeHot100;


import java.util.Arrays;

/**
 * LeetCode189. 轮转数组
 * <br>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3<br/>
 * 输出: [5,6,7,1,2,3,4]<br/>
 * 解释:<br/>
 * 向右轮转 1 步: [7,1,2,3,4,5,6]<br/>
 * 向右轮转 2 步: [6,7,1,2,3,4,5]<br/>
 * 向右轮转 3 步: [5,6,7,1,2,3,4]<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：nums = [-1,-100,3,99], k = 2<br/>
 * 输出：[3,99,-1,-100]<br/>
 * 解释:<br/>
 * 向右轮转 1 步: [99,-1,-100,3]<br/>
 * 向右轮转 2 步: [3,99,-1,-100]<br/>
 */

public class LeetCode189 {


    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) return;
        // 先记录数组中的前k个元素，把k个元素之后的元素向前移动，把前k个元素赋值给后面元素
        if(k >= nums.length) k = k % nums.length;
        int[] knum = new int[k];
        System.arraycopy(nums, nums.length - k, knum, 0, k);
        int index = nums.length - k - 1;
        for (int length = nums.length - 1; length >= k; length--) {
            nums[length] = nums[index];
            index--;
        }
        System.arraycopy(knum, 0, nums, 0, k);
    }







    public void rotateTest(int[] nums, int k) {
        if (nums == null || nums.length == 1) return;
        if (k >= nums.length) k %= nums.length;
        int[] knum = new int[k];
        System.arraycopy(nums,nums.length - k,knum,0,k);
        int index = nums.length - k - 1;
        for(int current = nums.length - 1;current >= k;current--){
            nums[current] = nums[index];
            index--;
        }
        System.arraycopy(knum,0,nums,0,k);
    }







    public static void main(String[] args) {
        // [4,5,6,7,1,2,3]
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        LeetCode189 leetCode189 = new LeetCode189();
        leetCode189.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

}