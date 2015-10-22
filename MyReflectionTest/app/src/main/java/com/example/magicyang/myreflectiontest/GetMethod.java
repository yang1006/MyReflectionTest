package com.example.magicyang.myreflectiontest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by MagicYang on 2015/10/22.
 * 获取对象的成员函数
 */
public class GetMethod {

    public static void getReflectionMethod(ReflectionTest r){

        Class temp = r.getClass();
        String className = temp.getName();

        /**getMethods()：用于获取类的所有的public修饰域的成员方法，包括从父类继承的public方法和实现接口的public方法；*/
        Method[] methods = temp.getMethods();
        /**getDeclaredMethods()：用于获取在当前类中定义的所有的成员方法和实现的接口方法，不包括从父类继承的方法。*/
        Method[] dmethods = temp.getDeclaredMethods();
        printMethod(methods, className);

        printMethod(dmethods, className);

    }

    private static void printMethod(Method[] methods, String classname){

        for (int i = 0; i < methods.length; i++){
            /**方法修饰符*/
            int mod = methods[i].getModifiers();
            System.out.print(Modifier.toString(mod) + " ");

            /**返回类型*/
            System.out.print(methods[i].getReturnType().getName());

            /**方法名称*/
            System.out.print(" "+methods[i].getName()+"(");

            /**方法参数列表*/
            Class[] paraTypes = methods[i].getParameterTypes();
            for (int j = 0; j < paraTypes.length; j++){
                System.out.print(paraTypes[i].getName());
                if (paraTypes.length < j+1){
                    System.out.print(",");
                }
            }
            System.out.println(")");
        }

    }
}
