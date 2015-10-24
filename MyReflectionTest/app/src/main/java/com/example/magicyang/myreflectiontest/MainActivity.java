package com.example.magicyang.myreflectiontest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReflectionTest rt = new ReflectionTest();
//        getConstructorsTest(rt);
//        getMethodTest(rt);
//        getFieldsTest(rt);
        LoadMethodTest();
    }

    /**
     * 获取构造函数
     */
    private void getConstructorsTest(ReflectionTest rt) {

        GetConstructors.getReflectionConstructons(rt);
    }

    /**
     * 获取方法
     */
    private void getMethodTest(ReflectionTest rt) {

        GetMethod.getReflectionMethod(rt);
    }

    private void getFieldsTest(ReflectionTest rt) {

        GetFields.getReflectionFields(rt);
    }

    private void LoadMethodTest() {
        Object result = LoadMethod.LoadAMethod("" + ReflectionTest.class.getName(), "adc",
                          new String[]{"int", "String"}, new String[]{"55", "执行函数"});
        System.out.println(result.toString());
    }
}
