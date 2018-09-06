package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/9/4
 * describe:
 */
public class RecordDetail {

    /**
     * apply_info : {"supplier_id":1,"supplier_name":"广州微标杆互联网科技有限公司","user_id":3,"email":"1048711416@qq.com","phone":"15915048904","license":"/uploads/supplier/20180828/7259817a7e1c2bbd1d8aa5519ca1f157.jpg","attachment":"/uploads/supplier/20180828/eb79955230210ae53fcc9e1f108c4509.jpg","status":0,"created_time":"2018-08-21 15:27:46","inviter":"kevin2","status_desc":"审核中"}
     */

    private ApplyInfoBean apply_info;

    public ApplyInfoBean getApply_info() {
        return apply_info;
    }

    public void setApply_info(ApplyInfoBean apply_info) {
        this.apply_info = apply_info;
    }

    public static class ApplyInfoBean {
        /**
         * supplier_id : 1
         * supplier_name : 广州微标杆互联网科技有限公司
         * user_id : 3
         * email : 1048711416@qq.com
         * phone : 15915048904
         * license : /uploads/supplier/20180828/7259817a7e1c2bbd1d8aa5519ca1f157.jpg
         * attachment : /uploads/supplier/20180828/eb79955230210ae53fcc9e1f108c4509.jpg
         * status : 0
         * created_time : 2018-08-21 15:27:46
         * inviter : kevin2
         * status_desc : 审核中
         */

        private int supplier_id;
        private String supplier_name;
        private int user_id;
        private String email;
        private String phone;
        private String license;
        private String attachment;
        private int status;
        private String created_time;
        private String inviter;
        private String status_desc;

        public int getSupplier_id() {
            return supplier_id;
        }

        public void setSupplier_id(int supplier_id) {
            this.supplier_id = supplier_id;
        }

        public String getSupplier_name() {
            return supplier_name;
        }

        public void setSupplier_name(String supplier_name) {
            this.supplier_name = supplier_name;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getAttachment() {
            return attachment;
        }

        public void setAttachment(String attachment) {
            this.attachment = attachment;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }

        public String getInviter() {
            return inviter;
        }

        public void setInviter(String inviter) {
            this.inviter = inviter;
        }

        public String getStatus_desc() {
            return status_desc;
        }

        public void setStatus_desc(String status_desc) {
            this.status_desc = status_desc;
        }
    }
}
