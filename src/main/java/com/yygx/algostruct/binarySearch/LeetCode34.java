package com.yygx.algostruct.binarySearch;

import java.util.Arrays;


public class LeetCode34 {
    public static int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums,target);
        if(left == -1){
            return new int[]{-1,-1};
        }else{
            return new int[]{left,searchRight(nums,target)};
        }

    }


    public static int searchLeft(int[] nums, int target){
        int i = 0,j = nums.length-1;
        int cadidate = -1;
        while(i<=j){
            int middle = (i+j)>>>1;
            if(target < nums[middle]){
                j = middle-1;
            }else if(nums[middle]<target){
                i = middle+1;
            }else{
                cadidate = middle;
                j = middle-1;
            }
        }
        return cadidate;
    }

    public static int searchRight(int[] nums, int target){
        int i = 0,j = nums.length-1;
        int cadidate = -1;
        while(i<=j){
            int middle = (i+j)>>>1;
            if(target < nums[middle]){
                j = middle-1;
            }else if(nums[middle]<target){
                i = middle+1;
            }else{
                cadidate = middle;
                i = middle+1;
            }
        }
        return cadidate;
    }


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] ints = searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
        int[] nums2 = {};
        int target2 = 0;
        int[] ints2 = searchRange(nums2, target2);
        System.out.println(Arrays.toString(ints2));
    }
}