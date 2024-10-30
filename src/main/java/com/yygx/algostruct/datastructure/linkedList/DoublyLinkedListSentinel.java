package com.yygx.algostruct.datastructure.linkedList;


import java.util.Iterator;

/**
 * 带哨兵双链表
 */
public class DoublyLinkedListSentinel implements Iterable<Integer>{

    static class Node{
        Node pre;  // 前驱节点

        int value;   // 节点值

        Node next;   // 后继节点


        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;  // 头哨兵
    private Node tail;  // 尾哨兵


    public DoublyLinkedListSentinel(){
        head = new Node(null,Integer.MAX_VALUE,null);
        tail = new Node(null,Integer.MAX_VALUE,null);
        head.next = tail;
        tail.pre = head;
    }

    private Node findNode(int index){
        int i = -1;
        for(Node pointer = head; pointer!=tail;pointer = pointer.next,i++){
            if(i == index){
                return pointer;
            }
        }
        return null;
    }


    public void insert(int index,int value){
        Node pre = findNode(index-1);
        Node next = null;
        if (pre == null) {
            throw illegalIndex(index);
        }
        next = pre.next;
        Node inserted = new Node(pre, value, next);
        pre.next = inserted;
        next.pre = inserted;
    }


    public void remove(int index,int value){
        Node pre = findNode(index - 1);
        if (pre == null) {
            throw illegalIndex(index);
        }
        Node removed = pre.next;
        if(removed == tail){  // 尾哨兵也不能删
            throw illegalIndex(index);
        }
        Node next = removed.next;
        next.pre = pre;
        pre.next = next;
    }


    public void addLast(int value){
        Node pre = tail.pre;
        Node lastNode = new Node(pre,value,tail);
        pre.next = lastNode;
        tail.pre = lastNode;
    }


    public void removeLast(){
        Node last = tail.pre;
        if(last == head){
            return;
        }
        Node pre = last.pre;
        pre.next = tail;
        tail.pre = pre;
    }



    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = head.next;

            @Override
            public boolean hasNext() {
                return  pointer != tail;
            }

            @Override
            public Integer next() {
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index[%d]", index));
    }
}