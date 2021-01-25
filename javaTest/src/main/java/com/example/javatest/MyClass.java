package com.example.javatest;

import com.example.javatest.leetcode.*;
import com.example.javatest.lock.CustomReentrantLock;
import com.example.javatest.reflect.Bean;
import com.example.javatest.reflect.ReflectTest;

import java.lang.reflect.Proxy;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyClass {

    public static class A{
        int a = 1;

        public void test(){
            System.out.println("a");
        }
    }

    public static class B extends A{
        @Override
        public void test() {
            System.out.println("b");
        }
    }

    public static class C extends B{
        @Override
        public void test() {
            System.out.println("c");
        }
    }

    public static void main(String[] args){

        Proxy.newProxyInstance()
        StringBuilder sb = new StringBuilder("xxx");
        B b = new C();
        b.test();
//        Bean.test();
//        ReflectTest.test();
//        validSquare findTargetSumWays1 = new validSquare();
//        findTargetSumWays1.test();
    }
}
