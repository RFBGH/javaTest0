package com.example.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class findBottomLeftValue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int dfs(List<TreeNode> parents){

        List<TreeNode> sons = new ArrayList<>();
        for(TreeNode parent: parents){
            if(parent.left != null){
                sons.add(parent.left);
            }

            if(parent.right != null){
                sons.add(parent.right);
            }
        }

        if(sons.isEmpty()){
            return parents.get(0).val;
        }else{
            return dfs(sons);
        }
    }

    public int findBottomLeftValue(TreeNode root) {

        List<TreeNode> parents = new ArrayList<>();
        parents.add(root);
        return dfs(parents);
    }
}
