package com.yygx.algostruct.leetcode;


/**
 * LeetCode268.丢失的数字
 * <P>
 *     给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * </P>
 */
public class LeetCode268 {


    public int missingNumber(int[] nums) {
        byte[] tmp = new byte[nums.length+1];
        for (int num : nums) {
            tmp[num] = 1;
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if(tmp[i] == 0){
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        LeetCode268 leetCode268 = new LeetCode268();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(leetCode268.missingNumber(nums));
    }
}