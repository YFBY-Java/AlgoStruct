package com.yygx.algostruct.leetcode;


/**
 * LeetCode876.链表中间节点
 * <p>
 *     给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 * </p>
 */
public class LeetCode876 {

    public ListNode middleNode(ListNode head) {
        if(head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode quick = dummy;
        ListNode slow = dummy;
        while (quick.next != null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow.next;
    }

    public ListNode middleNodePro(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode head = Utils.generateRandomSortedLinkedList();
        System.out.println(head);
        LeetCode876 leetCode876 = new LeetCode876();
//        ListNode middleNode = leetCode876.middleNode(head);
        ListNode middleNode = leetCode876.middleNodePro(head);
        System.out.println(middleNode.val);
    }
}