package com.yygx.algostruct.leetcode;


import java.util.Arrays;

/**
 * LeetCode88.合并两个有序数组
 * <p>
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * </P>
 */
public class LeetCode88 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[n];
        }
        Arrays.sort(nums1);
    }


    /**
     * 逆向双指针法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeDualPointers(int[] nums1, int m, int[] nums2, int n) {
        // 使用逆向双指针
        // nums1的元素数是m.大小是m+n，所以nums1的后部分有n个空元素
        // 我们可以每次比较nums1和nums2中的元素，挑选一个大的放到最后
        int pointer1 = m-1;
        int pointer2 = n-1;
        for (int i = m+n-1;i>=0;i--){
            if(pointer1 < 0 || pointer2 < 0){
                break;
            }
            if(nums1[pointer1] > nums2[pointer2]){
                nums1[i] = nums1[pointer1];
                pointer1--;
            }else {
                nums1[i] = nums2[pointer2];
                pointer2--;
            }
        }
        if(pointer2 >= 0){
            for (int i = 0; i <= pointer2; i++) {
                nums1[i] = nums2[i];
            }
        }
    }




    public int[] mergeRecursion(int[] nums1, int m, int[] nums2, int n) {
        copy(nums2, 0, n, nums1, m);
        int[] result = new int[n+m];
        Recursion(nums1, 0,m-1,m,m+n-1,result,0);
        return result;
    }


    /*
    a1 原始数组  a2 结果数组 (k)
    i, iEnd 第一个有序区间的起点终点, j, jEnd 第二个有序区间的起点终点

    merge([1,5,6] [2,4,10,11], a2=[]) {
        merge([5,6] [2,4,10,11], a2=[1]) {
            merge([5,6] [4,10,11], a2=[1,2]) {
                merge([5,6] [10,11], a2=[1,2,4]) {
                    merge([6] [10,11], a2=[1,2,4,5]) {
                        merge([] [10,11], a2=[1,2,4,5,6]) {
                             merge([], [], a2=[1,2,4,5,6,10,11])
                        }
                    }
                }
            }
        }
    }
 */

    /**
     * 递归合并
     * @param source
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @param result
     * @param index
     */
    public void Recursion(int[] source, int start1, int end1,
                          int start2, int end2,
                          int[] result, int index) {
        if(start1 > end1){
            copy(source, start2, end2+1, result, index);
            return;
        }
        if(start2 > end2){
            copy(source,start1,end1+1,result,index);
            return;
        }
        if (source[start1] < source[start2]){
            result[index] = source[start1];
            Recursion(source,start1+1,end1,start2,end2,result,index+1);
        }else {
            result[index] = source[start2];
            Recursion(source,start1,end1,start2+1,end2,result,index+1);
        }
    }

    private static void copy(int[] source, int start, int end, int[] result, int index) {
        for (int i = start; i < end; i++) {
            result[index] = source[i];
            index++;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        LeetCode88 leetCode88 = new LeetCode88();
        leetCode88.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }


}