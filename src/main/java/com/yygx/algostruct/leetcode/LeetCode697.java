package com.yygx.algostruct.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode697.数组的度
 * <p>
 *     给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * </p>
 */
public class LeetCode697 {

    public int findShortestSubArray(int[] nums) {
        // 定义一个HashMap，键为数组中的元素，值为长度为3的数组
        // arr[0]：元素出现次数
        // arr[1]：元素第一次出现的位置
        // arr[2]：元素最后一次出现的位置
        HashMap<Integer, Integer[]> map = new HashMap<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果map中没有当前元素
            if (!map.containsKey(nums[i])) {
                // 初始化数组信息
                Integer[] integers = new Integer[3];
                integers[0] = 1; // 出现次数为1
                integers[1] = i; // 第一次出现位置为i
                integers[2] = i; // 最后一次出现位置为i
                map.put(nums[i], integers); // 存入map
            } else {
                // 如果map中已有当前元素，更新信息
                Integer[] integers = map.get(nums[i]);
                integers[0]++; // 出现次数加1
                integers[2] = i; // 更新最后一次出现位置
            }
        }

        // 定义两个变量：
        int maxNum = 0; // 最大出现次数
        int minLen = 0; // 最短子数组长度

        // 遍历map中的每个元素
        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            Integer[] arr = entry.getValue();
            // 如果当前元素的出现次数大于maxNum
            if (maxNum < arr[0]) {
                maxNum = arr[0]; // 更新最大出现次数
                minLen = arr[2] - arr[1] + 1; // 计算当前元素的子数组长度
            } else if (maxNum == arr[0]) {
                // 如果当前元素的出现次数等于maxNum，比较长度
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1; // 更新最短长度
                }
            }
        }
        return minLen; // 返回最短子数组长度
    }


    public static void main(String[] args) {
        LeetCode697 leetCode697 = new LeetCode697();
        int[] nums = {1,2,2,3,1};
        System.out.println(leetCode697.findShortestSubArray(nums));


        int[] nums2 = {1,2,2,3,1,4,2};
        System.out.println(leetCode697.findShortestSubArray(nums2));
    }
}

