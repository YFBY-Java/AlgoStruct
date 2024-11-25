package com.yygx.algostruct.leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode217.存在重复元素
 */
public class LeetCode217 {


    /**
     * 排序法
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1) return false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) return true;
        }
        return false;
    }


    /**
     * 哈希法
     * @param nums
     * @return
     */
    public boolean containsDuplicateHash(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)) return true;
        }
        return false;
    }


}