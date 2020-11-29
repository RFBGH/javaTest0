package com.example.javatest.leetcode;

import java.util.Random;

public class Solution {

    private Random rd;
    private int[] w;
    private int[] sums;
    private int sum = 0;

    public Solution(int[] w) {
        rd = new Random(System.currentTimeMillis());
        this.w = w;
        sums = new int[w.length];
        for(int i = 0; i < w.length; i++){
            sum += w[i];
            sums[i] = sum;
        }
    }

    public int pickIndex() {
        int temp = rd.nextInt(sum)+1;

        int left = 0;
        int right = w.length;
        while (true){

            if(left == right){
                return left;
            }

            int mid = (left + right) / 2;
            if(temp > sums[mid]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
    }
}
