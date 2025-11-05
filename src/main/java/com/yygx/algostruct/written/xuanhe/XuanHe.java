package com.yygx.algostruct.written.xuanhe;


import java.util.ArrayList;
import java.util.List;

public class XuanHe {


    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. 从左到右遍历上层（top 行）
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // 2. 从上到下遍历右列（right 列）
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // 3. 如果还有行未遍历（top <= bottom），从右到左遍历下层（bottom 行）
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // 4. 如果还有列未遍历（left <= right），从下到上遍历左列（left 列）
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }


    // 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    //
    //请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    public int[] moveZero(int[] nums) {
        int nonZeroPtr = 0; // 指向下一个非零元素应该放置的位置

        // 第一次遍历：将所有非零元素移动到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroPtr] = nums[i];
                nonZeroPtr++;
            }
        }
        // 第二次遍历：将剩余位置填充为 0
        for (int i = nonZeroPtr; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }


    public static void main(String[] args) {
        XuanHe xuanHe = new XuanHe();
        int[] nums = {0, 1, 0, 3, 12};
        int[] result = xuanHe.moveZero(nums);
        for (int j : result) {
            System.out.println(j);
        }

    }
}