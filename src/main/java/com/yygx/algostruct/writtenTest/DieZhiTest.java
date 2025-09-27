package com.yygx.algostruct.writtenTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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


    /**
     * 功能：将字符串中所有括号内的内容替换为 '*'，括号本身保留。<br>
     *      - 支持多对括号<br>
     *      - 支持嵌套括号（只替换最外层括号内的内容）<br>
     *      - 如果括号未闭合，则不影响其他括号的替换<br>
     * <br>
     * 示例：<br>
     * ConvertString("Nikki (happy) new (year)") → "Nikki (*) new (*)"<br>
     * ConvertString("a(test(test2))b") → "a(*)b"<br>
     * ConvertString("(a)test(b)") → "(*)test(*)"<br>
     * ConvertString("a(test(b)test") → "a(test(*)test"<br>
     * <br>
     * @param originalStr 原始字符串，可能包含零个或多个括号<br>
     * @return 处理后的字符串，括号内的内容被 '*' 替换，括号保留<br>
     */
    public String ConvertString(String originalStr) {
        // 如果输入字符串为空或为 null，直接返回原字符串
        if (originalStr == null || originalStr.isEmpty()) {
            return originalStr;
        }
        // 使用 StringBuilder 方便后续对字符串进行修改
        StringBuilder result = new StringBuilder(originalStr);
        // 栈用于记录左括号 '(' 的索引
        Stack<Integer> stack = new Stack<>();
        // 列表用于存储每一对括号的起始和结束索引
        List<int[]> pairs = new ArrayList<>();
        // 遍历字符串，找到所有括号及其对应关系
        for (int i = 0; i < originalStr.length(); i++) {
            char c = originalStr.charAt(i);
            if (c == '(') {
                // 遇到左括号，将索引入栈
                stack.push(i);
            } else if (c == ')') {
                // 遇到右括号，尝试从栈中取出对应的左括号索引
                if (!stack.isEmpty()) {
                    int start = stack.pop(); // 左括号索引
                    pairs.add(new int[]{start, i}); // 将这一对括号索引保存
                }
            }
        }
        // 对括号对按右括号索引从大到小排序，保证从后往前替换
        // 这样替换不会影响前面括号的索引
        pairs.sort((a, b) -> Integer.compare(b[1], a[1]));
        // 遍历每一对括号，替换括号中的内容为 '*'
        for (int[] pair : pairs) {
            int start = pair[0]; // 左括号索引
            int end = pair[1];   // 右括号索引
            // 在替换前检查索引范围，防止越界
            if (start + 1 <= result.length() && end <= result.length() &&
                    start + 1 <= end) {
                // 替换左括号和右括号之间的内容为 '*'
                result.replace(start + 1, end, "*");
            }
        }
        // 返回处理后的字符串
        return result.toString();
    }



}