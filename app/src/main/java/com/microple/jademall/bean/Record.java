package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/4
 * describe:
 */
public class Record {

    private List<ApplyListBean> apply_list;

    public List<ApplyListBean> getApply_list() {
        return apply_list;
    }

    public void setApply_list(List<ApplyListBean> apply_list) {
        this.apply_list = apply_list;
    }

    public static class ApplyListBean {
        /**
         * supplier_id : 1
         * supplier_name : 广州微标杆互联网科技有限公司
         * status : 0
         * status_desc : 待审核
         */

        private int supplier_id;
        private String supplier_name;
        private int status;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStatus_desc() {
            return status_desc;
        }

        public void setStatus_desc(String status_desc) {
            this.status_desc = status_desc;
        }
    }
}
