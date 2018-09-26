package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/26
 * describe:
 */
public class MyAppointment {

    private List<RecentAppointBean> recent_appoint;
    private List<AllAppointBean> all_appoint;

    public List<RecentAppointBean> getRecent_appoint() {
        return recent_appoint;
    }

    public void setRecent_appoint(List<RecentAppointBean> recent_appoint) {
        this.recent_appoint = recent_appoint;
    }

    public List<AllAppointBean> getAll_appoint() {
        return all_appoint;
    }

    public void setAll_appoint(List<AllAppointBean> all_appoint) {
        this.all_appoint = all_appoint;
    }

    public static class RecentAppointBean {
        /**
         * user_id : 3
         * live_id : 1
         * desc : 测试测试测试
         * start_time : 2018-09-26 19:00
         * live_title : 3g66572号切石直播
         */

        private int user_id;
        private String live_id;
        private String desc;
        private String start_time;
        private String live_title;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getLive_id() {
            return live_id;
        }

        public void setLive_id(String live_id) {
            this.live_id = live_id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getLive_title() {
            return live_title;
        }

        public void setLive_title(String live_title) {
            this.live_title = live_title;
        }
    }

    public static class AllAppointBean {
        /**
         * id : 2
         * user_id : 3
         * live_id : 2
         * desc : 测试
         * start_time : 2018-09-20 10:00
         * add_time : 1537412539
         * live_title : 3k68584号切石直播
         */

        private int id;
        private int user_id;
        private String live_id;
        private String desc;
        private String start_time;
        private int add_time;
        private String live_title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getLive_id() {
            return live_id;
        }

        public void setLive_id(String live_id) {
            this.live_id = live_id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public String getLive_title() {
            return live_title;
        }

        public void setLive_title(String live_title) {
            this.live_title = live_title;
        }
    }
}
