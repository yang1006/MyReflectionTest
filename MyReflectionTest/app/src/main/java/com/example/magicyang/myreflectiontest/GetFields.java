package com.example.magicyang.myreflectiontest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by MagicYang on 2015/10/22.
 * ��ȡ����ĳ�Ա����
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

                /**���Ե�����*/
                Class type = fields[i].getType();

                /**���η�*/
                int mod = fields[i].getModifiers();

                /**��ȡ���Ե�ֵ*/
                Field f = temp.getField(fields[i].getName());
//                Field f = fields[i];  //����Ҳ�ǿ��Եİ�
                f.setAccessible(true);
                Object value = f.get(r);
                /**�ж�ֵ�Ƿ��ʼ��*/
                if (value == null) {//δ��ʼ��
                    System.out.println(Modifier.toString(mod) + " " + type.getName() + " "
                            + fields[i].getName());
                } else {//�Ѿ���ʼ��
                    System.out.println(Modifier.toString(mod) + " " + type.getName() + " "
                            + fields[i].getName() + " = " + value.toString());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
