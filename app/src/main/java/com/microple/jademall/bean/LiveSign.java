package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/10/15
 * describe:
 */
public class LiveSign {

    /**
     * im_identifier : 93db85ed909c13838ff95ccfa94cebd9
     * im_user_sig : eJxlkM1Og0AURvd9CsIWY2cYpp1r4oK0-hDqwoBR3BA6M5CblmECVGyN765SE0lcn-PlS87HzHEcN90kl4WUzcH0eX*02nWuHJe4F3-QWlR50eesVf*gfrfY6rwoe92O0OfgEzJVUGnTY4m-AjC1FVwrICApE0yUJXApywICqbcKJstO7fLxfRzSgBAaACViqmA1woebp1X0uEIQnQe*qQ5q7ts51ogsOy2sCeU6vd*RZxhgaHgkvDCq4ngtPEwXyZ2JbRrvbzMZhNm3W2dD0pFXOBWbl2NG031wPbnssT5HopwBB7aE5YS*6bbDxpxbEMoppUB*gsw*Z1*m92Ob
     */

    private String im_identifier;
    private String im_user_sig;
    private String img_url;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

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
}
