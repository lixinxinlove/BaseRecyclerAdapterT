package com.love.baserecycleradapterdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initEvent();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
    }

    private void initData() {

    }

    private void initEvent() {
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn1:
                intent = new Intent(MainActivity.this, RecyclerDemo1Activity.class);
                startActivity(intent);
                break;
        }
    }
}
