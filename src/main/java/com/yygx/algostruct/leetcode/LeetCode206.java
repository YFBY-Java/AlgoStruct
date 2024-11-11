package com.yygx.algostruct.leetcode;


import com.yygx.algostruct.datastructure.linkedList.SinglyLinkedList;
import com.yygx.algostruct.util.Utils;
import org.apache.bcel.generic.ANEWARRAY;

import java.util.List;

/**
 * LeetCode206.反转链表
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        ListNode node = null;
        ListNode point = head;
        while (point != null){
            node = new ListNode(point.val,node);
            point = point.next;
        }
        return node;
    }


    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null){
            head = head.next;
            current.next = pre;
            pre = current;
            current = head;
        }
        return pre;
    }

    public ListNode reverseList3(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);
        while (true) {
            ListNode first = list1.removeFirst();
            if (first == null) {
                break;
            }
            list2.addFirst(first);
        }
        return list2.head;
    }


    public ListNode reverseListRecursion(ListNode point){
        if(point.next == null) return point;  // 表示找到最后一个节点
        ListNode lastNode = reverseListRecursion(point.next);
        point.next.next = point;
        point.next = null;
        return lastNode;
    }


    static class List{
        ListNode head;

        public List(ListNode head){
            this.head = head;
        }
        public void removeFirst(ListNode first){
            first.next = head;
            head = first;
        }

        public ListNode removeFirst(){
            ListNode first = head;
            if(first != null){
                head = first.next;
            }
            return first;
        }

        public void addFirst(ListNode first){
            first.next = head;
            head = first;
        }

    }



    public static void main(String[] args){
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
        LeetCode206 leetCode206 = new LeetCode206();
        System.out.println(o1);
//        ListNode reverseList = leetCode206.reverseList(o1);
//        System.out.println(reverseList);
//        reverseList2(reverseList);

        ListNode reverseList = leetCode206.reverseListRecursion(o1);
        System.out.println(reverseList);

    }
}