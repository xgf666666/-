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

        private int total_points;
        private int pay_points;
        private int frozen_points;
        private int today_points;

        public int getTotal_points() {
            return total_points;
        }

        public void setTotal_points(int total_points) {
            this.total_points = total_points;
        }

        public int getPay_points() {
            return pay_points;
        }

        public void setPay_points(int pay_points) {
            this.pay_points = pay_points;
        }

        public int getFrozen_points() {
            return frozen_points;
        }

        public void setFrozen_points(int frozen_points) {
            this.frozen_points = frozen_points;
        }

        public int getToday_points() {
            return today_points;
        }

        public void setToday_points(int today_points) {
            this.today_points = today_points;
        }
    }
}
