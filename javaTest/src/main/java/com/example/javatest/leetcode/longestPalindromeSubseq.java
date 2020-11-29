package com.example.javatest.leetcode;

public class longestPalindromeSubseq {

    public int longestPalindromeSubseq(String S) {

        int n = S.length();
        if(n == 1){
            return 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = n-1; i >= 0; i--){
            sb.append(S.charAt(i));
        }
        String rS = sb.toString();

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            if(S.charAt(i) == rS.charAt(0)){
                dp[i][0] = 1;
            }else{
                if(i > 0){
                    dp[i][0] = dp[i-1][0];
                }
            }
        }

        for(int j = 0;j  < n; j++){
            if(S.charAt(0) == rS.charAt(j)){
                dp[0][j] = 1;
            }else{
                if(j > 0){
                    dp[0][j] = dp[0][j-1];
                }
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                int max;
                if(S.charAt(i) == rS.charAt(j)){
                    max = dp[i-1][j-1] + 1;
                }else{
                    max = dp[i][j-1];
                    if(max < dp[i-1][j]){
                        max = dp[i-1][j];
                    }
                }
                dp[i][j] = max;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n-1; i++){
            if(dp[i][n-2-i]*2 > max){
                max = dp[i][n-2-i]*2;
            }
        }

        for(int i = 0; i < n-1; i++){
            int value = 1;
            if(i > 0){
                value += dp[i-1][n-2-i]*2;
            }
            if(value > max){
                max = value;
            }
        }

        return max;
    }

    public void test(){
        System.out.println(longestPalindromeSubseq("ac"));
    }

}
