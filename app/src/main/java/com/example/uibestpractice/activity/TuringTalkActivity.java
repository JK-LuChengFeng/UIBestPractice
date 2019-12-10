package com.example.uibestpractice.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uibestpractice.R;
import com.example.uibestpractice.adapter.RvRecyclerAdapter;
import com.example.uibestpractice.bean.SiZhiBean;
import com.example.uibestpractice.bean.SiZhiBeanResp;
import com.example.uibestpractice.http.Myokhttp;
import com.example.uibestpractice.interfaces.HttpCallBack;
import com.example.uibestpractice.utils.SoftKeyBoardListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By JK_Liu on 2019/12/04
 */
public class TuringTalkActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView rv_talk;
    private EditText et_input;
    private Button btn_send;
    private TextView tv_send,tv_add;

    private RecyclerView.LayoutManager layoutManager;
    private RvRecyclerAdapter adapter;

    private List<SiZhiBean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turingtalk);

        initData();
        initView();
        onKeyBoardListener();
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rv_talk.setLayoutManager(layoutManager);
        adapter = new RvRecyclerAdapter(data);
        rv_talk.setAdapter(adapter);

    }

    private void initData() {
        SiZhiBean zhiBean = new SiZhiBean(SiZhiBean.TYPE_RECEIVED,"你好，我是二傻子");
        data.add(zhiBean);
    }

    private void initView() {
        rv_talk = findViewById(R.id.rv_talk);
        et_input = findViewById(R.id.et_input);
        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);
        et_input.addTextChangedListener(textWachListener);
        tv_send = findViewById(R.id.tv_send);
        tv_send.setOnClickListener(this);
        tv_add = findViewById(R.id.tv_add);
        tv_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_send:
                //发送
                //发送消息
                String sendStr = et_input.getText().toString().trim();
                if (!TextUtils.isEmpty(sendStr)){
                    SiZhiBean zhiBean = new SiZhiBean(SiZhiBean.TYPE_SENT,sendStr);
                    data.add(zhiBean);
                    adapter.notifyItemInserted(data.size() -1);//当有新消息时，刷新rv中的显示
                    rv_talk.scrollToPosition(data.size() -1);//定位到最后一行
                    et_input.setText("");

                    //发起网络请求，开始请求接口，获取返回信息。
                    Map<String,String> map = new HashMap<>();
                    map.put("userid","user");
                    map.put("spoken",sendStr);

                    http4SendMsg(map);

                }else {
                    Toast.makeText(TuringTalkActivity.this,"发送消息不可为空",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_add:
                //添加表情
                break;
            default:
                break;
        }
    }

    private void http4SendMsg(Map<String, String> map) {
        Myokhttp.getInstance().getStringFromGet(map, new HttpCallBack<String>() {
            @Override
            public void onStart() {
                //开始
            }

            @Override
            public void onSuccess(String response) {
                //成功
                SiZhiBeanResp siZhiBeanResp = new Gson().fromJson(response,SiZhiBeanResp.class);
                SiZhiBean siZhiBean = new SiZhiBean(SiZhiBean.TYPE_RECEIVED,siZhiBeanResp.getData().getInfo().getText());
                data.add(siZhiBean);
                adapter.notifyItemInserted(data.size() -1);//当有新消息时，刷新rv中的显示
                rv_talk.scrollToPosition(data.size() -1);//定位到最后一行

            }

            @Override
            public void onError(String str) {
                //失败
                Toast.makeText(TuringTalkActivity.this,"aaa",Toast.LENGTH_SHORT).show();
                SiZhiBean siZhiBean = new SiZhiBean(SiZhiBean.TYPE_RECEIVED,str);
                data.add(siZhiBean);
                adapter.notifyItemInserted(data.size() -1);//当有新消息时，刷新rv中的显示
                rv_talk.scrollToPosition(data.size() -1);//定位到最后一行
            }
        });
    }


    /**
     * 输入框输入状态监听
     */
    TextWatcher textWachListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //为了防止输入过程中输入框变宽遮挡消息
            rv_talk.scrollToPosition(data.size() -1);//定位到最后一行
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (TextUtils.isEmpty(s)){
               tv_send.setVisibility(View.INVISIBLE);
               tv_add.setVisibility(View.VISIBLE);
            }else {
                tv_send.setVisibility(View.VISIBLE);
                tv_add.setVisibility(View.INVISIBLE);
            }
        }
    };


    /**
     * 监听软件盘是否弹起
     */
    private void onKeyBoardListener() {
        SoftKeyBoardListener.setListener(TuringTalkActivity.this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() {
            @Override
            public void keyBoardShow(int height) {
                Log.e("123", "键盘显示 高度" + height);
                rv_talk.scrollToPosition(data.size() -1);//定位到最后一行
            }

            @Override
            public void keyBoardHide(int height) {
                Log.e("123", "键盘隐藏 高度" + height);
            }
        });
    }


}
