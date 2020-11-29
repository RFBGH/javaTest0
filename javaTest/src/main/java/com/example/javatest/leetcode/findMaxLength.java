package com.example.javatest.leetcode;

public class findMaxLength {

    public int findMaxLength(int[] nums) {

        if(nums.length == 1 || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int sum = 0;
        int[] map = new int[n*2+2];
        for(int i = 0; i < map.length; i++){
            map[i] = -2;
        }
        map[n] = -1;

        int max = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                sum--;
            }else{
                sum++;
            }

            int key = sum + n;
            if(map[key] != -2){
                if(i - map[key] > max){
                    max = i - map[key];
                }
            }else{
                map[key] = i;
            }
        }

        return max;
    }

    public void test(){
        System.out.println(findMaxLength(new int[]{0, 0}));
    }
}
