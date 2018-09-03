package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/8/31
 * describe:
 */
public class PointDetail {

    private List<UserPointBean> user_point;

    public List<UserPointBean> getUser_point() {
        return user_point;
    }

    public void setUser_point(List<UserPointBean> user_point) {
        this.user_point = user_point;
    }

    public static class UserPointBean {
        /**
         * add_time : 2018-08
         * year : 2018
         * month : 8月份
         * list : [{"up_id":1,"user_id":3,"type":2,"points":"12.33","text":"商城消费","add_time":"2018-08-21 15:27","order_sn":"20180815752231","points_change":"12.33"},{"up_id":6,"user_id":3,"type":1,"points":"3992.33","text":"原石兑换积分","add_time":"2018-08-25 17:48","order_sn":"20180816613457","points_change":"3980.00"}]
         */

        private String add_time;
        private String year;
        private String month;
        private List<ListBean> list;

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * up_id : 1
             * user_id : 3
             * type : 2
             * points : 12.33
             * text : 商城消费
             * add_time : 2018-08-21 15:27
             * order_sn : 20180815752231
             * points_change : 12.33
             */

            private int up_id;
            private int user_id;
            private int type;
            private String points;
            private String text;
            private String add_time;
            private String order_sn;
            private String points_change;
            private String time;
            private String year;
            private String month;
            private Boolean isHas;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public Boolean getHas() {
                return isHas;
            }

            public void setHas(Boolean has) {
                isHas = has;
            }

            public int getUp_id() {
                return up_id;
            }

            public void setUp_id(int up_id) {
                this.up_id = up_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getOrder_sn() {
                return order_sn;
            }

            public void setOrder_sn(String order_sn) {
                this.order_sn = order_sn;
            }

            public String getPoints_change() {
                return points_change;
            }

            public void setPoints_change(String points_change) {
                this.points_change = points_change;
            }
        }
    }
}
