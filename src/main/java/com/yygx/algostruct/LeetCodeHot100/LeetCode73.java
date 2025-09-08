package com.yygx.algostruct.LeetCodeHot100;


import java.util.Arrays;

/**
 * LeetCode73. 矩阵置零
 * <br/>
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0。<br/>
 * 请使用原地算法。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]<br/>
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]<br/>
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]<br/>
 */

public class LeetCode73 {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;  // 行数
        int column = matrix[0].length;   // 列数
        // 标记是否存在 0
        boolean[] rowArray = new boolean[row];
        boolean[] columnArray = new boolean[column];
        // 遍历一遍数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowArray[i] = true;
                    columnArray[j] = true;
                }
            }
        }
        for (int i = 0; i < rowArray.length; i++) {
            if (!rowArray[i]) continue;
            Arrays.fill(matrix[i],0);
        }
        for (int i = 0; i < columnArray.length; i++) {
            if(!columnArray[i]) continue;
            for (int j = 0; j < row; j++) {
                matrix[j][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        // [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        LeetCode73 leetCode73 = new LeetCode73();
        leetCode73.setZeroes(matrix);
    }
}