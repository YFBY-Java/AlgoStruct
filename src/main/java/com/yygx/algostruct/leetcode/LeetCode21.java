package com.yygx.algostruct.leetcode;


import java.util.LinkedList;

/**
 * LeetCode.21合并两个有序链表
 * <p>
 *     将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * </p>
 */
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 新建一个链表，用于保存合并结果
        ListNode newList = new ListNode(-1);
        ListNode temp = newList;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 == null){
            temp.next = list2;
        }else {
            temp.next = list1;
        }
        return newList.next;
    }



    public ListNode mergeTwoListsRecursion(ListNode p1, ListNode p2) {
        if (p2 == null) {
            return p1;
        }
        if (p1 == null) {
            return p2;
        }
        if (p1.val < p2.val) {
            p1.next = mergeTwoListsRecursion(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoListsRecursion(p1, p2.next);
            return p2;
        }
    }


    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        // 新建一个链表，用来保存合并结果
        ListNode newList = new ListNode(-1);
        ListNode temp = newList;
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                temp.next = list2;
                list2 = list2.next;
            }else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        if(list1 != null) {
            temp.next = list1;
        }else {
            temp.next = list2;
        }
        return newList.next;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;
//        ListNode node = new LeetCode21().mergeTwoLists(node1, node4);
        ListNode node = new LeetCode21().mergeTwoListsRecursion(node1, node4);

        System.out.println(node);


    }
}