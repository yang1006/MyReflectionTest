package com.example.magicyang.myreflectiontest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by MagicYang on 2015/10/22.
 * 获取成员变量
 */
public class GetFields {

    public static void getReflectionFields(ReflectionTest r) {
        Class temp = r.getClass();
        String className = temp.getName();

        /**获取public的成员变量*/
        Field[] fields = temp.getFields();
        /**获取所有成员变量*/
        Field[] dfields = temp.getDeclaredFields();

//        printFields(fields ,temp ,r);

        printFields(dfields, temp ,r);

    }

    private static void printFields(Field[] fields, Class temp, ReflectionTest r) {
        try {
            for (int i = 0; i < fields.length; i++) {

                /**成员变量的类型*/
                Class type = fields[i].getType();

                /**成员变量的修饰符*/
                int mod = fields[i].getModifiers();

                /**成员变量的值*/
                Field f = temp.getDeclaredField(fields[i].getName());
//                Field f = fields[i];
                f.setAccessible(true);
                Object value = f.get(r);
                /**判断是否初始化*/
                if (value == null) {//未初始化
                    System.out.println(Modifier.toString(mod) + " " + type.getName() + " "
                            + fields[i].getName());
                } else {//已经初始化
                    System.out.println(Modifier.toString(mod) + " " + type.getName() + " "
                            + fields[i].getName() + " = " + value.toString());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
