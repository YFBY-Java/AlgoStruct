package com.yygx.algostruct.datastructure.queue;


/**
 * 二叉树
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(TreeNode left,int val,TreeNode right){
        this.left = left;
        this.val = val;
        this.right = right;
    }

    public TreeNode(int val){
        this.val = val;
    }


    @Override
    public String toString(){
        return String.valueOf(this.val);
    }
}