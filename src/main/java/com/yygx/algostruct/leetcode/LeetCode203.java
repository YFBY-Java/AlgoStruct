package com.yygx.algostruct.leetcode;


/**
 * 根据值删除节点
 */
public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        // 创建一个虚拟头节点，便于处理头节点需要删除的情况
        ListNode node = new ListNode(0, head);
        // 定义一个指针 temp，初始指向虚拟头节点
        ListNode temp = node;
        // 遍历链表，直到遍历到链表的末尾
        while (temp.next != null) {
            // 如果当前节点的下一个节点值等于 val，删除该节点
            if (temp.next.val == val) {
                temp.next = temp.next.next;  // 跳过要删除的节点
            } else {
                temp = temp.next;  // 否则，继续向下遍历
            }
        }
        // 返回去掉虚拟头节点后的链表
        return node.next;
    }

    public ListNode removeElementsRecursion(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val){
            return removeElementsRecursion(head.next, val);
        }else {
            head.next = removeElementsRecursion(head.next, val);
            return head;
        }
    }


    public ListNode removeElementsRecursionPro(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementsRecursionPro(head.next,val);
        if(head.val == val){
            return head.next;
        }else {
            return head;
        }
    }



    public static void main(String[] args) {
        LeetCode203 leetCode203 = new LeetCode203();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(6);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(4);
        node1.next.next.next.next.next = new ListNode(5);
        leetCode203.removeElements(node1, 6);
//        while (node1 != null){
//            System.out.println(node1.val);
//            node1 = node1.next;
//        }
        System.out.println(node1);
        System.out.println(leetCode203.removeElementsRecursion(node1, 5));
        System.out.println(leetCode203.removeElementsRecursionPro(node1, 3));
    }

}