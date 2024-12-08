package com.yygx.algostruct.leetcode;


/**
 * LeetCode1089.复写零
 * <p>
 * 给你一个长度固定的整数数组 arr ，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * </P>
 */
public class LeetCode1089 {

    public void duplicateZeros(int[] A) {
        int n = A.length, cnt0 = 0;
        // 统计数组中 0 的总数
        for (int j : A) if (j == 0) ++cnt0;
        // 从数组末尾开始向前遍历
        for (int i = n - 1; i >= 0; --i) {
            // 如果当前元素是 0，减少 0 的计数
            if (A[i] == 0) --cnt0;
            // 检查当前元素右移后的索引是否在数组范围内
            if (i + cnt0 < n) {
                // 将当前元素右移 cnt0 位
                A[i + cnt0] = A[i];
                // 如果当前元素是 0，右移后需要在后面再补一个 0
                if (A[i] == 0 && i + cnt0 + 1 < n) {
                    A[i + cnt0 + 1] = 0;
                }
            }
        }
    }


}