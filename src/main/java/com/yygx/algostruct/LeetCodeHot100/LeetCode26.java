package com.yygx.algostruct.LeetCodeHot100;

/**
 * LeetCode26. 删除有序数组中的重复项<br/>
 * 给你一个 非严格递增排列 的数组 nums，请你 原地 删除重复出现的元素，使每个元素 只出现一次，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致。然后返回 nums 中唯一元素的个数。<br/>
 * 考虑 nums 的唯一元素的数量为 k，你需要做以下事情确保你的题解可以被通过：<br/>
 * 更改数组 nums，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。<br/>
 * 返回 k 。<br/>
 */
public class LeetCode26 {


    public int removeDuplicates(int[] nums) {
        // 返回数组的长度
        int resultLen = 0;
        int currentNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != currentNum){
                nums[resultLen] = nums[i];
                currentNum = nums[resultLen];
                resultLen++;
            }
        }
        return resultLen;
    }


    public int removeDuplicates2(int[] nums) {
        // slowIndex 指向不重复元素的最后一个位置
        int slowIndex = 0;

        // fastIndex 用于遍历数组，从第二个元素开始
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            // 如果 fastIndex 指向的元素与 slowIndex 指向的元素不同
            // 则慢指针慢慢向前移动，并将不重复的元素放到新位置
            if (nums[fastIndex] != nums[slowIndex]) {
                // 慢指针右移一位
                slowIndex++;
                // 将当前的 fastIndex 元素放到 slowIndex 后面
                nums[slowIndex] = nums[fastIndex];
            }
        }

        // 返回去重后的数组长度，注意慢指针从 0 开始，所以要加 1
        return slowIndex + 1;
    }


}
