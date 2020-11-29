package com.example.javatest.leetcode;

public class singleNonDuplicate {

    public int singleNonDuplicate1(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int n = nums.length;
        for(int i = 0; i < n-1; i+=2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[n-1];
    }

    public int singleNonDuplicate(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;
        while (true){

            if(left == right){
                return nums[left];
            }

            int mid = (left + right) / 2;
            if(mid % 2 == 0){
                mid--;
            }

            if(nums[mid] == nums[mid-1]){
                left = mid+1;
            }else if(nums[mid] == nums[mid+1]){
                right = mid-1;
            }else{
                return nums[mid];
            }
        }
    }

    public void test(){
        System.out.println(singleNonDuplicate(new int[]{1,1,2,4,4}));
    }
}
