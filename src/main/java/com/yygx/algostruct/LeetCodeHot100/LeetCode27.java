package com.yygx.algostruct.LeetCodeHot100;

/**
 * LeetCode27. 移除元素<br/>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。<br/>
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：<br/>
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。<br/>
 * 返回 k。<br/>
 */

public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int vulNum = 0;  // 值为val的元素个数
        int index = 0; // 指针，指向当前空余（被移除的元素）
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
        // index指向的是当前空余的元素，最后会超出一个位置空余，所以结果不用+1（索引从0开始）
    }


}
