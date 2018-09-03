package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/8/31
 * describe:
 */
public class IntergrationDetail {

    /**
     * point_detail : {"points_change":"12.33","desc":"购买翡翠","add_time":"2018-08-21 15:27","supplier_name":"广州微标杆互联网科技有限公司","points":20920,"remark":"商品编号：3h66872"}
     */

    private PointDetailBean point_detail;

    public PointDetailBean getPoint_detail() {
        return point_detail;
    }

    public void setPoint_detail(PointDetailBean point_detail) {
        this.point_detail = point_detail;
    }

    public static class PointDetailBean {
        /**
         * points_change : 12.33
         * desc : 购买翡翠
         * add_time : 2018-08-21 15:27
         * supplier_name : 广州微标杆互联网科技有限公司
         * points : 20920
         * remark : 商品编号：3h66872
         */

        private String points_change;
        private String desc;
        private String add_time;
        private String supplier_name;
        private int points;
        private String remark;

        public String getPoints_change() {
            return points_change;
        }

        public void setPoints_change(String points_change) {
            this.points_change = points_change;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getSupplier_name() {
            return supplier_name;
        }

        public void setSupplier_name(String supplier_name) {
            this.supplier_name = supplier_name;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
