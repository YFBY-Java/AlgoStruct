package com.yygx.algostruct.leetcode;


import com.yygx.algostruct.datastructure.queue.ArrayQueue3;
import com.yygx.algostruct.datastructure.queue.LinkedListQueue;

import java.util.*;

/**
 * LeetCode102.二叉树的层序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * </p>
 */
public class LeetCode102 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /*
    1.使用队列queue来实现二叉树的层级遍历（BFS）
    2.每次进入while循环，表示新的一层开始
    3.通过queue.size() 记录当前层节点数，保证 for 循环只处理这一层
    4.在for循环内：
        （1）取出节点加入当前层结果
        （2）将其左右子节点加入队列，以供下一层遍历
    5.每层遍历后将其值列表加入 结果集result中
    6.最终返回result，即每层节点组成的二维列表
     */

    /**
     * 使用队列层序遍历二叉树
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();  // 定义最终结果列表，每个元素是一个代表某一层节点值的列表
        if(root == null){    // 如果根节点为空，直接返回空结果
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  // 使用队列实现广度优先遍历
        queue.offer(root);  // 将根节点入队
        while (!queue.isEmpty()){    // 当队列不为空时，继续遍历
            List<Integer> level = new ArrayList<>();   // 用于存储当前层的所有节点值
            int currentLevelSize = queue.size();    // 当前层的节点数量
            for (int i = 0; i < currentLevelSize; i++) {    // 遍历当前层的所有节点
                TreeNode node = queue.poll();    // 出队当前节点
                if (node != null) {
                    level.add(node.val);    // 将当前节点的值加入当前层列表
                    if(node.left != null){    // 如果左子节点不为空，入队
                        queue.offer(node.left);
                    }
                    if(node.right != null){     // 如果右子节点不为空，入队
                        queue.offer(node.right);
                    }
                }
            }
            result.add(level);   // 当前层遍历完成后加入结果列表
        }
        return result;  // 返回按层遍历结果
    }


    /**
     * 使用队列层序遍历二叉树  Z字形遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderZ(TreeNode root) {
        // 创建一个数组用来保存最终结果
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);  // 把二叉树第一层节点入队
        int countNum = 1;  // 当前层节点数
        boolean odd = true; // 表示当前层是否是奇数层
        while (!queue.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();
            int nextNum = 0;  // 下一层节点数
            for (int i = 0; i < countNum; i++) {
                TreeNode node = queue.poll();

                if(odd){  // 如果是奇数层，向尾部添加
                    level.offerLast(node.val);
                }else {
                    level.offerFirst(node.val);
                }
                if(node.left != null){  // 将左孩子加入队列
                    queue.offer(node.left);
                    nextNum++;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    nextNum++;
                }
            }
            odd = !odd;
            result.add(level);
            countNum = nextNum;  // 更新下一层的节点数
        }
        return result;
    }

    public static void main(String[] args) {
        // 构建一棵示例二叉树：
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        LeetCode102 solution = new LeetCode102();

        // 测试 Z 字形层序遍历
        List<List<Integer>> zOrderResult = solution.levelOrderZ(root);
        System.out.println("Z 字形层序遍历结果：");
        for (List<Integer> level : zOrderResult) {
            System.out.println(level);
        }

        // 同时测试普通层序遍历
        List<List<Integer>> normalResult = solution.levelOrder(root);
        System.out.println("普通层序遍历结果：");
        for (List<Integer> level : normalResult) {
            System.out.println(level);
        }
    }


}