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
        // resultLen 用于记录去重后的数组长度
        int resultLen = 0;
        // currentNum 用于存储当前去重数组中最新的元素，初始为 Integer.MAX_VALUE
        // 这个值不会与输入数组中的任何元素相等
        int currentNum = Integer.MAX_VALUE;
        // 遍历数组，检查是否有重复元素
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素不等于当前去重数组中的最后一个元素
            if (nums[i] != currentNum) {
                // 将当前元素放到去重数组中的相应位置
                nums[resultLen] = nums[i];
                // 更新 currentNum 为最新的去重元素
                currentNum = nums[resultLen];
                // 增加去重数组的长度
                resultLen++;
            }
        }
        // 返回去重后的数组长度
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






    public int removeDuplicates3(int[] nums) {
        // 定义当前长度
        int resultLen = 0;
        int current = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != current){
                nums[resultLen] = nums[i];
                current = nums[resultLen];
                resultLen++;
            }
        }
        return resultLen;
    }


}
