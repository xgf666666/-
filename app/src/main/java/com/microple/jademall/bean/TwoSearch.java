package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/29
 * describe:
 */
public class TwoSearch {

    /**
     * cat_name : 翡翠挂件
     * sec_cates : [{"cat_id":9,"name":"墨绿"},{"cat_id":10,"name":"青色"}]
     * goods : [{"goods_id":24,"goods_sn":"3hfcgjml3","goods_name":"翡翠挂件满绿3","goods_img":"/uploads/20180927/fb10be10131b57aa813a96965a8ccf58.jpg","goods_price":"3980.00"},{"goods_id":25,"goods_sn":"3hfcgjml11","goods_name":"翡翠挂件满绿2","goods_img":"/uploads/20180927/a0e0d62c392625fe1ff69e957b88ac67.jpg","goods_price":"1.00"}]
     */

    private String cat_name;
    private List<SecCatesBean> sec_cates;
    private List<GoodsBean> goods;

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public List<SecCatesBean> getSec_cates() {
        return sec_cates;
    }

    public void setSec_cates(List<SecCatesBean> sec_cates) {
        this.sec_cates = sec_cates;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class SecCatesBean {
        /**
         * cat_id : 9
         * name : 墨绿
         */

        private int cat_id;
        private String name;

        public int getCat_id() {
            return cat_id;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class GoodsBean {
        /**
         * goods_id : 24
         * goods_sn : 3hfcgjml3
         * goods_name : 翡翠挂件满绿3
         * goods_img : /uploads/20180927/fb10be10131b57aa813a96965a8ccf58.jpg
         * goods_price : 3980.00
         */

        private int goods_id;
        private String goods_sn;
        private String goods_name;
        private String goods_img;
        private String goods_price;

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_sn() {
            return goods_sn;
        }

        public void setGoods_sn(String goods_sn) {
            this.goods_sn = goods_sn;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }
    }
}
