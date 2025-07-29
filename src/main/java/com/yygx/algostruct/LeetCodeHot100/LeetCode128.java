package com.yygx.algostruct.LeetCodeHot100;

import java.util.*;

/**
 * LeetCode128. 最长连续序列
 * 给定一个未排序的整数数组 nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。<br/>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：nums = [100,4,200,1,3,2]<br/>
 * 输出：4<br/>
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]<br/>
 * 输出：9<br/>
 * <br/>
 * 示例 3：<br/>
 * 输入：nums = [1,0,1,2]<br/>
 * 输出：3<br/>
 */

public class LeetCode128 {


    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        Arrays.sort(nums);
        int maxLen = 1;
        int currentLen = 1;

        for(int i = 1;i<nums.length;i++){
            if(nums[i] == nums[i - 1]){   // 跳过重复的
                continue;
            }else if(nums[i] == nums[i - 1] + 1){
                currentLen++;
            }else {   // 不连续
                currentLen = 1;
            }
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }



    public int longestConsecutiveTest(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        // 排序
        Arrays.sort(nums);

        int maxLen = 1;
        int currentLen = 1;
        for(int i = 1;i< nums.length;i++){
            if(nums[i] == nums[i-1]) {   // 跳过重复元素
                continue;
            }else if(nums[i] == nums[i - 1] + 1){
                currentLen++;
            }else {   // 不连续
                currentLen = 1;
            }
            maxLen = Math.max(maxLen,currentLen);
        }
        return maxLen;
    }




    public int longestConsecutive2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 1;
        int cnt = 1;
        Set<Integer> hs = new HashSet<>();
        for(int n : nums)
            hs.add(n);
        for(int n : hs){
            if(hs.contains(n-1)){
                //cnt = 1;
                continue;
            }
            cnt = 1;
            int cur = n;
            while(hs.contains(cur+1)){
                cnt++;
                cur = cur+1;
            }
            max = Math.max(cnt, max);
        }
        return max;
    }


    // hashSet     速度太慢，不采用
    public int longestConsecutive3(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        // 创建一个有序的set
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 1;
        int currentLen = 1;
        for (Integer num : set) {
            if(set.contains(num - 1)){
                currentLen++;
            }else {
                currentLen = 1;
            }
            maxLen = Math.max(maxLen,currentLen);
        }
        return maxLen;
    }




    public static void main(String[] args) {
        LeetCode128 leetCode128 = new LeetCode128();


        System.out.println(leetCode128.longestConsecutive3(new int[]{3, 3, 4, 4, 5, 5,6,7,8}));

    }


}
