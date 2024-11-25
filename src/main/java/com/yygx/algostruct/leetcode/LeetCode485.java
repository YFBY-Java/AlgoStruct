package com.yygx.algostruct.leetcode;


/**
 * LeetCoed485.最大连续1的个数
 */
public class LeetCode485 {



    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if(num == 1) {
                count++;
            }else {
                maxCount = Math.max(maxCount,count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount,count);
        return maxCount;
    }
}