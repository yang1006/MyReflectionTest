package com.example.magicyang.myreflectiontest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by MagicYang on 2015/10/22.
 * 获取对象的成员变量
 */
public class GetFields {

    public static void getReflectionFields(ReflectionTest r) {
        Class temp = r.getClass();
        String className = temp.getName();

        Field[] fields = temp.getFields();

        Field[] dfields = temp.getDeclaredFields();

        printFields(fields ,temp ,r);

        printFields(dfields, temp ,r);

    }

    private static void printFields(Field[] fields, Class temp, ReflectionTest r) {
        try {
            for (int i = 0; i < fields.length; i++) {

                /**属性的类型*/
                Class type = fields[i].getType();

                /**修饰符*/
                int mod = fields[i].getModifiers();

                /**获取属性的值*/
                Field f = temp.getField(fields[i].getName());
//                Field f = fields[i];  //这样也是可以的吧
                f.setAccessible(true);
                Object value = f.get(r);
                /**判断值是否初始化*/
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
