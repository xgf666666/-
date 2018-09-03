package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/8/30
 * describe:
 */
public class Address {

    private List<AddressBean> address;

    public List<AddressBean> getAddress() {
        return address;
    }

    public void setAddress(List<AddressBean> address) {
        this.address = address;
    }

    public static class AddressBean {
        /**
         * ua_id : 1
         * user_id : 3
         * consigner : hwj
         * phone : 15915048904
         * province : 广东省
         * city : 广州市
         * district : 天河区
         * address : 富力盈凯广场
         * is_default : 1
         */

        private int ua_id;
        private int user_id;
        private String consigner;
        private String phone;
        private String province;
        private String city;
        private String district;
        private String address;
        private int is_default;

        public int getUa_id() {
            return ua_id;
        }

        public void setUa_id(int ua_id) {
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
}
