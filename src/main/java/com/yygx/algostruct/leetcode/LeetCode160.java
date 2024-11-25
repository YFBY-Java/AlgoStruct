package com.yygx.algostruct.leetcode;


import java.util.HashMap;

/**
 * 160. 相交链表
 * <p>
 *     给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 自定义评测：
 *
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 *
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 * </p>
 */
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 遍历链表A，将结果存入哈希表
        // 遍历链表B，从哈希表中获取元素
        HashMap<ListNode,ListNode> map = new HashMap<>();
        ListNode currentA = headA;
        while (currentA != null){
            map.put(currentA, currentA);
            currentA = currentA.next;
        }
        ListNode currentB = headB;
        while (currentB != null){
            ListNode node = map.get(currentB);
            if(node == currentB) return currentB;
            currentB = currentB.next;
        }
        return null;
    }


    /**
     * 计算长度差值，对齐链表，寻找交点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;
        int sizeA = size(currentA);
        int sizeB = size(currentB);
        int abs = Math.abs(sizeA - sizeB);
        if(sizeA > sizeB){
            for (int i = 0; i < abs; i++) {
                currentA = currentA.next;
            }
        }else {
            for (int i = 0; i < abs; i++) {
                currentB = currentB.next;
            }
        }
        while (currentA != currentB){
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return currentA;
    }

    private static int size(ListNode current) {
        int size = 0;
        while (current != null){
            size++;
            current = current.next;
        }
        return size;
    }

}