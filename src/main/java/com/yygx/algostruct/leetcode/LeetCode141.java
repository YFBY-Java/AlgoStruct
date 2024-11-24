package com.yygx.algostruct.leetcode;


/**
 * 141.环形链表
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    public boolean hasCycle2(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                return true;
            }
        }
        return false;
    }

}



