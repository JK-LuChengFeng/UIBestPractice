package com.example.uibestpractice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.uibestpractice.R;
import com.example.uibestpractice.adapter.AutoTalkAdapter;
import com.example.uibestpractice.bean.MsgBean;
import com.example.uibestpractice.utils.SoftKeyBoardListener;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

/**
 * Create By JK_Liu on 2019/12/04
 */
public class AutoTalkActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView lv_talk;
    private EditText et_input;
    private Button btn_send;

    private AutoTalkAdapter autoTalkAdapter;
    private List<MsgBean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autotalk);

        initData();
        initView();
        onKeyBoardListener();

        autoTalkAdapter = new AutoTalkAdapter(AutoTalkActivity.this,data);
        lv_talk.setAdapter(autoTalkAdapter);


    }

    private void initData() {
        MsgBean msgBean1 = new MsgBean( MsgBean.TYPE_RECEIVED,"Hello guy");
        MsgBean msgBean2 = new MsgBean( MsgBean.TYPE_SENT,"Hello. Who is that?");
        MsgBean msgBean3 = new MsgBean( MsgBean.TYPE_RECEIVED,"This is Tom. Nice talking to you.");
        data.add(msgBean1);
        data.add(msgBean2);
        data.add(msgBean3);
    }

    private void initView() {
        lv_talk = findViewById(R.id.lv_talk);
        et_input = findViewById(R.id.et_input);
        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                //发送
                String sendStr = et_input.getText().toString().trim();
                if (!TextUtils.isEmpty(sendStr)){
                    MsgBean msgBean = new MsgBean(MsgBean.TYPE_SENT,sendStr);
                    data.add(msgBean);
                    autoTalkAdapter.notifyDataSetChanged();
                    lv_talk.setSelection(data.size());//将ListView定位到最后一行
                    et_input.setText("");
                }else {
                    Toast.makeText(AutoTalkActivity.this,"输入内容不可为空",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    //监听软件盘是否弹起
    private void onKeyBoardListener() {
        SoftKeyBoardListener.setListener(AutoTalkActivity.this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() {
            @Override
            public void keyBoardShow(int height) {
                Log.e("123", "键盘显示 高度" + height);
//                lv_talk.setSelection(autoTalkAdapter.getCount() - 1);
                lv_talk.setSelection(lv_talk.getBottom());
            }

            @Override
            public void keyBoardHide(int height) {
                Log.e("123", "键盘隐藏 高度" + height);
            }
        });
    }

}
