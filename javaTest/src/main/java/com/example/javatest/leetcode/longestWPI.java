package com.example.javatest.leetcode;

import java.util.Stack;

public class longestWPI {

    private boolean fit(int[] hours, int len){

        int left = 0;
        int right = 0;
        int count = 0;
        if(len == 2){
            len++;
        }
        for(right = 0; right < hours.length; right++){

            if(hours[right] > 8){
                count++;

                if(count > len/2){
                    return true;
                }
            }

            if(right - left +1 < len){
                continue;
            }

            if(hours[left] > 8){
                count--;
            }
            left++;
        }
        return false;
    }

    public int longestWPI(int[] hours) {

        int left = 1;
        int right = hours.length+1;
        while(true){
            if(left == right){
                break;
            }
            int mid = (left + right)/2;
            if(fit(hours, mid)){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        if(left == 0){
            return 0;
        }
        return left-1;
    }

    public void test(){
        System.out.println(longestWPI(new int[]{9,6,9}));
    }
}
