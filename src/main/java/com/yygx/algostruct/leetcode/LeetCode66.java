package com.yygx.algostruct.leetcode;


/**
 * LeetCode66.加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。</p>
 */
public class LeetCode66 {


    /**
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        // 找最后面有几个连续的9
        int length = digits.length;
        if (digits[length - 1] != 9) {  // 最后一位不是9直接在最后一位加1
            digits[length - 1]++;
            return digits;
        }
        int num9 = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] == 9) num9++;
            else break;
        }
        if (num9 == length) {
            int[] newArray = new int[length + 1];
            newArray[0] = 1;
            for (int i = 1; i < length + 1; i++) {
                newArray[i] = 0;
            }
            return newArray;
        } else {
            digits[length - num9 - 1]++;
            for (int i = length-num9; i < length; i++) {
                digits[i] = 0;
            }
            return digits;
        }
    }


    public static void main(String[] args) {
        int[] digits = {8,9,9,9};
        LeetCode66 leetCode66 = new LeetCode66();
        int[] result = leetCode66.plusOne(digits);
        for (int i : result) {
            System.out.println(i);
        }
    }

}