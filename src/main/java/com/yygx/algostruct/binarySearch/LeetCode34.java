package com.yygx.algostruct.binarySearch;

import java.util.Arrays;

/**
 * @version 1.0
 * @Copyright (c) 合思技术团队 https://www.hosecloud.com/
 * @authur：zhaojiawei zhaojiawei@hosecloud.com
 * @Package com.yygx.algostruct.binarySearch
 * @Project：AlgoStruct
 * @date 2024/10/10 下午10:59
 */
public class LeetCode34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        result[0] = searchFirst(nums, target);
        result[1] = searchLast(nums,target);
        return result;
    }

    public static int searchFirst(int[] nums, int target){
        int i = 0,j = nums.length-1;
        int candidate = -1;
        while(i<=j){
            int middle = (i+j)>>>1;
            if(target<nums[middle]){
                j = middle-1;
            }else if(nums[middle] < target){
                i = middle+1;
            }else{
                candidate = middle;
                j = middle - 1;
            }
        }
        return candidate;
    }


    public static int searchLast(int[] nums, int target){
        int i = 0,j = nums.length-1;
        int candidate = -1;
        while (i<=j){
            int middle = (i+j)>>>1;
            if(target<nums[middle]){
                j = middle-1;
            }else if(nums[middle] < target){
                i = middle +1;
            }else{
                candidate = middle;
                i = middle + 1;
            }
        }
        return candidate;
    }


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] ints = searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}