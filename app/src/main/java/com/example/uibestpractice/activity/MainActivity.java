package com.example.uibestpractice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uibestpractice.R;

/**
 * Create By JK_Liu on ${DATE}
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_autotalk, btn_turingtalk, btn_sizhitalk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        btn_autotalk = findViewById(R.id.btn_autotalk);
        btn_autotalk.setOnClickListener(this);
        btn_turingtalk = findViewById(R.id.btn_turingtalk);
        btn_turingtalk.setOnClickListener(this);
        btn_sizhitalk = findViewById(R.id.btn_sizhitalk);
        btn_sizhitalk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_autotalk:
                //自动聊天
                intent.setClass(MainActivity.this,AutoTalkActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_turingtalk:
                //图灵聊天

                break;
            case R.id.btn_sizhitalk:
                //思知
                intent.setClass(MainActivity.this,TuringTalkActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
