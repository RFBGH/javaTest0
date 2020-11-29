package com.example.javatest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class convertBST {

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

    private List<TreeNode> list = new ArrayList<>();
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }

        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }

    public TreeNode convertBST(TreeNode root) {

        if(root == null){
            return root;
        }

        dfs(root);

        List<Integer> sum = new ArrayList<>();
        for(TreeNode node : list){
            if(sum.isEmpty()){
                sum.add(node.val);
            }else{
                sum.add(sum.get(sum.size()-1) + node.val);
            }
        }

        int allSum = sum.get(sum.size()-1);
        for(int i = 0; i < list.size(); i++){
            TreeNode node = list.get(i);
            if(i == 0){
                node.val = allSum;
            }else{
                node.val = allSum - sum.get(i-1);
            }
        }
        return root;
    }
}
