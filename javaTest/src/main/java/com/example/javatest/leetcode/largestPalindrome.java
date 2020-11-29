package com.example.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class largestPalindrome {

    private int dfs(int num1, int num2, int index, int n){

        if(index == n) {
            long l = (long) num1 * (long) num2;
            List<Integer> list = new ArrayList<>();

            long cur = l;
            while (cur != 0){
                list.add((int)(cur % 10));
                cur /= 10;
            }

            int i = 0;
            int j = list.size()-1;
            while (i < j){
                if(list.get(i).equals(list.get(j))){
                    i++;
                    j--;
                }else{
                    return 0;
                }
            }

            l = l % 1337;

            return (int)l;
        }

        for(int i = 9; i >= 0; i--){
            if(num1 == 0 && i == 0){
                continue;
            }
            for(int j = 9; j >= 0; j--){
                if(num2 == 0 && j == 0){
                    continue;
                }

                int result = dfs(num1*10+i, num2*10+j, index+1, n);
                if(result != 0){
                    return result;
                }
            }
        }

        return 0;
    }

    public int largestPalindrome(int n) {
        return dfs(0, 0, 0, n);
    }

    public void test(){
        System.out.println(largestPalindrome(7));
    }
}
