package com.yygx.algostruct.leetcode;


/**
 * LeetCode.142环形链表2
 * <p>
 *     给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表
 * </p>
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                slow = head;
                while (true){
                    if(slow == quick){
                        return slow;
                    }
                    slow = slow.next;
                    quick = quick.next;
                }
            }
        }
        return null;
    }



    public ListNode detectCycle2(ListNode head){
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick){
                slow = head;
                while (slow != quick){
                    slow = slow.next;
                    quick = quick.next;
                }
                return slow;
            }
        }
        return null;
    }



    public static void main(String[] args) {
        LeetCode142 leetCode142 = new LeetCode142();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node5;

        ListNode node = leetCode142.detectCycle2(node1);
        System.out.println(node);

    }
}