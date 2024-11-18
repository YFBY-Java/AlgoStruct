package com.yygx.algostruct.leetcode;


/**
 * LeetCode.83删除排序链表中的重复元素
 * <p>
 *     给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * </p>
 */
public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode dummy = new ListNode(-1,head); // 虚节点
        if(head == null || head.next == null) return head;
        head = head.next;
        while (head != null){
            if(pre.val != head.val){
                pre = pre.next;
                head = head.next;
            }else {
                pre.next = head.next;
                head = head.next;
            }
        }
        return dummy.next;
    }


    public ListNode deleteDuplicatesPro(ListNode head) {
        ListNode pre = head;
        while (pre != null && pre.next != null){
            if(pre.val == pre.next.val){
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
        }
        return head;
    }


    public ListNode deleteDuplicatesRecursion(ListNode head){
        // 如果前面的和当前的相等，删除，否则继续递归的遍历链表
        if(head == null || head.next == null){
            return null;
        }
        if(head.val == head.next.val){
            return deleteDuplicatesRecursion(head.next);
        }else {
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

        ListNode node = new LeetCode83().deleteDuplicatesRecursion(node1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }


}