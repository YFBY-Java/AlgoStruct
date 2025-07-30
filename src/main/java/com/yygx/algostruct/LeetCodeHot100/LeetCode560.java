package com.yygx.algostruct.LeetCodeHot100;


import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k，请你统计并返回该数组中和为 k 的子数组的个数。<br/>
 * 子数组是数组中元素的连续非空序列。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：nums = [1,1,1], k = 2<br/>
 * 输出：2<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：nums = [1,2,3], k = 3<br/>
 * 输出：2<br/>
 */

public class LeetCode560 {


    public int subarraySum(int[] nums, int k) {
        int sunNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) sunNum++;
            }
        }
        return sunNum;
    }



    public int subarraySumPro(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        // 使用 HashMap 存储前缀和出现的次数
        // 键是前缀和，值是该前缀和出现的次数
        Map<Integer, Integer> sumCount = new HashMap<>();
        // 初始化，表示前缀和为 0 的情况出现了一次（空的前缀）
        sumCount.put(0, 1);

        for (int num : nums) {
            sum += num; // 计算当前前缀和
            // 如果 (sum - k) 存在于哈希表中，
            // 说明从某个位置到当前位置的和为 k
            if (sumCount.containsKey(sum - k)) {
                count += sumCount.get(sum - k);
            }
            // 将当前前缀和加入哈希表，或更新其出现次数
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }






    // 前缀和
    public int subarraySumTest(int[] nums, int k) {
        // 初始化一个map 用来存放前缀和
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;  // 当前总和
        int count = 0; // 和为k的次数
        for (int num : nums) {
            sum += num;   // 计算总和
            // 如果前缀和中存在 一个数，这个数+k = sum
            // 那么说明  这个数出现的次数，即为到当前为止 和为k的 字串的个数
            count += map.getOrDefault(sum - k,0);
            // 将当前 总和 放入 前缀和map
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }






    public static void main(String[] args) {
        // [1,-1,0]
        int[] nums = {1, -1, 0};
        LeetCode560 leetCode560 = new LeetCode560();
        System.out.println("结果: " + leetCode560.subarraySum(nums, 0));
    }


}
