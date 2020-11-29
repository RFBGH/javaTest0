package com.example.javatest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class removeBoxes {

    private Map<Integer, Integer> map = new HashMap<>();
    private int dfs(int[] boxes){

        int key = 0;
        for(int i : boxes){
//            if(i == 0){
//                continue;
//            }
            key = key*1000+i;
        }

        System.out.println(key);

        if(key == 0){
            return 0;
        }

        if(map.containsKey(key)){
            return map.get(key);
        }

        int max = 0;
        for(int i = 0; i < boxes.length; i++){
            if(boxes[i] == 0){
                continue;
            }

            int temp = boxes[i];
            List<Integer> list = new ArrayList<>();
            list.add(i);

            int j = i+1;
            while (j < boxes.length){

                if(boxes[j] == 0){
                    j++;
                    continue;
                }

                if(boxes[j] == boxes[i]){
                    list.add(j);
                    j++;
                    continue;
                }

                break;
            }

            for(Integer k : list){
                boxes[k] = 0;
            }

            int sum = list.size()*list.size() + dfs(boxes);
            if(max < sum){
                max = sum;
            }

            for(Integer k : list){
                boxes[k] = temp;
            }

            i = j-1;
        }

        map.put(key, max);
        return max;
    }

    public int removeBoxes(int[] boxes) {
        return dfs(boxes);
    }

    public void test(){
        System.out.println(removeBoxes(new int[]{3,8,8,5,5,3,9,2,4,4,6,5,8,4,8,6,9,6,2,8,6,4,1,9,5,3,10,5,3,3,9,8,8,6,5,3,7,4,9,6,3,9,4,3,5,10,7,6,10,7}));
    }

}
