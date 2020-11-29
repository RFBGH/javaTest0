package com.example.javatest.leetcode;

public class findPoisonedDuration {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if(timeSeries.length == 0){
            return 0;
        }

        int sum = 0;

        for(int i = 1; i < timeSeries.length; i++){
            int cut  = timeSeries[i] - timeSeries[i-1];
            if(cut >= duration){
                sum += duration;
            }else{
                sum += cut;
            }
        }
        sum += duration;

        return sum;
    }

}
