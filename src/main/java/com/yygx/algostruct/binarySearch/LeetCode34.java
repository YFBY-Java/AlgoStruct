package com.yygx.algostruct.binarySearch;

import java.util.Arrays;


public class LeetCode34 {
//    public static int[] searchRange(int[] nums, int target) {
//        int left = searchLeft(nums,target);
//        if(left == -1){
//            return new int[]{-1,-1};
//        }else{
//            return new int[]{left,searchRight(nums,target)};
//        }
//    }


    public static int[] searchRange(int[] nums, int target) {
        int left = searchBoundary(nums,target,true);
        if(left == -1){
            return new int[]{-1,-1};
        }else{
            return new int[]{left,searchBoundary(nums,target,false)};
        }
    }


    public static int searchLeft(int[] nums, int target){
        int i = 0,j = nums.length-1;
        int candidate = -1;
        while(i<=j){
            int middle = (i+j)>>>1;
            if(target < nums[middle]){
                j = middle-1;
            }else if(nums[middle]<target){
                i = middle+1;
            }else{
                candidate = middle;
                j = middle-1;
            }
        }
        return candidate;
    }

    public static int searchRight(int[] nums, int target){
        int i = 0,j = nums.length-1;
        int candidate = -1;
        while(i<=j){
            int middle = (i+j)>>>1;
            if(target < nums[middle]){
                j = middle-1;
            }else if(nums[middle]<target){
                i = middle+1;
            }else{
                candidate = middle;
                i = middle+1;
            }
        }
        return candidate;
    }


    public static int searchBoundary(int[] nums, int target,boolean isLeft){
        int i = 0,j = nums.length-1;
        int candidate = -1;
        while(i<=j){
            int middle = (i+j)>>>1;
            if(target < nums[middle]){
                j = middle-1;
            }else if(nums[middle]<target){
                i = middle+1;
            }else{
                candidate = middle;
                if(isLeft){
                    j = middle -1;
                }else {
                    i = middle + 1;
                }
            }
        }
        return candidate;
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