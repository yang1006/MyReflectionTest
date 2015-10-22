package com.example.magicyang.myreflectiontest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * Created by MagicYang on 2015/10/22.
 * ��ȡ����Ĺ��캯��
 */
public class GetConstructors {

    public static void getReflectionConstructons(ReflectionTest r) {
        Class temp = r.getClass();
        String className = temp.getName();
        try {
            /**��ȡReflectionTest ����Ĺ��췽��*/
            Constructor[] theDConstructors = temp.getDeclaredConstructors();
            Constructor[] theConstructors = temp.getConstructors();

            printConstructors(theDConstructors, className);
            printConstructors(theConstructors, className);

        } catch (Exception e) {

        }
    }

    private static void printConstructors(Constructor[] constructors, String className) {
        try {
            for (int i = 0; i < constructors.length; i++) {
                /**��ȡ�������η�*/
                int mod = constructors[i].getModifiers();
                System.out.print(Modifier.toString(mod) + className + "(");
                /**��ȡ������������*/
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
