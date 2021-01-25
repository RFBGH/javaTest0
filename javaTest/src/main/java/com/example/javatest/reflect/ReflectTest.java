package com.example.javatest.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectTest {

    public static void test(){

        Test test = new Test(5, 2);

        try {
            Field[] fields = test.getClass().getDeclaredFields();
            for(Field field : fields){

                check annotation = field.getAnnotation(check.class);
                if(annotation == null){
                    continue;
                }

                boolean isAccess = field.isAccessible();
                field.setAccessible(true);
                Object value = field.get(test);
                if(value instanceof Integer){

                    Integer iValue = (Integer)value;
                    if(iValue >  annotation.value()){
                        System.out.println(iValue+" is too bigger");
                    }else{
                        System.out.println(iValue+" is just ok");
                    }
                }

                field.setAccessible(isAccess);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void methodTest(){

        Test test = new Test(4, 1);

        Method[] methods = test.getClass().getDeclaredMethods();
        for(Method method : methods){
            method.setAccessible(true);
            try {
                if (method.getParameterCount() == 0) {
                    method.invoke(test);
                }
            } catch (Exception e) {
              e.printStackTrace();
            }
        }
    }

    public static void testDynProxy(){



        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "false");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "false");


        ITest test = new OriTest();

        ProxyHandler handler = new ProxyHandler(test);
        ITest proxyTest = (ITest)Proxy.newProxyInstance(test.getClass().getClassLoader(), new Class<?>[]{ITest.class}, handler);
        proxyTest.test("xxx");
    }
}
