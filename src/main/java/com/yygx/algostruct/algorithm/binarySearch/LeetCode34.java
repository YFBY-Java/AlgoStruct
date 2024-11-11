package com.yygx.algostruct.algorithm.binarySearch;

import java.util.Arrays;

/**
 * Author: <a href="https://github.com/YFBY-Java" target="_blank">吟风抱月</a>
 */
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
//        int[] nums = {5,7,7,8,8,10};
//        int target = 8;
//
//        int[] ints = searchRange(nums, target);
//        System.out.println(Arrays.toString(ints));
//        int[] nums2 = {};
//        int target2 = 0;
//        int[] ints2 = searchRange(nums2, target2);
//        System.out.println(Arrays.toString(ints2));

        findMaxArraySize();

    }


    public static void findMaxArraySize() {
        int low = 0;
        int high = Integer.MAX_VALUE; // 理论上数组的最大值为 Integer.MAX_VALUE
        int maxSize = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1; // 中间值，防止溢出
            int[] testArray = null; // 初始化数组引用为 null
            try {
                // 尝试分配数组
                testArray = new int[mid];
                // 如果分配成功，说明当前大小是可行的
                maxSize = mid; // 更新最大可行的数组大小
                low = mid + 1; // 继续尝试更大的数组
            } catch (OutOfMemoryError e) {
                // 如果内存不足，缩小查找范围
                high = mid - 1;
            } finally {
                // 清除对数组的引用，以便垃圾回收器可以回收内存
                testArray = null;
                // 可以选择在这里请求 GC，但这并不是强制性的
                // System.gc();
            }
        }

        System.out.println("Maximum array size: " + maxSize);
    }
}