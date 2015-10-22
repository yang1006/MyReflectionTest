package com.example.magicyang.myreflectiontest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by MagicYang on 2015/10/22.
 * ��ȡ����ĳ�Ա����
 */
public class GetMethod {

    public static void getReflectionMethod(ReflectionTest r){

        Class temp = r.getClass();
        String className = temp.getName();

        /**getMethods()�����ڻ�ȡ������е�public������ĳ�Ա�����������Ӹ���̳е�public������ʵ�ֽӿڵ�public������*/
        Method[] methods = temp.getMethods();
        /**getDeclaredMethods()�����ڻ�ȡ�ڵ�ǰ���ж�������еĳ�Ա������ʵ�ֵĽӿڷ������������Ӹ���̳еķ�����*/
        Method[] dmethods = temp.getDeclaredMethods();
        printMethod(methods, className);

        printMethod(dmethods, className);

    }

    private static void printMethod(Method[] methods, String classname){

        for (int i = 0; i < methods.length; i++){
            /**�������η�*/
            int mod = methods[i].getModifiers();
            System.out.print(Modifier.toString(mod) + " ");

            /**��������*/
            System.out.print(methods[i].getReturnType().getName());

            /**��������*/
            System.out.print(" "+methods[i].getName()+"(");

            /**���������б�*/
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
