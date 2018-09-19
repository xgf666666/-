package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/19
 * describe:
 */
public class SearchResult {

    /**
     * keyword : 飘翠
     * goods_list : [{"goods_id":1,"goods_sn":"3h66872","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180918/fd3eb1fc3721cd3bcd3042157a0b5107.jpg","goods_price":"3980.00"},{"goods_id":2,"goods_sn":"3h66873","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg","goods_price":"3980.00"},{"goods_id":3,"goods_sn":"3h66874","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg","goods_price":"3980.00"},{"goods_id":4,"goods_sn":"3g66572","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg","goods_price":"3980.00"},{"goods_id":5,"goods_sn":"3k68584","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180918/a749a6632b71122372002004761f8229.jpg","goods_price":"3980.00"},{"goods_id":6,"goods_sn":"3k68578","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg","goods_price":"3980.00"},{"goods_id":7,"goods_sn":"3h68578","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg","goods_price":"3980.00"},{"goods_id":8,"goods_sn":"3h66875","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg","goods_price":"3980.00"},{"goods_id":9,"goods_sn":"3h66877","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg","goods_price":"3950.00"},{"goods_id":14,"goods_sn":"3k68578","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg","goods_price":"3980.00"},{"goods_id":15,"goods_sn":"3k68578","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg","goods_price":"3980.00"},{"goods_id":16,"goods_sn":"3k68578","goods_name":"糯冰种飘翠福瓜挂件","goods_img":"/uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg","goods_price":"3980.00"}]
     * live_list : [{"live_id":1,"live_title":"3g66572号切石直播","desc":"测试测试测试","live_time":"2018-09-19 12:00"}]
     */

    private String keyword;
    private List<GoodsListBean> goods_list;
    private List<LiveListBean> live_list;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<GoodsListBean> getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(List<GoodsListBean> goods_list) {
        this.goods_list = goods_list;
    }

    public List<LiveListBean> getLive_list() {
        return live_list;
    }

    public void setLive_list(List<LiveListBean> live_list) {
        this.live_list = live_list;
    }

    public static class GoodsListBean {
        /**
         * goods_id : 1
         * goods_sn : 3h66872
         * goods_name : 糯冰种飘翠福瓜挂件
         * goods_img : /uploads/20180918/fd3eb1fc3721cd3bcd3042157a0b5107.jpg
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

    public static class LiveListBean {
        /**
         * live_id : 1
         * live_title : 3g66572号切石直播
         * desc : 测试测试测试
         * live_time : 2018-09-19 12:00
         */

        private int live_id;
        private String live_title;
        private String desc;
        private String live_time;

        public int getLive_id() {
            return live_id;
        }

        public void setLive_id(int live_id) {
            this.live_id = live_id;
        }

        public String getLive_title() {
            return live_title;
        }

        public void setLive_title(String live_title) {
            this.live_title = live_title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getLive_time() {
            return live_time;
        }

        public void setLive_time(String live_time) {
            this.live_time = live_time;
        }
    }
}
