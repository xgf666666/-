package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/9/5
 * describe:
 */
public class OrderDetail {

    /**
     * order_detail : {"order_id":1,"order_sn":"20180815752231","order_status":3,"consignee":"ceshi","mobile":"15915048904","address":"广东省广州市天河区富力盈凯","shipping_no":null,"shipping_name":null,"pay_type":1,"goods_price":"3980.00","shipping_price":"0.00","total_price":"3980.00","add_time":"2018-08-21 15:27:46","shipping_time":null,"confirm_time":null,"user_id":3,"supplier_id":1,"buy_type":0,"logistics":"","supplier_name":"广州微标杆互联网科技有限公司","pay_name":"支付宝支付","label":"积分返还","goods_info":{"goods_id":1,"goods_name":"糯冰种飘翠福瓜挂件","goods_sn":"3h66872","goods_price":"3980.00"}}
     */

    private OrderDetailBean order_detail;

    public OrderDetailBean getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(OrderDetailBean order_detail) {
        this.order_detail = order_detail;
    }

    public static class OrderDetailBean {
        /**
         * order_id : 1
         * order_sn : 20180815752231
         * order_status : 3
         * consignee : ceshi
         * mobile : 15915048904
         * address : 广东省广州市天河区富力盈凯
         * shipping_no : null
         * shipping_name : null
         * pay_type : 1
         * goods_price : 3980.00
         * shipping_price : 0.00
         * total_price : 3980.00
         * add_time : 2018-08-21 15:27:46
         * shipping_time : null
         * confirm_time : null
         * user_id : 3
         * supplier_id : 1
         * buy_type : 0
         * logistics :
         * supplier_name : 广州微标杆互联网科技有限公司
         * pay_name : 支付宝支付
         * label : 积分返还
         * goods_info : {"goods_id":1,"goods_name":"糯冰种飘翠福瓜挂件","goods_sn":"3h66872","goods_price":"3980.00"}
         */

        private int order_id;
        private String order_sn;
        private int order_status;
        private String consignee;
        private String mobile;
        private String address;
        private Object shipping_no;
        private Object shipping_name;
        private int pay_type;
        private String goods_price;
        private String shipping_price;
        private String total_price;
        private String add_time;
        private Object shipping_time;
        private Object confirm_time;
        private int user_id;
        private int supplier_id;
        private int buy_type;
        private String logistics;
        private String supplier_name;
        private String pay_name;
        private String label;
        private GoodsInfoBean goods_info;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Object getShipping_no() {
            return shipping_no;
        }

        public void setShipping_no(Object shipping_no) {
            this.shipping_no = shipping_no;
        }

        public Object getShipping_name() {
            return shipping_name;
        }

        public void setShipping_name(Object shipping_name) {
            this.shipping_name = shipping_name;
        }

        public int getPay_type() {
            return pay_type;
        }

        public void setPay_type(int pay_type) {
            this.pay_type = pay_type;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getShipping_price() {
            return shipping_price;
        }

        public void setShipping_price(String shipping_price) {
            this.shipping_price = shipping_price;
        }

        public String getTotal_price() {
            return total_price;
        }

        public void setTotal_price(String total_price) {
            this.total_price = total_price;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public Object getShipping_time() {
            return shipping_time;
        }

        public void setShipping_time(Object shipping_time) {
            this.shipping_time = shipping_time;
        }

        public Object getConfirm_time() {
            return confirm_time;
        }

        public void setConfirm_time(Object confirm_time) {
            this.confirm_time = confirm_time;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getSupplier_id() {
            return supplier_id;
        }

        public void setSupplier_id(int supplier_id) {
            this.supplier_id = supplier_id;
        }

        public int getBuy_type() {
            return buy_type;
        }

        public void setBuy_type(int buy_type) {
            this.buy_type = buy_type;
        }

        public String getLogistics() {
            return logistics;
        }

        public void setLogistics(String logistics) {
            this.logistics = logistics;
        }

        public String getSupplier_name() {
            return supplier_name;
        }

        public void setSupplier_name(String supplier_name) {
            this.supplier_name = supplier_name;
        }

        public String getPay_name() {
            return pay_name;
        }

        public void setPay_name(String pay_name) {
            this.pay_name = pay_name;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public GoodsInfoBean getGoods_info() {
            return goods_info;
        }

        public void setGoods_info(GoodsInfoBean goods_info) {
            this.goods_info = goods_info;
        }

        public static class GoodsInfoBean {
            /**
             * goods_id : 1
             * goods_name : 糯冰种飘翠福瓜挂件
             * goods_sn : 3h66872
             * goods_price : 3980.00
             */

            private int goods_id;
            private String goods_name;
            private String goods_sn;
            private String goods_price;
            private String goods_img;

            public String getGoods_img() {
                return goods_img;
            }

            public void setGoods_img(String goods_img) {
                this.goods_img = goods_img;
            }

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
        }
    }
}
