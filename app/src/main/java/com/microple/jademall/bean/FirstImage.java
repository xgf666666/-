package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/8/27
 * describe:
 */
public class FirstImage {

    /**
     * banner_id : 1
     * name : 翡翠1
     * is_type : 0
     * url :
     * img : /uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg
     * is_show : 1
     * sort : 1
     */

    private int banner_id;
    private String name;
    private int is_type;
    private String url;
    private String img;
    private int is_show;
    private int sort;

    public int getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(int banner_id) {
        this.banner_id = banner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIs_type() {
        return is_type;
    }

    public void setIs_type(int is_type) {
        this.is_type = is_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIs_show() {
        return is_show;
    }

    public void setIs_show(int is_show) {
        this.is_show = is_show;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
