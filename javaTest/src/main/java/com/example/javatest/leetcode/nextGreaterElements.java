package com.example.javatest.leetcode;

public class nextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){

            int j;
            for(j = (i+1)%n; j != i; j = (j+1)%n){
                if(nums[j] > nums[i]){
                    result[i] = nums[j];
                    break;
                }
            }

            if(j == i){
                result[i] = -1;
            }
        }
        return result;
    }
}
