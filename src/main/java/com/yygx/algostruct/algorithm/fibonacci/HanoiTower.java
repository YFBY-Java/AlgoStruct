package com.yygx.algostruct.algorithm.fibonacci;


import org.springframework.util.StopWatch;

import java.util.LinkedList;

/**
 * 汉诺塔
 */
public class HanoiTower {

    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();


    static void init(int n){
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }


    /**
     *
     * @param n  圆盘个数
     * @param a  源柱子
     * @param b  中间柱子
     * @param c  目标柱子
     */
    static void move(int n,LinkedList<Integer> a,
                     LinkedList<Integer> b,
                     LinkedList<Integer> c){
        if(n == 0) return;   // 没有盘子需要移动
        move(n-1,a,c,b);   // 把n-1个盘子 从 a 借助 c 移动到 b
        c.addLast(a.removeLast());
        print();
        move(n-1,b,a,c);   // 把n-1个盘子，从b 借助a 移动到 c
    }


    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        init(20);
        print();
        stopWatch.start();
        move(20,a,b,c);
        stopWatch.stop();
        print();
        System.out.println(stopWatch.prettyPrint());
    }


    private static void print() {
        System.out.println("------------------");
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        System.out.println("c:"+c);
    }
}