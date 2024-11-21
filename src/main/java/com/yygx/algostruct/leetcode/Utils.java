package com.yygx.algostruct.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 * 注释：工具类
 * </p>
 * Since: 2024/9/28 <p>
 * Author: <a href="https://github.com/YFBY-Java" target="_blank">吟风抱月</a>
 */
public final class Utils {


    /**
     * 生成指定数量的随机数
     * @param size 随机数数量
     * @return 随机数数组
     */
    public static int[] generateRandomArray(int size){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(); // 生成随机数
        }
        return array;
    }


    public static ListNode generateRandomSortedLinkedList() {
        Random random = new Random();
        int length = random.nextInt(20) + 1;

        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = random.nextInt(10); // 值范围：0-9
        }
        Arrays.sort(values); // 排序

        // 生成链表
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            current.next = null;
        }
        return head;
    }



    public static void main(String[] args) {
        // 调用生成链表的方法
        ListNode randomLinkedList = generateRandomSortedLinkedList();
        // 打印生成的链表
        System.out.println(randomLinkedList);
    }


}
