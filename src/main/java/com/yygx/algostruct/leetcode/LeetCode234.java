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


    /**
     * 反转后半部分链表
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head){
        if(head == null || head.next == null) return true;
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null){
            if(p1.val != p2.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }


    /**
     * 中间节点+反转链表
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        // 参考反转链表+链表中间节点
        // 新建一个链表反转前半部分
        if(head == null) return false;
        if(head.next == null) return true;
        ListNode slow = head;
        ListNode quick = head;
        // 新链表，用于反转
        ListNode pre = null;
        ListNode current = head;
        while(quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;

            // 反转链表
            current.next = pre;
            pre = current;
            current = slow;
        }
        if(quick != null){
            slow = slow.next;
        }
        while(pre != null){
            if(pre.val != slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }





    private ListNode reverseList(ListNode secondHalfStart) {
        ListNode pre = null;
        while (secondHalfStart != null){
            ListNode next = secondHalfStart.next;
            secondHalfStart.next = pre;
            pre = secondHalfStart;
            secondHalfStart = next;
        }
        return pre;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
        System.out.println(new LeetCode234().isPalindrome2(node1));




    }
}