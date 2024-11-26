package com.yygx.algostruct.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode1.两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * <p>
 * 你可以按任意顺序返回答案。
 * </p>
 */
public class LeetCode1 {


    /**
     * 暴力
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    /**
     * 哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[0];
    }


    public int[] twoSumHashPro(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        int n = nums.length;
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            int difference = target - nums[i];
            if (nums[i] + nums[j] == target && i != j) {
                return new int[]{i, j};
            }
            if (hash.get(difference) != null) {
                return new int[]{hash.get(difference), i};
            }
            difference = target - nums[i];
            if (hash.get(difference) != null) {
                return new int[]{hash.get(difference), j};
            }
            hash.put(nums[i], i);
            hash.put(nums[j], j);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        LeetCode1 leetCode1 = new LeetCode1();
//        int[] result = leetCode1.twoSum(nums, target);
        int[] result = leetCode1.twoSumHash(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

}