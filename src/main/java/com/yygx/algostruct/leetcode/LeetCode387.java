package com.yygx.algostruct.leetcode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode387.字符串中的唯一字符
 * <P>
 *     给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * </P>
 */
public class LeetCode387 {



    public int firstUniqChar(String s) {
        Map<Character,Integer> position = new HashMap<Character,Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            // map中不存在映射，加入到map中
            if(!position.containsKey(ch)){
                position.put(ch,i);
                queue.offer(new Pair(ch,i));
            }else {
                // 存在，将这个字符标记为重复
                position.put(ch,-1);
                // 从队列中去除所有重复的字符
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

    class Pair {
        char ch;
        int pos;

        public Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }

}