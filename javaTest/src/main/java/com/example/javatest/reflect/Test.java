package com.example.javatest.reflect;

public class Test {

    @check(4)
    private int value;

    @check()
    private int value2;

    public Test(int value, int value2) {
        this.value = value;
        this.value2 = value2;
    }

    private void print(){
        System.out.println(value+" "+value2);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
