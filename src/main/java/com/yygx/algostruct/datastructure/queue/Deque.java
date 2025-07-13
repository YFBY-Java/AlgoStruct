package com.yygx.algostruct.datastructure.queue;


/**
 * 双端队列
 */
public interface Deque<E> {

    // 添加队头元素
    boolean offerFirst(E e);

    // 向队尾添加元素
    boolean offerLast(E e);

    // 获取队头元素并删除
    E pollFirst();

    /**
     * 获取队尾元素并删除
     * @return
     */
    E pollLast();

    /**
     * 获取队头元素
     * @return
     */
    E peekFirst();


    /**
     * 获取队尾元素
     * @return
     */
    E peekLast();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断队列是否已满
     * @return
     */
    boolean isFull();
}
