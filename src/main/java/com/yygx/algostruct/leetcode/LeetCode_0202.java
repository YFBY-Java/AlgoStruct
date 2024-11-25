package com.yygx.algostruct.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 面试题02.02返回倒数第k个节点
 * <p>
 *    实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * </p>
 */
public class LeetCode_0202 {

    public int kthToLast(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null){
            list.add(current.val);
            current = current.next;
        }
        int size = list.size();
        return list.get(size - k);
    }
}