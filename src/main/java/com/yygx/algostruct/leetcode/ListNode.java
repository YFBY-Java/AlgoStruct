package com.yygx.algostruct.leetcode;

import java.util.List;

/**
 * @version 1.0
 * @Copyright (c) 合思技术团队 https://www.hosecloud.com/
 * @authur：zhaojiawei zhaojiawei@hosecloud.com
 * @Package com.yygx.algostruct.leetcode
 * @Project：AlgoStruct
 * @date 2024/11/1 上午10:35
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
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