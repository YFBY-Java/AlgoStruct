package com.yygx.algostruct.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode118.杨辉三角
 * <p>
 *     给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * </p>
 */
public class LeetCode118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    row.add(1);
                }else {
                    row.add(ret.get(i-1).get(j-1) + ret.get(i-1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }


    /**
     * 动态规划
     * @param numRows
     * @return
     */
    public List<List<Integer>> generatePro(int numRows) {
        if(numRows <= 0) return new ArrayList<>();
        List<List<Integer>> resList = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        for (int i = 0; i < numRows; i++) {
            List<Integer> valList = new ArrayList<>();
            if(i == 0){
                valList.add(dp[0][0]);
            }
            for (int j = 0; i > 0 && j <= i; j++){
                if(j >= 1){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
                valList.add(dp[i][j]);
            }
            resList.add(valList);
        }
        return resList;
    }
}