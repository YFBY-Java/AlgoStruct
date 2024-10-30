package com.yygx.algostruct.datastructure.linkedList;



import java.util.Iterator;

/**
 * 双向环形链表
 */
public class DoublyLoopedLinkedList implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = sentinel.next;

            @Override
            public boolean hasNext() {
                return pointer != sentinel;
            }

            @Override
            public Integer next() {
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }

    public static class Node{
        Node pre;
        int value;
        Node next;

        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }


    private Node sentinel = new Node(null,Integer.MAX_VALUE,null);

    public DoublyLoopedLinkedList() {   // 前驱和后继都指向自己
        this.sentinel.pre = this.sentinel;
        this.sentinel.next = this.sentinel;
    }


    public void addFirst(int value){
        Node a = sentinel;   // 首（即哨兵）
        Node b = sentinel.next;   // 尾

        Node first = new Node(a, value, b);
        a.next = first;
        b.pre = a;
    }


    public void addLast(int value){
        Node a = sentinel.pre;
        Node b = sentinel;

        Node last = new Node(a,value,b);
        a.next = last;
        b.pre = last;
    }


    public void removeFirst(){
        Node removed = sentinel.next;
        if(removed == sentinel){
            throw new IllegalArgumentException("非法索引");
        }
        Node next = removed.next;
        next.pre = sentinel;
        sentinel.next = next;
    }


    public void removeLast(){
        Node removed = sentinel.pre;
        if(removed == sentinel){
            throw new IllegalArgumentException("非法索引");
        }
        Node pre = removed.pre;
        pre.next = sentinel;
        sentinel.pre = pre;
    }



    public void removeByValue(int value){
        Node removed = findByValue(value);
        if(removed == null){
            return;
        }
        Node pre = removed.pre;
        Node next = removed.next;
        pre.next = next;
        next.pre = pre;
    }


    public Node findByValue(int value){
        Node pointer = sentinel.next;
        while (pointer != sentinel){
            if(value == pointer.value){
                return pointer;
            }
            pointer = pointer.next;
        }
        return null;
    }
}