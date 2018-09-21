package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/9/21
 * describe:
 */
public class Share {

    /**
     * share_info : {"user_name":"kevin2","head_img":"/uploads/20180831/252201939132936.jpg","code":"Yf0wWq","link":"http://192.168.0.110/feicui/registerIndex.html?code=Yf0wWq","qrcode":"http://bshare.optimix.asia/barCode?site=weixin&url=http://192.168.0.110/feicui/registerIndex.html?code=Yf0wWq"}
     */

    private ShareInfoBean share_info;

    public ShareInfoBean getShare_info() {
        return share_info;
    }

    public void setShare_info(ShareInfoBean share_info) {
        this.share_info = share_info;
    }

    public static class ShareInfoBean {
        /**
         * user_name : kevin2
         * head_img : /uploads/20180831/252201939132936.jpg
         * code : Yf0wWq
         * link : http://192.168.0.110/feicui/registerIndex.html?code=Yf0wWq
         * qrcode : http://bshare.optimix.asia/barCode?site=weixin&url=http://192.168.0.110/feicui/registerIndex.html?code=Yf0wWq
         */

        private String user_name;
        private String head_img;
        private String code;
        private String link;
        private String qrcode;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getHead_img() {
            return head_img;
        }

        public void setHead_img(String head_img) {
            this.head_img = head_img;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }
    }
}
