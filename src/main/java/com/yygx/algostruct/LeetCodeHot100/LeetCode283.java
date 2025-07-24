package com.yygx.algostruct.LeetCodeHot100;


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
        // 定义当前遇到了几个零
        int zeroNum = 0;
        //当前索引
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                zeroNum++;
            }else {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int desIndex = nums.length-1; desIndex > nums.length-1-zeroNum; desIndex--) {
            nums[desIndex] = 0;
        }
    }


}
