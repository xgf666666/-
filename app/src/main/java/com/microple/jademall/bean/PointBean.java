package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/8/31
 * describe:
 */
public class PointBean {
    private int up_id;
    private int user_id;
    private int type;
    private String points;
    private String text;
    private String add_time;
    private String order_sn;
    private String points_change;
    private String time;
    private String year;
    private String month;
    private Boolean isHas=false;

    public int getUp_id() {
        return up_id;
    }

    public void setUp_id(int up_id) {
        this.up_id = up_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public String getPoints_change() {
        return points_change;
    }

    public void setPoints_change(String points_change) {
        this.points_change = points_change;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Boolean getHas() {
        return isHas;
    }

    public void setHas(Boolean has) {
        isHas = has;
    }

    @Override
    public String toString() {
        return "PointBean{" +
                "up_id=" + up_id +
                ", user_id=" + user_id +
                ", type=" + type +
                ", points='" + points + '\'' +
                ", text='" + text + '\'' +
                ", add_time='" + add_time + '\'' +
                ", order_sn='" + order_sn + '\'' +
                ", points_change='" + points_change + '\'' +
                ", time='" + time + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", isHas=" + isHas +
                '}';
    }
}
