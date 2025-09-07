package com.yygx.algostruct.LeetCodeHot100;


import java.util.Arrays;

/**
 * LeetCode84. 柱状图中最大的矩形
 * <br/>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1。<br/>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：heights = [2,1,5,6,2,3]<br/>
 * 输出：10<br/>
 * 解释：最大矩形面积为 10，由高度 5 和 6 的柱子形成宽度 2 的矩形。<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：heights = [2,4]<br/>
 * 输出：4<br/>
 */
public class LeetCode84 {

    // 思路正确，但是部分超时
    public int largestRectangleArea(int[] heights) {
        // 表示当前索引位置的柱子，前后有几个连续比这个柱子高 或者 高度相同的柱子
        int[] higher = new int[heights.length];
        // 填充 higher 都为 1
        Arrays.fill(higher,1);
        for (int i = 0; i < heights.length; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0){
                if(heights[left] >= heights[i]){
                    higher[i] = higher[i] + 1;
                    left--;
                }else {
                    break;
                }
            }
            while (right < heights.length){
                if(heights[right] >= heights[i]){
                    higher[i] = higher[i] + 1;
                    right++;
                }else {
                    break;
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < higher.length; i++) {
            maxArea = Math.max(maxArea,higher[i] * heights[i]);
        }
        return maxArea;
    }




    // 双指针剪枝
    public int largestRectangleAreaPro(int[] heights) {
        int length = heights.length;
        // 用两个数组，记录当前元素左边连续比它高的 和 右边连续比他高的
        int[] lh = new int[length];   // 初始化的时候都是0
        int[] rh = new int[length];

        // 从左向右扫描，计算每个柱子向左能延伸的长度
        for (int i = 0; i < length; i++) {
            int current = 1;   // 柱子本身自带宽度1
            int left = i - 1;  // 从柱子的左侧开始扫描
            while (left >= 0 && heights[left] >= heights[i]){
                current = current + lh[left];  // 当前高度，当前位置左侧连续的，跳过中间连续的
                left = left - lh[left];   // 向左跳过连续更高的
            }
            lh[i] = current;
        }
        // 向左扫描 计算每个柱子能向右延伸的长度
        for (int i = length - 1; i >= 0; i--) {
            int current = 1;  // 柱子本身自带宽度1    这个1进行了重复计数
            int right = i + 1;
            while (right < length && heights[right] >= heights[i]){
                current = current + rh[right];
                right = right + rh[right];
            }
            rh[i] = current;
        }
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            // 这里减去重复计数的一个宽度   （柱子本身的宽度计算了两次）
            maxArea = Math.max(maxArea,(lh[i] + rh[i] - 1) * heights[i]);
        }
        return maxArea;
    }




    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        LeetCode84 leetCode84 = new LeetCode84();
        System.out.println(leetCode84.largestRectangleArea(heights));
    }


}