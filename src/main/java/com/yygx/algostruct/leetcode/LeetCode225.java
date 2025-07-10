package com.yygx.algostruct.leetcode;


import com.yygx.algostruct.datastructure.queue.ArrayQueue3;

/**
 * LeetCode.225 用列实现栈
 * <P>
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 *
 * 注意：
 *
 * 你只能使用队列的标准操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 */
public class LeetCode225 {


    ArrayQueue3<Integer> queue = new ArrayQueue3<>(100);
    private int size = 0;

    /*
     * push 添加
     *      将新加入的元素 前面的所有元素从队列头移动到队列尾
     * pop  移除
     *      直接移除队列头元素
     */

    public void push(int x) {
        queue.offer(x);  // 加入新元素
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }

    public int pop() {
        Integer poll = queue.poll();
        size--;
        return poll;
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}