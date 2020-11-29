package com.example.javatest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class findPairs {

    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;

        int count = 0;
        int i = 0;
        int j = i+1;

        while (true){

            if(j <= i){
                j = i+1;
            }

            while (j < n && nums[j] - nums[i] < k){
                j++;
            }

            if(j >= n){
                break;
            }

            if(nums[j] - nums[i] == k){
                count++;
            }

            i++;
            while (i < n  && nums[i] == nums[i-1]){
                i++;
            }
        }

        return count;
    }

    public void test(){
        System.out.println(findPairs(new int[]{1,1,1,1,1}, 0));
    }
}
