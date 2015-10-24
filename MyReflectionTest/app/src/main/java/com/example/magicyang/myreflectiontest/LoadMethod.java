package com.example.magicyang.myreflectiontest;

import android.text.TextUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by MagicYang on 2015/10/24.
 * 加载一个类的一个方法
 */
public class LoadMethod {

    /**
     * @param classname 类名
     * @param method    方法名
     * @param types     参数类型列表
     * @param paras     参数值列表
     */
    public static Object LoadAMethod(String classname, String method,
                                   String[] types, String[] paras) {
        Object reObj = null;
        try {
            /**获取类*/
            Class cls = Class.forName(classname);
            /**用构造函数的newInstance函数获得对象*/
            Constructor constructor = cls.getConstructor(null);
            Object obj = constructor.newInstance(null);
            /**也可以用类的newInstance函数构造对象*/
            //Object obj = cls.newInstance();

            /**获取参数类型*/
            Class[] paratypes = getMethodTypeClass(types);
            /**获取方法*/
            Method meth = cls.getDeclaredMethod(method, paratypes);

            /**获取参数值*/
            Object[] paraValues = getParaValueObject(types,paras);

            /**调用指定的方法并返回object*/
            reObj = meth.invoke(obj, paraValues);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reObj;
    }

    /**
     * 获取方法参数类型
     */
    private static Class[] getMethodTypeClass(String[] types) {
        Class[] cs = new Class[types.length];
        for (int i = 0; i < cs.length; i++) {
            if (!TextUtils.isEmpty(types[i])) {
                if (TextUtils.equals(types[i], "int") || TextUtils.equals(types[i], "Integer")) {
                    cs[i] = Integer.TYPE;
                } else if (TextUtils.equals(types[i], "float") || TextUtils.equals(types[i], "Float")) {
                    cs[i] = Float.TYPE;
                } else if (TextUtils.equals(types[i], "double") || TextUtils.equals(types[i], "Double")) {
                    cs[i] = Double.TYPE;
                } else if (TextUtils.equals(types[i], "long") || TextUtils.equals(types[i], "Long")) {
                    cs[i] = Long.TYPE;
                } else if (TextUtils.equals(types[i], "boolean") || TextUtils.equals(types[i], "Boolean")) {
                    cs[i] = Boolean.TYPE;
                } else if (TextUtils.equals(types[i], "String")) {
                    cs[i] = String.class;
                } else {
                    try {
                        cs[i] = Class.forName(types[i]);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return cs;
    }

    /**获取方法参数值*/
    private static Object[] getParaValueObject(String[] types, String[] paras){
        Object[] objects = new Object[paras.length];
        for (int i = 0; i < objects.length; i++){
            if (!TextUtils.isEmpty(paras[i])){
                if (TextUtils.equals(types[i], "int") || TextUtils.equals(types[i], "Integer")) {
                    objects[i] = new Integer(paras[i]);
                } else if (TextUtils.equals(types[i], "float") || TextUtils.equals(types[i], "Float")) {
                    objects[i] = new Float(paras[i]);
                } else if (TextUtils.equals(types[i], "double") || TextUtils.equals(types[i], "Double")) {
                    objects[i] = new Double(paras[i]);
                } else if (TextUtils.equals(types[i], "long") || TextUtils.equals(types[i], "Long")) {
                    objects[i] = new Long(paras[i]);
                } else if (TextUtils.equals(types[i], "boolean") || TextUtils.equals(types[i], "Boolean")) {
                    objects[i] = new Boolean(paras[i]);
                } else if (TextUtils.equals(types[i], "String")) {
                    objects[i] = paras[i];
                } else {
//                    try {
//                        objects[i] = Class.forName(types[i]);
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }
        return objects;
    }
}
