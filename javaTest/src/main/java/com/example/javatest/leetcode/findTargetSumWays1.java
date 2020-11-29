package com.example.javatest.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class findTargetSumWays1 {

    public static class Node{
        int index;
        int sum;

        public Node(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }

    public int findTargetSumWays(int[] nums, int S) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        int result = 0;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.index == nums.length){
                if(cur.sum == S){
                    result++;
                }
            }else{
                int index = cur.index+1;
                queue.offer(new Node(index, cur.sum+nums[cur.index]));
                queue.offer(new Node(index, cur.sum-nums[cur.index]));
            }
        }

        return result;
    }

    public void test(){

        System.out.println(findTargetSumWays(new int[]{35,34,21,14,46,49,36,7,17,39,41,12,38,18,8,31,10,22,39,11}, 26));
    }
}
