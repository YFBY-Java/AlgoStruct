package com.yygx.algostruct.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode234.回文链表
 * <p>
 *     给你一个单链表的头节点 head ，请你判断该链表是否为
 * 回文链表
 * 。如果是，返回 true ；否则，返回 false 。
 * </p>
 */
public class LeetCode234 {

    private ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (!list.get(i).equals(list.get(size - i - 1))){
                return false;
            }
        }
        return true;
    }


    //递归
    public boolean isPalindromeRecursion(ListNode head){
        if (head == null || head.next == null){
            return true;
        }
        frontPointer = head;
        return recursion(head);
    }

    private boolean recursion(ListNode head) {
        if(head == null) return true;
        if (!recursion(head.next)) {
            return false;
        }
        if (head.val != frontPointer.val) {
            return false;
        }
        frontPointer = frontPointer.next;
        return true;
    }


    public static void main(String[] args) {
        ListNode node = Utils.generateRandomSortedLinkedList();
        System.out.println(node);
        System.out.println(new LeetCode234().isPalindrome(node));

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(1);
        System.out.println(node1);
        System.out.println(new LeetCode234().isPalindromeRecursion(node1));
    }
}