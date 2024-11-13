package com.yygx.algostruct.leetcode;




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


    /**
     * 反转链表方法4
     * <p>
     *     从链表每次拿到第二个节点，将其从链表断开，插入头部，直到为null
     *     <p>设置指针，o1和o2，分别指向第一和第二节点</p>
     *     <p>将o2节点从链表断开，即o1节点指向第三节点</p>
     *     <p>o2节点链入链表头部</p>
     *     <p>n1指向o2</p>
     *     <p>o2指向o1的下一个节点</p>
     * </p>
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode oldHead) {
        // 空链表和只有一个节点，直接返回这个节点
        if (oldHead == null || oldHead.next == null) {
            return oldHead;
        }
        ListNode newHead = null;  // 新的链表头
        ListNode tempHead = oldHead;  // 当前遍历节点

        while (tempHead != null) {
            ListNode nextNode = tempHead.next;  // 保存下一个节点
            tempHead.next = newHead;  // 反转当前节点的指向
            newHead = tempHead;  // 将新头节点指向当前节点
            tempHead = nextNode;  // 移动到下一个节点
        }

        return newHead;  // 返回新的头节点
    }



    public ListNode reverseList5(ListNode head){
        if(head == null || head.next == null) return head;
        // 定义一个空的 ListNode n1，作为新的头节点
        ListNode n1 = null;
        // 遍历链表，直到 head 为 null，表示已经遍历到链表的末尾
        while (head != null){
            // 保存当前节点的下一个节点，防止链表断裂
            ListNode next = head.next;
            // 将当前节点的 next 指向 n1，相当于将当前节点插入到新的链表的前端
            head.next = n1;
            // 更新 n1 为当前节点，作为新的链表头
            n1 = head;
            // 继续遍历下一个节点
            head = next;
        }
        // 返回反转后的链表头节点
        return n1;
    }


    public ListNode reverseList6(ListNode head){
        ListNode pre = null;  // 前驱节点
        ListNode current = head;  // 记录当前节点
        while (head != null){
            head = head.next;   // 移动节点
            current.next = pre;   // 当前节点
            pre = current;    // 前驱指向当前
            current = head;   // 当前指向head
        }
        return pre;  // 返回前驱
    }




    /**
     * 反转链表，递归
     * @param point
     * @return
     */
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

        ListNode reverseList2 = leetCode206.reverseList4(reverseList);
        System.out.println(reverseList2);


        ListNode node = leetCode206.reverseList5(reverseList2);
        System.out.println(node);


    }
}