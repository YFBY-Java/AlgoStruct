package com.yygx.algostruct.linkedList;


import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * 链表
 */
public class SinglyLinkedList implements Iterable<Integer> {


    /*
    链表是数据元素的线性集合，每个元素指向下一个元素，元素存储上并不连续
    单向链表：每个元素只知道下个元素，即只有一个指向下个元素的指针
    双向链表：每个元素有两个指针，指向上个元素和下个元素
    循环链表：通常的链表尾节点指针指向的都是null，而循环链表的尾指针指向头节点

    哨兵：不存储数据，通常用作头尾，用来简化边界判断

    性能：
    随机访问性能：根据index查找，时间复杂度 O(n)
    插入/删除：O(n)
    插入和删除时不需要移动其他元素
     */

    private Node head = null;   // 头指针


    /**
     * 迭代器遍历
     *
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {

        // 匿名内部类
        return new Iterator<Integer>() {
            Node pointer = head;

            // 检查是否存在下一个元素
            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            // 返回当前值，并指向下一个元素
            @Override
            public Integer next() {
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }

    /*
    static：
    内部类使用外部类的成员变量时，不能加static
    static不能调非static
    内部类static能加就加
     */
    private static class Node {   // 内部类，对外隐藏实现细节
        int value; // 值
        Node next;  // 指向下一个节点


        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value) {
//        Node node = new Node(value, null);
/*        if (head.next == null) {
            // 链表为空
            head.next = node;
        } else {
            // 链表非空
            node.next = head.next;
            head.next = node;
        }*/

        // 优化
        head = new Node(value, head);

    }



/*    public void loop(){
        Node pointer = head;
        while (pointer != null){
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }*/

    /**
     * 遍历链表 while
     */
    public void loopWhile(Consumer<Integer> consumer) {
        Node pointer = head;
        while (pointer != null) {
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }


    /**
     * 遍历链表 for
     */
    public void loopFor(Consumer<Integer> consumer) {
        for (Node pointer = head; pointer != null; pointer = pointer.next) {
            consumer.accept(pointer.value);
        }
    }


    /**
     * 寻找最后一个节点
     *
     * @return
     */
    private Node findLast() {
        if (head == null) {
            return null;
        }
        Node pointer;
        for (pointer = head; pointer.next != null; pointer = pointer.next){

        }
        return pointer;
    }


    /**
     * 添加到最后一个节点
     *
     * @return
     */
    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }


    /**
     * 返回指定索引元素
     */
    private Node findNode(int index){
        int i = 0;
        for (Node pointer = head;pointer!= null;pointer = pointer.next,i++){
            if(i == index){
                return pointer;
            }
        }
        return null;
    }

    /**
     * 返回指定索引的值
     * @param index
     * @return
     */
    public int get(int index){
        Node node = findNode(index);
        if(node == null){
            throw illegalIndex(index);
        }
        return node.value;
    }


    /**
     * 向索引位置插入
     */
    public void insert(int index,int value){
        if(index == 0){
            addFirst(value);
            return;
        }
        Node pre = findNode(index - 1);
        if(pre == null){
            throw illegalIndex(index);
        }
        pre.next = new Node(value,pre.next);
    }


    /**
     * 删除第一个元素
     */
    public void removeFirst(){
        if(head == null){
            throw illegalIndex(0);
        }
        head = head.next;
    }


    /**
     * 按索引删除
     * @param index
     */
    public void remove(int index){
        if(index == 0){
            removeFirst();
        }
        Node pre = findNode(index - 1);
        if(pre == null){
            throw illegalIndex(index);
        }
        Node remove = pre.next;
        if(remove == null){
            throw illegalIndex(index);
        }
        pre.next = remove.next;
//        pre.next = pre.next.next;
    }


    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index[%d]", index));
    }

}