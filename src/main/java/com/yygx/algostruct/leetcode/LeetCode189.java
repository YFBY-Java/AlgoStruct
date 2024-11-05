package com.yygx.algostruct.leetcode;


/**
 * LeetCode189.轮转数组
 * <p>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * </p>
 */
public class LeetCode189 {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[(k + i) % length] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, length);
    }


    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);   // 反转整个数组
        reverse(nums, 0, k - 1);   // 反转前k个
        reverse(nums, k, n - 1);       // 反转后面的元素
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        LeetCode189 leetCode189 = new LeetCode189();
//        leetCode189.rotate(nums, 3);
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        LeetCode189 leetCode189 = new LeetCode189();
        leetCode189.rotate2(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}