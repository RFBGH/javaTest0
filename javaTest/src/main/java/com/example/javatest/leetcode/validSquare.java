package com.example.javatest.leetcode;

public class validSquare {


    private int distance(int[] p1, int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int dist1 = distance(p1, p2);
        int dist2 = distance(p1, p3);
        int dist3 = distance(p1, p4);

        if(dist1 == 0 || dist2 == 0 || dist3 == 0){
            return false;
        }

        if(dist1 == dist2 && dist1+dist2 == dist3){
            return true;
        }

        if(dist1 == dist3 && dist1+dist3 == dist2){
            return true;
        }

        if(dist2 == dist3 && dist2+dist3 == dist1){
            return true;
        }

        return false;
    }

    public void test(){

        System.out.println(validSquare(new int[]{0, 1}, new int[]{1, 2}, new int[]{0, 2}, new int[]{0, 0}));
    }
}
