package com.example.magicyang.myreflectiontest;

import android.util.Log;

/**
 * Created by MagicYang on 2015/10/22.
 */
public class ReflectionTest extends Object{
    private int bInt;
    public Integer bInteger = new Integer(4);
    public String strB = "MagicYang";
    private String strA;

    public ReflectionTest(){

    }

    protected ReflectionTest(int id, String name){

    }

    public int adc(int id, String name){
        Log.e("Magic-->","id&name-->"+id +"-"+name);
        return 0;
    }

    protected static void edf(){

    }

    @Override
    public String toString() {
        Log.e("Magic","ReflectionTest.toString");
        return "";
    }
}
