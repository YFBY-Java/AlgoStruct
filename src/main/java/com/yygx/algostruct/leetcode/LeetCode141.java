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
        return false;
    }

}


