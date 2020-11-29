package com.example.javatest.leetcode;

import java.util.Stack;

public class nextGreaterElements1 {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < n; i++){
            while (!stack.isEmpty()){
                int top = stack.pop();
                if(nums[i] > nums[top]){
                    result[top] = nums[i];
                }else{
                    stack.push(top);
                    break;
                }
            }
            stack.push(i);
        }

        for(int i = 0; i < n; i++){
            while (!stack.isEmpty()){
                int top = stack.pop();
                if(nums[i] > nums[top]){
                    result[top] = nums[i];
                }else{
                    stack.push(top);
                    break;
                }
            }
        }

        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        return result;
    }

    public void test(){
        nextGreaterElements(new int[]{1, 2, 1});
    }
}
