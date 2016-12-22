package com.king.doubleicon;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ComponentName mDefault;
    private ComponentName mDefault11;
    private ComponentName mDefault12;
    private PackageManager mPm;
    private AppCompatButton mChange11;
    private AppCompatButton mChange12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mDefault = getComponentName();

        mDefault11 = new ComponentName(getBaseContext(), "com.king.doubleicon.DoubleOne");
        mDefault12 = new ComponentName(getBaseContext(), "com.king.doubleicon.DoubleTwo");

        mPm = getApplicationContext().getPackageManager();
    }

    private void initView() {
        mChange11 = (AppCompatButton) findViewById(R.id.change11);
        mChange12 = (AppCompatButton) findViewById(R.id.change12);
        mChange11.setOnClickListener(this);
        mChange12.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change11:
                change11();
                break;
            case R.id.change12:
                change12();
                break;
        }
    }

    private void change11() {
        disableComponent(mDefault);
        disableComponent(mDefault12);
        enableComponent(mDefault11);
    }

    private void change12() {
        disableComponent(mDefault);
        disableComponent(mDefault11);
        enableComponent(mDefault12);
    }

    private void disableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void enableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }
}
