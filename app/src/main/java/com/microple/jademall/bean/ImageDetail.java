package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/8/28
 * describe:
 */
public class ImageDetail {

    /**
     * goods : {"goods_content":"/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg,/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg,/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg"}
     */

    private GoodsBean goods;

    public GoodsBean getGoods() {
        return goods;
    }

    public void setGoods(GoodsBean goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * goods_content : /uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg,/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg,/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg
         */

        private String goods_content;

        public String getGoods_content() {
            return goods_content;
        }

        public void setGoods_content(String goods_content) {
            this.goods_content = goods_content;
        }
    }
}
