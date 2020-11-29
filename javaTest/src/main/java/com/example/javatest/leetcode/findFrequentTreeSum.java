package com.example.javatest.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class findFrequentTreeSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> sumCountMap = new HashMap<>();
    private int dfs(TreeNode root){

        if(root == null){
            return 0;
        }

        int result = dfs(root.left) + dfs(root.right) + root.val;

        Integer count = sumCountMap.get(result);
        if(count == null){
            count = 1;
        }else{
            count++;
        }
        sumCountMap.put(result, count);
        return result;
    }

    public int[] findFrequentTreeSum(TreeNode root) {

        if(root == null){
            return new int[]{};
        }
        dfs(root);

        Collection<Integer> values = sumCountMap.values();
        int max = 0;
        int count = 1;
        for(Integer i : values){
            if(max < i){
                max = i;
                count = 1;
            }else if(max == i){
                count++;
            }
        }

        int[] result = new int[count];
        int resultCount = 0;
        Set<Integer> keys = sumCountMap.keySet();
        for(Integer key : keys){
            int value = sumCountMap.get(key);
            if(value == max){
                result[resultCount++] = key;
            }
        }
        return result;
    }

    public void test(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        findFrequentTreeSum(root);
    }
}
