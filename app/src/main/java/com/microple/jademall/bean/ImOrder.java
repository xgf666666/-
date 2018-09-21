package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/13
 * describe:
 */
public class ImOrder {

    /**
     * order : {"total_fee":4000,"shipping_fee":20,"goods_info":[{"goods_id":8,"goods_sn":"3h66875","goods_price":"3980.00","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg"}],"user_address":{"ua_id":3,"user_id":3,"consigner":"jk","phone":"15464679655","province":"广东省","city":"广州市","district":"天河区","address":"测试","is_default":1}}
     */

    private OrderBean order;

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public static class OrderBean {
        /**
         * total_fee : 4000
         * shipping_fee : 20
         * goods_info : [{"goods_id":8,"goods_sn":"3h66875","goods_price":"3980.00","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg"}]
         * user_address : {"ua_id":3,"user_id":3,"consigner":"jk","phone":"15464679655","province":"广东省","city":"广州市","district":"天河区","address":"测试","is_default":1}
         */

        private String total_fee;
        private String shipping_fee;
        private UserAddressBean user_address;
        private List<GoodsInfoBean> goods_info;

        public String getTotal_fee() {
            return total_fee;
        }

        public void setTotal_fee(String total_fee) {
            this.total_fee = total_fee;
        }

        public String getShipping_fee() {
            return shipping_fee;
        }

        public void setShipping_fee(String shipping_fee) {
            this.shipping_fee = shipping_fee;
        }

        public UserAddressBean getUser_address() {
            return user_address;
        }

        public void setUser_address(UserAddressBean user_address) {
            this.user_address = user_address;
        }

        public List<GoodsInfoBean> getGoods_info() {
            return goods_info;
        }

        public void setGoods_info(List<GoodsInfoBean> goods_info) {
            this.goods_info = goods_info;
        }

        public static class UserAddressBean {
            /**
             * ua_id : 3
             * user_id : 3
             * consigner : jk
             * phone : 15464679655
             * province : 广东省
             * city : 广州市
             * district : 天河区
             * address : 测试
             * is_default : 1
             */

            private String ua_id;
            private int user_id;
            private String consigner;
            private String phone;
            private String province;
            private String city;
            private String district;
            private String address;
            private int is_default;

            public String getUa_id() {
                return ua_id;
            }

            public void setUa_id(String ua_id) {
                this.ua_id = ua_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getConsigner() {
                return consigner;
            }

            public void setConsigner(String consigner) {
                this.consigner = consigner;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getIs_default() {
                return is_default;
            }

            public void setIs_default(int is_default) {
                this.is_default = is_default;
            }
        }

        public static class GoodsInfoBean {
            /**
             * goods_id : 8
             * goods_sn : 3h66875
             * goods_price : 3980.00
             * goods_name : 糯冰种飘翠福瓜挂件
             * goods_img : /uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg
             */

            private String goods_id;
            private String goods_sn;
            private String goods_price;
            private String goods_name;
            private String goods_img;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
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
}
