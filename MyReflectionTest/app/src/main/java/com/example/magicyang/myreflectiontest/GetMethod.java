package com.example.magicyang.myreflectiontest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by MagicYang on 2015/10/22.
 * 获取方法
 */
public class GetMethod {

    public static void getReflectionMethod(ReflectionTest r){

        Class temp = r.getClass();
        String className = temp.getName();

        /**用于获取类的所有的public修饰域的成员方法，包括从父类继承的public方法和实现接口的public方法*/
        Method[] methods = temp.getMethods();
        /**getDeclaredMethods()用于获取在当前类中定义的所有的成员方法和实现的接口方法，不包括从父类继承的方法。*/
        Method[] dmethods = temp.getDeclaredMethods();
        printMethod(methods, className);
        System.out.println("getDeclaredMethods--->");
        printMethod(dmethods, className);

    }

    private static void printMethod(Method[] methods, String classname){

        for (int i = 0; i < methods.length; i++){
            /**获取修饰符*/
            int mod = methods[i].getModifiers();
            System.out.print(Modifier.toString(mod) + " ");

            /**获取返回类型*/
            System.out.print(methods[i].getReturnType().getName());

            /**方法名*/
            System.out.print(" "+methods[i].getName()+"(");

            /**参数类型*/
            Class[] paraTypes = methods[i].getParameterTypes();
            for (int j = 0; j < paraTypes.length; j++){
                System.out.print(paraTypes[j].getName());
                if (paraTypes.length < j+1){
                    System.out.print(",");
                }
            }
            System.out.println(")");
        }

    }
}
