package com.yygx.algostruct.LeetCodeHot100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode15. 三数之和<br/>
 * 给你一个整数数组 nums，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k，同时还满足 nums[i] + nums[j] + nums[k] == 0。<br/>
 * 请你返回所有和为 0 且不重复的三元组。<br/>
 * <br/>
 * 注意：答案中不可以包含重复的三元组。<br/>
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        // 创建一个列表用于存储所有符合条件的三元组
        List<List<Integer>> result = new ArrayList<>();
        // 获取数组的长度
        int n = nums.length;

        // 暴力解法：三重循环遍历所有可能的三元组
        // 第一个元素的选择
        for (int i = 0; i < n; i++) {
            // 第二个元素的选择，确保j不等于i
            for (int j = 0; j < n; j++) {
                // 第三个元素的选择，确保k不等于i和j
                for (int k = 0; k < n; k++) {
                    // 判断三个索引是否互不相同
                    if (i != j && i != k && j != k) {
                        // 判断三个元素的和是否为0
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            // 创建一个临时列表来存储当前的三元组
                            List<Integer> triplet = new ArrayList<>();
                            triplet.add(nums[i]);
                            triplet.add(nums[j]);
                            triplet.add(nums[k]);
                            // 对三元组进行排序，以便于后续去重
                            // 例如，[-1, 0, 1] 和 [1, 0, -1] 排序后都是 [-1, 0, 1]，方便判断为重复
                            triplet.sort(null);

                            // 检查当前三元组是否已经存在于结果列表中，避免重复
                            if (!result.contains(triplet)) {
                                result.add(triplet);
                            }
                        }
                    }
                }
            }
        }
        // 返回所有符合条件且不重复的三元组
        return result;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();  // 用来存储结果
        int n = nums.length;
        // 1. 对数组进行排序
        Arrays.sort(nums);
        // 优化后的三重循环
        for (int i = 0; i < n - 2; i++) { // 确保至少还有两个元素在i后面
            // 优化：跳过重复的i元素，避免生成重复的三元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 1; j++) { // j从i的下一个位置开始
                // 优化：跳过重复的j元素
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) { // k从j的下一个位置开始
                    // 优化：跳过重复的k元素
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        result.add(triplet);
                    }
                }
            }
        }
        return result;
    }



    // 示例用法（可选，用于测试）
    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = leetCode15.threeSum(nums1);
        System.out.println("示例1结果: " + result1); // 预期输出：[[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {0, 1, 1};
        List<List<Integer>> result2 = leetCode15.threeSum(nums2);
        System.out.println("示例2结果: " + result2); // 预期输出：[]

        int[] nums3 = {0, 0, 0};
        List<List<Integer>> result3 = leetCode15.threeSum(nums3);
        System.out.println("示例3结果: " + result3); // 预期输出：[[0, 0, 0]]
    }

}
