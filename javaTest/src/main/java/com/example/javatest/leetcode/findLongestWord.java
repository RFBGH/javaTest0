package com.example.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class findLongestWord {

    private boolean isFit(String dst, String src){

        if(dst.length() > src.length()){
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < dst.length() && j < src.length() - (dst.length()-i)){
            if(dst.charAt(i) == src.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }

        return i == dst.length();
    }

    private boolean smaller(String s1, String s2){
        int n = s1.length();
        for(int i = 0; i < n; i++){

            if(s1.charAt(i) == s2.charAt(i)){
                continue;
            }

            if(s1.charAt(i) < s2.charAt(i)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public String findLongestWord(String s, List<String> d) {

        String target = "";

        for(String t : d){
            if(!isFit(t, s)){
                continue;
            }

            if(t.length() < target.length()){
                continue;
            }

            if(t.length() > target.length()){
                target = t;
            }else{
                if(smaller(t, target)){
                    target = t;
                }
            }
        }

        return target;
    }

    public void test(){
        List<String> strings = new ArrayList<>();
        System.out.println(findLongestWord("abpcplea", strings));
    }
}
