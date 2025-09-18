package com.yygx.algostruct.leetcode;

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserFeature;

import java.util.Arrays;
import java.util.Random;

/**
 * LeetCode215. 数组中的第K个最大元素
 * <br/>
 * 给定整数数组 nums 和整数 k，返回数组中第 k 个最大的元素。<br/>
 * 注意：寻找的是排序后的第 k 个最大元素，而不是第 k 个不同的元素。<br/>
 * 必须设计并实现时间复杂度为 O(n) 的算法。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入: nums = [3,2,1,5,6,4], k = 2<br/>
 * 输出: 5<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入: nums = [3,2,3,1,2,4,5,5,6], k = 4<br/>
 * 输出: 4<br/>
 */
public class LeetCode215 {

    Random random = new Random();


    public int findKthLargestTest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }




    /**
     * 返回数组中第 k 个最大的元素
     * @param nums 数组
     * @param k 第 k 大元素（1-based）
     * @return 第 k 大元素
     */
    public int findKthLargestTest1(int[] nums, int k) {
        int n = nums.length;
        // 第 k 大元素 = 第 (n-k) 小元素
        int targetIndex = n - k;
        return quickSelectHoare(nums, 0, n - 1, targetIndex);
    }

    /**
     * 使用 Hoare 分区法递归查找数组中第 k 小元素
     * @param nums 数组
     * @param left 左边界
     * @param right 右边界
     * @param targetIndex 目标索引（0-based，第 k 小元素的索引）
     * @return 第 k 小元素
     */
    private int quickSelectHoare(int[] nums, int left, int right, int targetIndex) {
        // 区间只剩一个元素，直接返回
        if (left == right) return nums[targetIndex];

        int pivotValue = nums[left]; // 选择区间第一个元素作为枢轴
        int i = left - 1;
        int j = right + 1;

        // Hoare 分区：将小于 pivot 的放左边，大于 pivot 的放右边
        while (i < j) {
            do i++; while (nums[i] < pivotValue);  // 找到 >= pivot 的元素
            do j--; while (nums[j] > pivotValue);  // 找到 <= pivot 的元素
            if (i < j) {
                swap(nums, i, j);
            }
        }

        // j 是分区后枢轴的最终位置
        if (targetIndex <= j) {
            return quickSelectHoare(nums, left, j, targetIndex);
        } else {
            return quickSelectHoare(nums, j + 1, right, targetIndex);
        }
    }





    /**
     * 返回数组中第 k 个最大的元素
     * @param nums 数组
     * @param k 第 k 大元素（1-based）
     * @return 第 k 大元素
     */
    public int findKthLargest(int[] nums, int k) {
        // 二分法
        int length = nums.length;
        int target = length - k;
        // 在区间 nums[left...right] 查找下标为 target 的元素
        int left = 0;
        int right = length - 1;  // 初始化左右指针
        while (true){
            int partition = partition(nums, left, right);
            if(partition == target){
                return nums[partition];
            }else if(partition > target) {
                right = partition - 1;
            }else {
                left = partition + 1;
            }
        }
    }

    // partition
    public int partition(int[] nums,int left,int right){
        // 随机选择一个索引作为 基准
        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivotValue = nums[pivotIndex];
        // 把选中的基准元素放到区间末尾，便于后续扫描
        swap(nums,pivotIndex,right);   // 现在 nums[right] 存储的是原基准元素
        // 记录小于 基准元素的索引
        int storeIndex = left;
        // 遍历 [left,right - 1]，把小于 基准（pivot）的元素交换到前面
        for (int i = left; i < right; i++) {
            if(nums[i] < pivotValue){
                swap(nums,i,storeIndex);
                storeIndex++;
            }
        }
        // 最后把 基准元素放到正确位置
        swap(nums,storeIndex,right);
        return storeIndex;
    }


    // 交换数组中的元素
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}