package com.example.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class convertBST1 {

    public class TreeNode {
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

    int sum = 0;
    private void dfs(TreeNode root){
        if(root == null){
            return ;
        }

        dfs(root.right);
        sum += root.val;
        dfs(root.left);
        root.val = sum;
    }

    public TreeNode convertBST(TreeNode root) {

        if(root == null){
            return root;
        }
        dfs(root);
        return root;
    }
}
