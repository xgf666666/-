package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/8/31
 * describe:
 */
public class AccountIinfo {

    /**
     * user_info : {"user_id":3,"user_name":"kevin2","head_img":"/uploads/20180819/3b6b12752b0dd67472411e1843aed8e0.jpg","pay_points":20920,"frozen_points":5000}
     * record : [{"to_user":4,"head_img":"/uploads/20180819/3b6b12752b0dd67472411e1843aed8e0.jpg","user_name":"jk","phone":"15915048904"}]
     */

    private UserInfoBean user_info;
    private List<RecordBean> record;

    public UserInfoBean getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoBean user_info) {
        this.user_info = user_info;
    }

    public List<RecordBean> getRecord() {
        return record;
    }

    public void setRecord(List<RecordBean> record) {
        this.record = record;
    }

    public static class UserInfoBean {
        /**
         * user_id : 3
         * user_name : kevin2
         * head_img : /uploads/20180819/3b6b12752b0dd67472411e1843aed8e0.jpg
         * pay_points : 20920
         * frozen_points : 5000
         */

        private int user_id;
        private String user_name;
        private String head_img;
        private String pay_points;
        private String frozen_points;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getHead_img() {
            return head_img;
        }

        public void setHead_img(String head_img) {
            this.head_img = head_img;
        }

        public String getPay_points() {
            return pay_points;
        }

        public void setPay_points(String pay_points) {
            this.pay_points = pay_points;
        }

        public String getFrozen_points() {
            return frozen_points;
        }

        public void setFrozen_points(String frozen_points) {
            this.frozen_points = frozen_points;
        }
    }

    public static class RecordBean {
        /**
         * to_user : 4
         * head_img : /uploads/20180819/3b6b12752b0dd67472411e1843aed8e0.jpg
         * user_name : jk
         * phone : 15915048904
         */

        private String to_user;
        private String head_img;
        private String user_name;
        private String phone;

        public String getTo_user() {
            return to_user;
        }

        public void setTo_user(String to_user) {
            this.to_user = to_user;
        }

        public String getHead_img() {
            return head_img;
        }

        public void setHead_img(String head_img) {
            this.head_img = head_img;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
