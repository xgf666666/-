package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/9/20
 * describe:
 */
public class DetailShare {

    /**
     * share : {"goods_name":"糯冰种飘翠福瓜挂件","goods_sn":"3h66874","goods_img":"/uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg","link":"http://192.168.0.110/feicui/share.html?goodsid=3h66874"}
     */

    private ShareBean share;

    public ShareBean getShare() {
        return share;
    }

    public void setShare(ShareBean share) {
        this.share = share;
    }

    public static class ShareBean {
        /**
         * goods_name : 糯冰种飘翠福瓜挂件
         * goods_sn : 3h66874
         * goods_img : /uploads/20180906/9c66f12860fc81f49ca0086d0b32a5ca.jpg
         * link : http://192.168.0.110/feicui/share.html?goodsid=3h66874
         */

        private String goods_name;
        private String goods_sn;
        private String goods_img;
        private String link;

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_sn() {
            return goods_sn;
        }

        public void setGoods_sn(String goods_sn) {
            this.goods_sn = goods_sn;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
