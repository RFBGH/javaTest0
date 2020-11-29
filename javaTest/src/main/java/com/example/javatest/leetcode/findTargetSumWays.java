package com.example.javatest.leetcode;

public class findTargetSumWays {

    private int dfs(int[] nums, int sum, int index, int s){

        if(index == nums.length){
            if(sum == s){
                return 1;
            }else{
                return 0;
            }
        }

        return dfs(nums, sum+nums[index], index+1, s) + dfs(nums, sum-nums[index], index+1, s);
    }

    int[][] map;
    int allSum;

    private int dfs2(int[] nums, int sum, int index, int s){

        if(index == nums.length){
            if(sum == s){
                return 1;
            }else{
                return 0;
            }
        }

        if(map[sum+allSum][index] != -1){
            return map[sum+allSum][index];
        }

        int result = dfs2(nums, sum+nums[index], index+1, s) + dfs2(nums, sum-nums[index], index+1, s);
        map[sum+allSum][index] = result;
        return result;
    }

    public int findTargetSumWays(int[] nums, int S) {

        allSum = 0;
        for(int i = 0; i < nums.length; i++){
            allSum += nums[i];
        }
        allSum++;

        map = new int[allSum*2+5][nums.length];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < nums.length; j++){
                map[i][j] = -1;
            }
        }

        return dfs2(nums, 0, 0, S);
    }

    public void test(){

        System.out.println(findTargetSumWays(new int[]{35,34,21,14,46,49,36,7,17,39,41,12,38,18,8,31,10,22,39,11}, 26));
    }
}
