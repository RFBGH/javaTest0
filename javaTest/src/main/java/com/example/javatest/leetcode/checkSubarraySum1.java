package com.example.javatest.leetcode;

public class checkSubarraySum1 {

    public boolean checkSubarraySum(int[] nums, int k) {

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i-1]+nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int result = sum[j]-sum[i]+nums[i];
                if(k == 0){
                    if(result == 0){
                        return true;
                    }
                    continue;
                }
                if(result % k == 0){
                    return true;
                }
            }
        }

        return false;
    }

    public void test(){
        System.out.println(checkSubarraySum(new int[]{0, 0}, 0));
    }
}
