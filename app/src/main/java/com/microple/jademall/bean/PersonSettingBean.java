package com.microple.jademall.bean;

import android.app.Activity;

import com.microple.jademall.R;
import com.microple.jademall.ui.live.activity.LiveDetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * author: linfeng
 * date: 2018/8/8.
 * describe:个人中心列表
 */

public class PersonSettingBean {
    private int icon;
    private String name;
    private Class<? extends Activity> activity;

    public PersonSettingBean(int icon, String name, Class<? extends Activity> activity) {
        this.icon = icon;
        this.name = name;
        this.activity = activity;
    }
    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<? extends Activity> getActivity() {
        return activity;
    }

    public void setActivity(Class<? extends Activity> activity) {
        this.activity = activity;
    }

    public static List<PersonSettingBean> createList(){
        List<PersonSettingBean> data = new ArrayList<>();
        data.add(new PersonSettingBean(R.drawable.ic_personage_n, "个人资料设置", LiveDetailsActivity.class));
        data.add(new PersonSettingBean(R.drawable.ic_site_n,"收货地址管理", LiveDetailsActivity.class));
        data.add(new PersonSettingBean(R.drawable.ic_safety_n,"安全性设置", LiveDetailsActivity.class));
        return data;
    }
}
