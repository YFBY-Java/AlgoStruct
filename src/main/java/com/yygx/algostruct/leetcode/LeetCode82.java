package com.yygx.algostruct.leetcode;


/**
 * LeetCode.82删除链表中的重复元素
 * <p>
 *     给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * </p>
 */
public class LeetCode82 {


    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1,head);
        ListNode current = dummy;
        while (current.next != null && current.next.next != null){
            if(current.next.val != current.next.next.val){
                current = current.next;
            }else {
                int val = current.next.val;
                while (current.next != null && current.next.val == val){
                    current.next = current.next.next;
                }
            }
        }
        return dummy.next;
    }


    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesRecursion(ListNode head) {
        if(head == null || head.next == null) return head;
        if(head.val == head.next.val){
            ListNode next = head.next.next;
            while (next != null && next.val == head.val){
                next = next.next;
            }
            return deleteDuplicates(next);
        }else {
            // 继续遍历
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;


        ListNode node = new LeetCode82().deleteDuplicatesRecursion(node1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}