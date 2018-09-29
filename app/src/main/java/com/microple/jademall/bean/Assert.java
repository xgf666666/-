package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/8/31
 * describe:
 */
public class Assert {

    /**
     * assets : {"total_points":10000,"pay_points":5000,"frozen_points":5000,"today_points":0}
     */

    private AssetsBean assets;

    public AssetsBean getAssets() {
        return assets;
    }

    public void setAssets(AssetsBean assets) {
        this.assets = assets;
    }

    public static class AssetsBean {
        /**
         * total_points : 10000
         * pay_points : 5000
         * frozen_points : 5000
         * today_points : 0
         */

        private String total_points;
        private String pay_points;
        private String frozen_points;
        private String today_points;

        public String getTotal_points() {
            return total_points;
        }

        public void setTotal_points(String total_points) {
            this.total_points = total_points;
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

        public String getToday_points() {
            return today_points;
        }

        public void setToday_points(String today_points) {
            this.today_points = today_points;
        }
    }
}
