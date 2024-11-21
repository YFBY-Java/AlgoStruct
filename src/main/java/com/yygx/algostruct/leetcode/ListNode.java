package com.yygx.algostruct.leetcode;



public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode node) {
        this.val = val;
        this.next = node;
    }







    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[");
        ListNode p = this;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) {
                sb.append(",");
            }
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
//        return String.valueOf(this.val);
    }



}