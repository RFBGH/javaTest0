package com.example.javatest.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Bean {

    String s = "1";
    int i = 2;
    float f = 3.0f;
    double d = 4.0f;
    int[]is = new int[]{2,2};
    List<String> list = new ArrayList<>();
    Test mTest = new Test(1, 2);

    public static void test(){


        Bean bean = new Bean();
        Class clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getType());
            System.out.println(field.getType().getName());
        }
    }
}
