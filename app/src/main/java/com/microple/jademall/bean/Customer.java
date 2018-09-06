package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/5
 * describe:
 */
public class Customer {

    private List<ReturnsBean> returns;

    public List<ReturnsBean> getReturns() {
        return returns;
    }

    public void setReturns(List<ReturnsBean> returns) {
        this.returns = returns;
    }

    public static class ReturnsBean {
        /**
         * as_id : 1
         * status : 3
         * goods_id : 1
         * add_time : 2018-08-24 09:32:28
         * refunds_fee : 99
         * goods : {"goods_id":1,"goods_name":"糯冰种飘翠福瓜挂件","goods_sn":"3h66872","goods_price":"3980.00","goods_img":"/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg"}
         * status_desc : 退款中
         */

        private int as_id;
        private int status;
        private int goods_id;
        private String add_time;
        private String refunds_fee;
        private GoodsBean goods;
        private String status_desc;

        public int getAs_id() {
            return as_id;
        }

        public void setAs_id(int as_id) {
            this.as_id = as_id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getRefunds_fee() {
            return refunds_fee;
        }

        public void setRefunds_fee(String refunds_fee) {
            this.refunds_fee = refunds_fee;
        }

        public GoodsBean getGoods() {
            return goods;
        }

        public void setGoods(GoodsBean goods) {
            this.goods = goods;
        }

        public String getStatus_desc() {
            return status_desc;
        }

        public void setStatus_desc(String status_desc) {
            this.status_desc = status_desc;
        }

        public static class GoodsBean {
            /**
             * goods_id : 1
             * goods_name : 糯冰种飘翠福瓜挂件
             * goods_sn : 3h66872
             * goods_price : 3980.00
             * goods_img : /uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg
             */

            private int goods_id;
            private String goods_name;
            private String goods_sn;
            private String goods_price;
            private String goods_img;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getGoods_img() {
                return goods_img;
            }

            public void setGoods_img(String goods_img) {
                this.goods_img = goods_img;
            }
        }
    }
}
