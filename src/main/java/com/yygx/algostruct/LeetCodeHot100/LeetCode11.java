package com.yygx.algostruct.LeetCodeHot100;


/**
 * LeetCode11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height。<br/>
 * 有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。<br/>
 * <br/>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。<br/>
 * 返回容器可以储存的最大水量。<br/>
 * <br/>
 * 说明：你不能倾斜容器。<br/>
 */

public class LeetCode11 {


    // 移动高度较低的指针
    public int maxArea(int[] height) {
        // 记录左指针和右指针
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;  // 记录当前最大的面积
        while (left < right) {
            int area = area(left, right, height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }


    /**
     * 计算面积
     *
     * @param left   左指针
     * @param right  右指针
     * @param leftH  左指针高
     * @param rightH 右指针高
     * @return
     */
    public int area(int left, int right, int leftH, int rightH) {
        return (right - left) * Math.min(leftH, rightH);
    }

    /**
     * 面积计算
     *
     * @param left
     * @param right
     * @param high
     * @return
     */
    public int area(int left, int right, int high) {
        return (right - left) * high;
    }


    public int maxAreaPro(int[] height) {
        // 左右指针
        int left = 0;
        int right = height.length - 1;
        // 最大面积
        int maxArea = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = area(left, right, h);
            maxArea = Math.max(maxArea, area);
            while (left < right && height[left] <= h) {
                left++;
            }
            while (left < right && height[right] <= h) {
                right--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        // [1,8,6,2,5,4,8,3,7]

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        // [1,8,100,2,100,4,8,3,7]
//        int[] height = {1,8,100,2,100,4,8,3,7};


        LeetCode11 leetCode11 = new LeetCode11();
        System.out.println(leetCode11.maxArea(height));


    }


}
