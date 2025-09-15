package com.yygx.algostruct.writtenTest;


import java.util.HashSet;
import java.util.Set;

// 哔哩哔哩 笔试准备 26测开 质保中心
public class WrittenTestPreparation_9_15 {


    /**
     * LeetCode253. 会议室 II
     * <br/>
     * 给你一个会议时间安排的数组 intervals，<br/>
     * 每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi]，<br/>
     * 返回所需会议室的最小数量。<br/>
     * <br/>
     * 示例 1：<br/>
     * 输入：intervals = [[0,30],[5,10],[15,20]]<br/>
     * 输出：2<br/>
     * <br/>
     * 示例 2：<br/>
     * 输入：intervals = [[7,10],[2,4]]<br/>
     * 输出：1<br/>
     */
    // 暴力解法
    public int minMeetingRooms(int[][] intervals) {
        /**
         * 找到最大时间 和 最小时间
         * 新建一个数组（会议数量），存储最小开始时间 到 最大结束时间 范围内 的 每个时间 使用了几个会议室
         * minStart 映射到 数组的 0 ， maxEnd 映射到数组的最后一个位置   数组长度 为  maxEnd - minStart + 1
         * 遍历输入数组，将某个会议起止时间内的 对应索引位置 全部 +1  表示这个时间点有一个会议进行
         * 遍历 会议数量数组，找到最大值，就是需要的会议室的数量
         */
        // 找到最小的开始时间 和 最大的结束时间
        int minStart = Integer.MAX_VALUE;
        int maxEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            // 遍历找到最小开始时间和最大结束时间
            minStart = Math.min(minStart, interval[0]);
            maxEnd = Math.max(maxEnd, interval[1]);
        }
        // 用来映射 某个时间点（索引） 的会议数量（元素）
        int[] meetingNum = new int[maxEnd - minStart + 1];
        for (int[] interval : intervals) {
            int start = interval[0] - minStart;  // 当前会议开始时间
            int end = interval[1] - minStart;  // 当前会议结束时间
            for (int i = start; i < end; i++) {
                meetingNum[i] = meetingNum[i] + 1;
            }
        }
        int max = 0;
        for (int i : meetingNum) { // 遍历数组，找到最大会议数量
            max = Math.max(max, i);
        }
        return max;
    }


    // 停车场，输入数组，输出数组，计算停车场最少需要多少停车位
    // In 车辆进入序号，Out车辆离开序号
    public int parkingCapacity(int[] In, int[] Out) {
        // 进入指针和离开指针
        int indexIn = 0;
        int indexOut= 0;
        // 停车场最多停车数量
        int max = 0;
        // 定义一个集合
        Set<Integer> set = new HashSet<>();
        // 判断要离开的车辆存不存在，存在就离开，不存在就进入
        while (indexOut < Out.length){
            if(set.contains(Out[indexOut])){
                set.remove(Out[indexOut]);
                // 比较之前的最大车辆数 和 当前车辆数
                max = Math.max(max,set.size());
                indexOut++;
            }else {
                // 停车场中不存在这个编号，进入一辆车，
                set.add(In[indexIn]);
                indexIn++;
            }
        }
        return max;
    }


}