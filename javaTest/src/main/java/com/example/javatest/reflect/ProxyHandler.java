package com.example.javatest.reflect;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private ITest mTest;

    public ProxyHandler(ITest test){
        mTest = test;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("start proxy");
        return method.invoke(mTest, objects);
    }
}
