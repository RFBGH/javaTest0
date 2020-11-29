package com.example.javatest.leetcode;

import java.util.Arrays;

public class largestPerimeter {

    public int largestPerimeter(int[] A) {

        Arrays.sort(A);
        int n = A.length;
        for(int i = n-1; i >= 2; i--){
            int len = A[i-2] + A[i-1];
            if(len > A[n-1]){
                return len + A[i];
            }
        }
        return 0;
    }

}
