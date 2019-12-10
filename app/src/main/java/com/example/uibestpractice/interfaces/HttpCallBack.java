package com.example.uibestpractice.interfaces;

/**
 * Created by Lenovo on 2018/3/12.
 */

public interface HttpCallBack<T> {

    void onStart();
    void onSuccess(T response);
    void onError(String str);

}
