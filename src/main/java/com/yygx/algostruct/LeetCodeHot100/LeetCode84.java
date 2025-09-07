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


    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        LeetCode84 leetCode84 = new LeetCode84();
        System.out.println(leetCode84.largestRectangleArea(heights));
    }


}