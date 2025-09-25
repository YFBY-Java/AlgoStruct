package com.yygx.algostruct.writtenTest;


// 叠纸笔试准备
public class DieZhiTest {


    // 旋转数组
    public void rotate(int[] nums, int k) {
        // 如果数组为空或者只有一个元素 直接返回
        if (nums == null || nums.length <= 1) return;
        // 对k取模
        k %= nums.length;
        // 暂存 最后的 k个 元素
        int[] knum = new int[k];
        System.arraycopy(nums, nums.length - k, knum, 0, k);
        int index = nums.length - 1;
        // 将前 len - k 个元素 后移
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[index] = nums[i];
            index--;
        }
        // 将 knum 的元素拷贝到数组的前面
        System.arraycopy(knum, 0, nums, 0, k);
    }

}