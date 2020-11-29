package com.example.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class largestValues {

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

    private List<Integer> result = new ArrayList<>();
    private void dfs(List<TreeNode> parents){

        if(parents.isEmpty()){
            return;
        }

        int max = Integer.MIN_VALUE;
        List<TreeNode> sons = new ArrayList<>();
        for(TreeNode parent : parents){
            if(parent.left != null){
                sons.add(parent.left);
            }

            if(parent.right != null){
                sons.add(parent.right);
            }

            if(parent.val > max){
                max = parent.val;
            }
        }

        result.add(max);
        dfs(sons);
    }

    public List<Integer> largestValues(TreeNode root) {

        if(root == null){
            return result;
        }

        List<TreeNode> parents = new ArrayList<>();
        parents.add(root);
        dfs(parents);
        return result;
    }

}
