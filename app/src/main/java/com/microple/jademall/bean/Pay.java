package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/9/17
 * describe:
 */
public class Pay {

    /**
     * data : {"return_code":"SUCCESS","return_msg":"OK","appid":"wxe13c15b520e07f80","mch_id":"1501495561","nonce_str":"im2iw97bf8qhwpjrhiqwrth68cr6rlzw","sign":"D714F1A8FF3C1060E0680D82139BEE16","result_code":"SUCCESS","prepay_id":"wx1710532020402318d1a8dda83936448858","trade_type":"APP","time":1537152800}
     * type : wxpay
     */

    private DataBean data;
    private String type;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class DataBean {
        /**
         * return_code : SUCCESS
         * return_msg : OK
         * appid : wxe13c15b520e07f80
         * mch_id : 1501495561
         * nonce_str : im2iw97bf8qhwpjrhiqwrth68cr6rlzw
         * sign : D714F1A8FF3C1060E0680D82139BEE16
         * result_code : SUCCESS
         * prepay_id : wx1710532020402318d1a8dda83936448858
         * trade_type : APP
         * time : 1537152800
         */

        private String return_code;
        private String return_msg;
        private String appid;
        private String mch_id;
        private String nonce_str;
        private String sign;
        private String result_code;
        private String prepay_id;
        private String trade_type;
        private String time;
        private String order_sn;

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public String getReturn_code() {
            return return_code;
        }

        public void setReturn_code(String return_code) {
            this.return_code = return_code;
        }

        public String getReturn_msg() {
            return return_msg;
        }

        public void setReturn_msg(String return_msg) {
            this.return_msg = return_msg;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getMch_id() {
            return mch_id;
        }

        public void setMch_id(String mch_id) {
            this.mch_id = mch_id;
        }

        public String getNonce_str() {
            return nonce_str;
        }

        public void setNonce_str(String nonce_str) {
            this.nonce_str = nonce_str;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getResult_code() {
            return result_code;
        }

        public void setResult_code(String result_code) {
            this.result_code = result_code;
        }

        public String getPrepay_id() {
            return prepay_id;
        }

        public void setPrepay_id(String prepay_id) {
            this.prepay_id = prepay_id;
        }

        public String getTrade_type() {
            return trade_type;
        }

        public void setTrade_type(String trade_type) {
            this.trade_type = trade_type;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
