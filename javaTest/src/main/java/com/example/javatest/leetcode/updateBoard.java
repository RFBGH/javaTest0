package com.example.javatest.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class updateBoard {

    public static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {

        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        boolean[][] gone = new boolean[board.length][board[0].length];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(click[0], click[1]));
        gone[click[0]][click[1]] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int bomb = 0;
            List<Node> newNodes = new ArrayList<>();
            for (int k = 0; k < 8; k++) {
                int i = cur.i + move[k][0];
                int j = cur.j + move[k][1];
                if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
                    continue;
                }

                if(board[i][j] == 'M'){
                    bomb++;
                }

                if(board[i][j] != 'E'){
                    continue;
                }

                if(gone[i][j]){
                    continue;
                }

                newNodes.add(new Node(i, j));
            }

            if(bomb > 0){
                board[cur.i][cur.j] = (char)('0'+bomb);
            }else{
                board[cur.i][cur.j] = 'B';
                queue.addAll(newNodes);
                for(Node node : newNodes){
                    gone[node.i][node.j] = true;
                }
            }
        }

        return board;
    }

}
