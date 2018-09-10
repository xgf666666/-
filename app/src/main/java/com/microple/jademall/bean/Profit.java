package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/10
 * describe:
 */
public class Profit {

    private List<ProfitsBean> profits;

    public List<ProfitsBean> getProfits() {
        return profits;
    }

    public void setProfits(List<ProfitsBean> profits) {
        this.profits = profits;
    }

    public static class ProfitsBean {
        /**
         * points : 200.00
         * add_time : 2018-09-10
         */

        private String points;
        private String add_time;

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
