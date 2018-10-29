package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/10/22
 * describe:
 */
public class OrderInfo {

    /**
     * shipping_fee : 0.01
     * total_fee : 303.00
     */

    private String shipping_fee;
    private String total_fee;

    public String getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(String shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }
}
