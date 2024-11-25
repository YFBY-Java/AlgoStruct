package com.yygx.algostruct.leetcode;


/**
 * LeetCode1290.二进制链表转整数
 * <p>
 *    给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *
 * 请你返回该链表所表示数字的 十进制值
 * </p>
 */
public class LeetCode1290 {

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode current = head;
        while (current != null){
            ans = ans * 2 + current.val;
            current = current.next;
        }
        return ans;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        System.out.println(new LeetCode1290().getDecimalValue(head));
    }


}