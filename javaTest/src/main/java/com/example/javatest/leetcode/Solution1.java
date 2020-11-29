package com.example.javatest.leetcode;

import java.util.Random;

public class Solution1 {

    private Random rd;
    private int[] w;
    private int[] sums;
    private int sum = 0;

    public Solution1(int[] w) {
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
        for(int i = 0; i < w.length; i++){
            if(temp > w[i]){
                temp -= w[i];
            }else{
                return i;
            }
        }
        return 0;
    }
}
