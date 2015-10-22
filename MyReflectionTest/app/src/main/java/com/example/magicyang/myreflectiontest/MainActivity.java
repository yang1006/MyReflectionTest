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
        getConstructorsTest(rt);
    }

    private void getConstructorsTest(ReflectionTest rt){

        GetConstructors.getReflectionConstructons(rt);
    }

    private void getMethodTest(ReflectionTest rt){

        GetMethod.getReflectionMethod(rt);

    }

}
