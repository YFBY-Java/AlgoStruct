package com.yygx.algostruct.leetcode;


public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0);
        ListNode temp = sumList;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = carry + val1 + val2;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return sumList.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0);
        ListNode temp = sumList;
        int carry = 0;   // 记录进位
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = carry + val1 + val2;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {   // 有进位需要再增加一个节点
            temp.next = new ListNode(carry);
        }
        return sumList.next;
    }


    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;  // 进位
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = carry + val1 + val2;
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            current = current.next = new ListNode(sum % 10);
        }
        return dummy.next;
    }


    /**
     * 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        return addTwo(l1, l2, 0);
    }

    private ListNode addTwo(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            // 如果进位了，就创建一个节点
            return carry != 0 ? new ListNode(carry) : null;
        }
        if (l1 == null) { // 如果l1是空的，说明l2一定不是空
            l1 = l2;   // 交换 l1与l2，保证l1非空，简化代码
            l2 = null;
        }
        int sum = carry + l1.val + (l2 != null ? l2.val : 0);
        l1.val = sum % 10;   // 将和保存在l1
        l1.next = addTwo(l1.next, (l2 != null ? l2.next : null),sum / 10);
        return l1;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        LeetCode2 leetCode2 = new LeetCode2();
        ListNode sumList = leetCode2.addTwoNumbers(l1, l2);
        while (sumList != null) {
            System.out.println(sumList.val);
            sumList = sumList.next;
        }
    }
}






