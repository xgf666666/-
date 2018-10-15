package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/9/3
 * describe:
 */
public class HandImage {

    /**
     * img_url : /uploads/20180831/252201939132936.jpg
     */

    private String img_url;
    private String im_identifier;
    private String im_user_sig;

    public String getIm_identifier() {
        return im_identifier;
    }

    public void setIm_identifier(String im_identifier) {
        this.im_identifier = im_identifier;
    }

    public String getIm_user_sig() {
        return im_user_sig;
    }

    public void setIm_user_sig(String im_user_sig) {
        this.im_user_sig = im_user_sig;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
