package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/10/9
 * describe:
 */
public class Notify {
    private int type;
    private String text;
    private String type_id;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }
}
