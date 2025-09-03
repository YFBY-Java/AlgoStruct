package com.yygx.algostruct.leetcode;


import java.util.Stack;

/**
 * LeetCode739. 每日温度
 * 给定一个整数数组 temperatures，表示每天的温度，返回一个数组 answer，<br/>
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。<br/>
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。<br/>
 * <br/>
 * 示例 1：<br/>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]<br/>
 * 输出: [1,1,4,2,1,1,0,0]<br/>
 * <br/>
 * 示例 2：<br/>
 * 输入: temperatures = [30,40,50,60]<br/>
 * 输出: [1,1,1,0]<br/>
 * <br/>
 * 示例 3：<br/>
 * 输入: temperatures = [30,60,90]<br/>
 * 输出: [1,1,0]<br/>
 */

public class LeetCode739 {


    public int[] dailyTemperatures(int[] temperatures) {
        // 单调栈,不大于的元素都入栈，大于的出栈
        // 栈存储还没有找到更高温度的 元素 的索引
        // 定义返回结果
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            // 获取当前元素
            int current = temperatures[i];
            // 栈中有元素，且当前元素大于栈顶元素
            while (!stack.isEmpty() && current > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i); // 把当前元素索引放入栈顶
        }
        return answer;
    }


    public int[] dailyTemperaturesTest(int[] temperatures) {
        // 单调栈，不比当前温度高的入栈，遇到比当前温度高的出栈顶，修改对应元素
        // 返回结果
        int[] answer = new int[temperatures.length];
        // 定义栈
        Stack<Integer> stack = new Stack<>();  // 栈存储的是 上一个非严格递增温度 的索引
        for (int i = 0; i < temperatures.length; i++) {

            int current = temperatures[i];
            // 栈不为空，并且当前温度大于 栈顶索引指向的温度
            while (!stack.isEmpty() && current > temperatures[stack.peek()]){
                // 栈顶索引 对应的 answer 元素
                Integer pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i);   // 当前温度入栈
        }
        return answer;
    }


}