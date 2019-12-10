package com.example.uibestpractice.bean;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/5 15:21
 */
public class SiZhiBean {

    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private int type;
    private String content;

    public SiZhiBean(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
