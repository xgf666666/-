package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/10
 * describe:
 */
public class Team {

    /**
     * total_money : 100
     * user_count : 2
     * user_list : [{"user_id":4,"user_name":"jk","head_img":"/uploads/20180819/3b6b12752b0dd67472411e1843aed8e0.jpg","phone":"15915048904","divide_money":50},{"user_id":8,"user_name":"","head_img":"/uploads/20180831/252201939132936.jpg","phone":"15915833333","divide_money":50}]
     */

    private String total_money;
    private int user_count;
    private List<UserListBean> user_list;

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }

    public int getUser_count() {
        return user_count;
    }

    public void setUser_count(int user_count) {
        this.user_count = user_count;
    }

    public List<UserListBean> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<UserListBean> user_list) {
        this.user_list = user_list;
    }

    public static class UserListBean {
        /**
         * user_id : 4
         * user_name : jk
         * head_img : /uploads/20180819/3b6b12752b0dd67472411e1843aed8e0.jpg
         * phone : 15915048904
         * divide_money : 50
         */

        private int user_id;
        private String user_name;
        private String head_img;
        private String phone;
        private int divide_money;

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getDivide_money() {
            return divide_money;
        }

        public void setDivide_money(int divide_money) {
            this.divide_money = divide_money;
        }
    }
}
