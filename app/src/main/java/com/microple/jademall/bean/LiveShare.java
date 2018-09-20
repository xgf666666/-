package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/9/20
 * describe:
 */
public class LiveShare {


    /**
     * share : {"live_title":"3g66572号切石直播","desc":"测试测试测试","cover_img":"/uploads/20180918/81dcad2de5b548ecdee253bafd97ea9e.jpg","link":"http://192.168.0.110/feicui/video.html?live_id=1"}
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
         * live_title : 3g66572号切石直播
         * desc : 测试测试测试
         * cover_img : /uploads/20180918/81dcad2de5b548ecdee253bafd97ea9e.jpg
         * link : http://192.168.0.110/feicui/video.html?live_id=1
         */

        private String live_title;
        private String desc;
        private String cover_img;
        private String link;

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

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
