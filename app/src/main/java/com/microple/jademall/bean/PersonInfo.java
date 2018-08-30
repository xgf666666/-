package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/8/30
 * describe:
 */
public class PersonInfo {

    /**
     * info : {"user_id":3,"user_name":"Kevin","phone":"15915872606","head_img":"/uploads/20180810/aae25a74e9e5d38811a489e45f30509b.jpg"}
     */

    private InfoBean info;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * user_id : 3
         * user_name : Kevin
         * phone : 15915872606
         * head_img : /uploads/20180810/aae25a74e9e5d38811a489e45f30509b.jpg
         */

        private int user_id;
        private String user_name;
        private String phone;
        private String head_img;

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getHead_img() {
            return head_img;
        }

        public void setHead_img(String head_img) {
            this.head_img = head_img;
        }
    }
}
