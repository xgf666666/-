package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/6
 * describe:
 */
public class Shop {

    /**
     * shopp_info : [{"sb_id":3,"user_id":3,"goods_id":9,"goods_sn":"3h66877","goods_price":"3980.00","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg"},{"sb_id":2,"user_id":3,"goods_id":8,"goods_sn":"3h66875","goods_price":"3980.00","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg"},{"sb_id":1,"user_id":3,"goods_id":1,"goods_sn":"3h66872","goods_price":"3980.00","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg"}]
     * total_fee : 11940.00
     */

    private String total_fee;
    private List<ShoppInfoBean> shopp_info;

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public List<ShoppInfoBean> getShopp_info() {
        return shopp_info;
    }

    public void setShopp_info(List<ShoppInfoBean> shopp_info) {
        this.shopp_info = shopp_info;
    }

    public static class ShoppInfoBean {
        /**
         * sb_id : 3
         * user_id : 3
         * goods_id : 9
         * goods_sn : 3h66877
         * goods_price : 3980.00
         * goods_name : 糯冰种飘翠福瓜挂件
         * goods_img : /uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg
         */

        private int sb_id;
        private int user_id;
        private int goods_id;
        private String goods_sn;
        private Float goods_price;
        private String goods_name;
        private String goods_img;

        public int getSb_id() {
            return sb_id;
        }

        public void setSb_id(int sb_id) {
            this.sb_id = sb_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_sn() {
            return goods_sn;
        }

        public void setGoods_sn(String goods_sn) {
            this.goods_sn = goods_sn;
        }

        public Float getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(Float goods_price) {
            this.goods_price = goods_price;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }
    }
}
