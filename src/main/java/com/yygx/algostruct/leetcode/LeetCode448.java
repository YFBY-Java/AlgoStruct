package com.yygx.algostruct.leetcode;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * LeetCode448.找到所有数组中消失的数字
 * <p>
 *     给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * </p>
 */
public class LeetCode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] tmp = new boolean[nums.length+1];
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            tmp[num] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!tmp[i]){
                list.add(i);
            }
        }
        return list;
    }
}