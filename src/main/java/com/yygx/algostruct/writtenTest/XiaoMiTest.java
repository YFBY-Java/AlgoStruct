package com.yygx.algostruct.writtenTest;


//  小米笔试准备
public class XiaoMiTest {


    /**
     * LeetCode334. 递增的三元子序列
     * <br/>
     * 给你一个整数数组 nums，判断这个数组中是否存在长度为 3 的递增子序列。<br/>
     * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，<br/>
     * 返回 true；否则，返回 false。<br/>
     * <br/>
     * 示例 1：<br/>
     * 输入：nums = [1,2,3,4,5]<br/>
     * 输出：true<br/>
     * 解释：任何 i < j < k 的三元组都满足题意。<br/>
     * <br/>
     * 示例 2：<br/>
     * 输入：nums = [5,4,3,2,1]<br/>
     * 输出：false<br/>
     * 解释：不存在满足题意的三元组。<br/>
     * <br/>
     * 示例 3：<br/>
     * 输入：nums = [2,1,5,0,4,6]<br/>
     * 输出：true<br/>
     * 解释：其中一个满足题意的三元组是 (3, 4, 5)，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6。<br/>
     */
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int a = Integer.MAX_VALUE;
        int b = a;
        for (int num : nums) {
            if(num <= a) a = num;
            else if(num <= b) b = num;
            else return true;
        }
        return false;
    }


    public static void main(String[] args) {
        XiaoMiTest xiaoMiTest = new XiaoMiTest();
        System.out.println(xiaoMiTest.increasingTriplet(new int[]{2,1,4,3,5}));
    }




}