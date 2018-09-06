package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/8/14
 * describe:
 */
public class Order {


    private List<OrderListBean> order_list;

    public List<OrderListBean> getOrder_list() {
        return order_list;
    }

    public void setOrder_list(List<OrderListBean> order_list) {
        this.order_list = order_list;
    }

    public static class OrderListBean {
        /**
         * order_id : 1
         * order_status : 0
         * add_time : 2018-08-21 15:27:46
         * goods_info : {"goods_id":1,"goods_name":"糯冰种飘翠福瓜挂件","goods_sn":"3h66872","goods_price":"3980.00","goods_img":"/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg"}
         * status_desc : 待审核
         */

        private int order_id;
        private int order_status;
        private String add_time;
        private GoodsInfoBean goods_info;
        private String status_desc;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public GoodsInfoBean getGoods_info() {
            return goods_info;
        }

        public void setGoods_info(GoodsInfoBean goods_info) {
            this.goods_info = goods_info;
        }

        public String getStatus_desc() {
            return status_desc;
        }

        public void setStatus_desc(String status_desc) {
            this.status_desc = status_desc;
        }

        public static class GoodsInfoBean {
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
