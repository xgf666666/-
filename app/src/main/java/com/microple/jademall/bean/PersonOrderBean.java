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

public class PersonOrderBean {
    private int icon;
    private String name;
    private Class<? extends Activity> activity;

    public PersonOrderBean(int icon, String name, Class<? extends Activity> activity) {
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

    public static List<PersonOrderBean> createList(){
        List<PersonOrderBean> data = new ArrayList<>();
        data.add(new PersonOrderBean(R.drawable.ic_allmy_n, "全部订单", LiveDetailsActivity.class));
        data.add(new PersonOrderBean(R.drawable.ic_auditmy_n,"待审核订单", LiveDetailsActivity.class));
//        data.add(new PersonOrderBean(R.mipmap.ic_paymentmy_n,"待付款订单", LiveDetailsActivity.class));
        data.add(new PersonOrderBean(R.drawable.ic_collectmy_n,"待收货订单", LiveDetailsActivity.class));
        data.add(new PersonOrderBean(R.drawable.ic_completemy_n,"已完成订单", LiveDetailsActivity.class));
        data.add(new PersonOrderBean(R.drawable.ic_cancel_n,"已取消订单", LiveDetailsActivity.class));
        data.add(new PersonOrderBean(R.drawable.ic_cancel_n,"售后订单", LiveDetailsActivity.class));
        return data;
    }
}
