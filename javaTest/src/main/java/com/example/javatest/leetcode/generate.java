package com.example.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class generate {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0){
            return result;
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        if(numRows == 1){
            return result;
        }

        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        result.add(list);
        if(numRows == 2){
            return result;
        }

        for(int i = 1; i < numRows-1; i++){

            list = new ArrayList<>();
            list.add(1);
            for(int j = 0; j < i; j++){
                int value = result.get(result.size()-1).get(j) + result.get(result.size()-1).get(j+1);
                list.add(value);
            }
            list.add(1);
            result.add(list);
        }

        return result;
    }

    public void test(){
        generate(5);
    }

}
