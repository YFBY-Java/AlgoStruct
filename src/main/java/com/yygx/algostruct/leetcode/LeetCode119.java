package com.yygx.algostruct.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode119.杨辉三角 II
 * <p>
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * </p>
 */
public class LeetCode119 {


    /**
     * 递推法
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRowRecursion(int rowIndex) {
        List<List<Integer>> c = new ArrayList<List<Integer>>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(c.get(i - 1).get(j - 1) + c.get(i - 1).get(j));
                }
            }
            c.add(row);
        }
        return c.get(rowIndex);
    }


    /**
     * 滚动数组
     * @param rowIndex
     * @return
     */
    public List<Integer> getRowDP(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    current.add(1);
                }else {
                    current.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = current;
        }
        return pre;
    }



    public static void main(String[] args) {
        LeetCode119 leetCode119 = new LeetCode119();
        System.out.println(leetCode119.getRowRecursion(3));
    }
}