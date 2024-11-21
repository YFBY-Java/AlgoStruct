package com.yygx.algostruct.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode23.合并K个升序链表
 */
public class LeetCode23 {


    /**
     * 最小堆法
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsHeap(ListNode[] lists) {
        return null;   //
    }


    /**
     * 顺序合并
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoLists(ans, list);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }


    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[10];
        for (int i = 0; i < 10; i++) {
            listNodes[i] = Utils.generateRandomSortedLinkedList();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(listNodes[i]);
        }

        LeetCode23 leetCode23 = new LeetCode23();
        ListNode ans = leetCode23.mergeKLists(listNodes);
        System.out.println("合并结果：" + ans);

    }

    private static void test() {
        LeetCode23 leetCode23 = new LeetCode23();

        // 测试用例 1：多个空链表
        ListNode[] case1 = {null, null, null};
        System.out.println("测试用例 1：多个空链表");
        System.out.println("输入：" + Arrays.toString(case1));
        System.out.println("输出：" + leetCode23.mergeKLists(case1));

        // 测试用例 2：部分空链表
        ListNode[] case2 = {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                null,
                new ListNode(2, new ListNode(6))
        };
        System.out.println("\n测试用例 2：部分空链表");
        System.out.println("输入：" + Arrays.toString(case2));
        System.out.println("输出：" + leetCode23.mergeKLists(case2));

        // 测试用例 3：所有链表有序
        ListNode[] case3 = {
                new ListNode(1, new ListNode(3, new ListNode(5))),
                new ListNode(2, new ListNode(4, new ListNode(6))),
                new ListNode(0, new ListNode(7, new ListNode(8)))
        };
        System.out.println("\n测试用例 3：所有链表有序");
        System.out.println("输入：" + Arrays.toString(case3));
        System.out.println("输出：" + leetCode23.mergeKLists(case3));

        // 测试用例 4：只有一个链表
        ListNode[] case4 = {
                new ListNode(1, new ListNode(3, new ListNode(5)))
        };
        System.out.println("\n测试用例 4：只有一个链表");
        System.out.println("输入：" + Arrays.toString(case4));
        System.out.println("输出：" + leetCode23.mergeKLists(case4));

        // 测试用例 5：无链表输入
        ListNode[] case5 = {};
        System.out.println("\n测试用例 5：无链表输入");
        System.out.println("输入：" + Arrays.toString(case5));
        System.out.println("输出：" + leetCode23.mergeKLists(case5));
    }


}