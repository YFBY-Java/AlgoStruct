package com.yygx.algostruct.leetcode;


/**
 * LeetCode283.移动零
 * <P>
 *     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * </P>
 */
public class LeetCode283 {


    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n){
            if(nums[right] != 0){
                swap(nums,left,right);
                left++;   // 产生交换才移动左边
            }
            right++;
        }
    }


    public void moveZeroesPro(int[] nums) {
        if(nums.length <= 1) return;
        int i = 0;   // 记录非零元素个数
        for(int j = 0;j < nums.length;j++){
            if(nums[j] != 0){   // 元素不为0时移动，并将非零元素个数加1
                nums[i] = nums[j];
                i++;
            }
        }
        while (i < nums.length){   // 后面的元素都置为0
            nums[i] = 0;
            i++;
        }
    }




    /**
     * 交换
     * @param nums
     * @param left
     * @param right
     */
    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}