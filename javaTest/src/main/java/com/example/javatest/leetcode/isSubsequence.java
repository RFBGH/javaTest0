package com.example.javatest.leetcode;

public class isSubsequence {

    private boolean isSubSeq(String src, String dst){

        if(dst.length() > src.length()){
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < src.length() - (dst.length() - j)+1 && j < dst.length()){

            if(src.charAt(i) == dst.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }

        return j == dst.length();
    }

    public int findLUSlength(String[] strs) {

        int n = strs.length;
        String target = "";
        for(int i = 0; i < n; i++){
            int j;
            for(j = 0; j < n; j++){
                if(i == j){
                    continue;
                }

                if(isSubSeq(strs[j], strs[i])){
                    break;
                }
            }

            if(j != n){
                continue;
            }

            if(strs[i].length() > target.length()){
                target = strs[i];
            }
        }

        if(target.equals("")){
            return -1;
        }

        return target.length();
    }

    public void test(){
        System.out.println(findLUSlength(new String[]{"aaa", "aaa", "aa"}));
    }

}
