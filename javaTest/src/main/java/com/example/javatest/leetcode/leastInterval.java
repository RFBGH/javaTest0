package com.example.javatest.leetcode;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class leastInterval {


    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];

        for(int i = 0; i < tasks.length; i++){
            counts[tasks[i] - 'A']++;
        }

        int kill = 0;
        int time = 0;
        while(true){

            Arrays.sort(counts);

            int slice = n + 1;
            for(int i = 25; i >= 0; i--){
                if(counts[i] == 0){
                    continue;
                }

                counts[i]--;
                slice--;
                kill++;
                time++;
                if(slice == 0){
                    break;
                }
            }

            if(kill == tasks.length){
                break;
            }

            time += slice;
        }

        Lock lock = new ReentrantLock();
        lock.lock();

        return time;
    }

    public void test(){

        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B','C','C','C', 'D', 'D', 'E'}, 2));

        int[] a = new int[]{};
        int[] b = new int[]{};
        Stack<Integer> stack = new Stack<>();
        int curBIndex = 0;
        for(int i = 0; i < a.length; i++){

            stack.push(a[i]);
            while (!stack.isEmpty() && stack.peek() == b[curBIndex]){
                stack.pop();
                curBIndex++;
            }
        }

        stack.isEmpty();

    }
}
