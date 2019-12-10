package com.example.uibestpractice.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.example.uibestpractice.interfaces.HttpCallBack;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Lenovo on 2018/3/12.
 */

public class Myokhttp {


    private static OkHttpClient client;//首先声明一个client;
    private static Myokhttp instance = new Myokhttp(); //实例化一个类对象
    private Handler handler = new Handler(Looper.getMainLooper());//一个可以运行在主线程的handler
    // 超时时间
    private static final int TIMEOUT = 1000 * 30;

    private static Call call;

    /**
     * 以下做缓存使用
     */
    // 默认缓存路径
    private static String cachePath = "mnt/sdcard/egintra/okhttp/cache";
    // 默认缓存文件
    private static File sdcache = new File(cachePath);
    // 默认缓存大小
    private static int cacheSize = 10 * 1024 * 1024;
    // json请求
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    // 上传文件
    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    // 上传图片
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    private String murl;//接口

    public static Myokhttp getInstance(){
        return instance;
    }

    public Myokhttp() {
        this.init();
    }

    private void init() {
        if (client == null){
            client = new OkHttpClient();
            client = client.newBuilder().connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                    .writeTimeout(TIMEOUT,TimeUnit.MILLISECONDS).readTimeout(TIMEOUT,TimeUnit.MILLISECONDS)
                    .build();
        }
    }

    //带参数的请求分为键值对的形式，还有json参数的形式。
    //只有键值对形式的参数，才区分get和post,
    //json形式的参数，只有post一种形式

    //参数为Map<键，值>paramsmap的形式
    //1.不带参数的get请求
    public void getStringFromGet1(final HttpCallBack<String> callback){
        getStringFromGet(null,callback);
    }

    //2.带参数的get请求
    public void getStringFromGet2(Map<String,String> params,final HttpCallBack<String> callback){
        getStringFromGet(params,callback);
    }


    //GET请求
    public void getStringFromGet(Map<String,String>params, final HttpCallBack<String> callback){

        //1.获取请求的url
        murl = getURL(params);

        //2.实例化一个Request
        final Request request = new Request.Builder()
                .url(murl)
                .build();

        call = client.newCall(request);
        //3.网络请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //请求失败
                if(e.getCause() != null){
                    if (e.getCause().equals(SocketTimeoutException.class)) {
                        callback.onError("哈？我听不懂你在说什么");
                    }else {
                        if(e.getMessage().startsWith("Failed to connect to")){
                            callback.onError("哈？我听不懂你在说什么");
                        }else {
                            callback.onError("哈？我听不懂你在说什么");
                        }
                    }
                }else {
                    callback.onError("哈？我听不懂你在说什么");
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //请求成功
                if (response.isSuccessful()){
                    final String data = response.body().string();
                    //由于okhttp是偏底层的网络请求类库，
                    // 返回结果的回调方法仍然执行在子线程中，需要自己跳转到UI线程(一般是主线程)
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (!"{}".equals(data) && !"[]".equals(data)){
                                callback.onSuccess(data);
                            }else {
                                callback.onError("哈？我听不懂你在说什么");
                            }
                        }
                    });
                }else {
                    callback.onError("哈？我听不懂你在说什么");
                }
            }
        });
    }

    //获取URL
    private String getURL(Map<String, String> params) {
        if (params != null){

            murl = UrlParams.BaseURL + "&";
            for (String key : params.keySet()){
                murl = murl + key + "=" + params.get(key) + "&";
            }
            murl = murl.substring(0,murl.length() - 1);
        }
        return murl;
    }

    //取消
    public static void CancleHttp(){
        if (call != null){
            call.cancel();
        }
    }
}
