package com.example.magicyang.myreflectiontest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * Created by MagicYang on 2015/10/22.
 * 获取构造函数
 */
public class GetConstructors {

    public static void getReflectionConstructons(ReflectionTest r) {
        Class temp = r.getClass();
        String className = temp.getName();
        try {
        /**所有构造函数*/
            Constructor[] theDConstructors = temp.getDeclaredConstructors();
            /**所有public 的构造函数*/
            Constructor[] theConstructors = temp.getConstructors();

            printConstructors(theDConstructors, className);
            printConstructors(theConstructors, className);

        } catch (Exception e) {

        }
    }

    private static void printConstructors(Constructor[] constructors, String className) {
        try {
            for (int i = 0; i < constructors.length; i++) {
                /**获取修饰符*/
                int mod = constructors[i].getModifiers();
                System.out.print(Modifier.toString(mod) + className + "(");
                /**获取参数类型*/
                Class[] paraTypes = constructors[i].getParameterTypes();
                for (int j = 0; j < paraTypes.length; j++) {
                    System.out.print(paraTypes[j].getName());
                    if (paraTypes.length > j + 1) {
                        System.out.print(",");
                    }
                }
                System.out.println(")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
