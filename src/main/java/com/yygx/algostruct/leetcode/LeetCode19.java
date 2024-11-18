package com.yygx.algostruct.leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode.19删除链表的倒数第n个节点
 * <p>
 *     给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * </p>
 */
public class LeetCode19 {


    /**
     * 计算链表长度
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode quick = node;
        ListNode slow = node;
        int size = 0;
        while (quick != null){
            quick = quick.next;
            size++;
        }
        int index = size - n - 1;
        if(index < 0) return head.next;
        for (int i = 0; i < index; i++) {
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return node;
    }


    /**
     * 栈
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndStack(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode current = dummy;
        while (current != null){
            stack.push(current);
            current = current.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return dummy.next;
    }


    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndPointTwo(ListNode head, int n) {
        ListNode quick = head;
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }
        while (quick != null){
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }



    public ListNode removeNthFromEndRecursion(ListNode head,int n){
        ListNode dummy = new ListNode(-1,head);
        recursion(dummy,n);
        return dummy.next;
    }

    private int recursion(ListNode node, int n) {
        if(node == null) return 0;
        int nWhere = recursion(node.next,n);
        if(nWhere == n){   // 这里倒数第n个返回出来，之后进入到倒数第n+1的方法里进行的删除
            node.next = node.next.next;
        }
        // 因为是删除倒数的元素，所以先递归，后返回，这样实现从后面开始计数
        return nWhere + 1;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode node = new LeetCode19().removeNthFromEndRecursion(node1, 1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

}