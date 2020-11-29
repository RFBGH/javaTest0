package com.example.javatest.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class updateMatrix {

    private static class Node{
        int i;
        int j;
        int step;

        public Node(int i, int j, int step) {
            this.i = i;
            this.j = j;
            this.step = step;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] gone = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0;j < m; j++){
                if(matrix[i][j] == 0){
                    gone[i][j] = true;
                    queue.offer(new Node(i, j, 0));
                }
            }
        }

        int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for(int k = 0; k < 4; k++){

                int i = cur.i + move[k][0];
                int j = cur.j + move[k][1];
                if(i < 0 || i >= n || j < 0 || j >= m){
                    continue;
                }

                if(gone[i][j]){
                    continue;
                }

                gone[i][j] = true;
                matrix[i][j] = cur.step+1;
                queue.offer(new Node(i, j, cur.step+1));
            }
        }

        return matrix;
    }
}
