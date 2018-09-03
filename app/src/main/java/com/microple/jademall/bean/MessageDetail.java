package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/9/3
 * describe:
 */
public class MessageDetail {

    /**
     * msg_detail : {"msg_content":"如果你无法简洁的表达你的想法，那只说明你还不够了解它"}
     */

    private MsgDetailBean msg_detail;

    public MsgDetailBean getMsg_detail() {
        return msg_detail;
    }

    public void setMsg_detail(MsgDetailBean msg_detail) {
        this.msg_detail = msg_detail;
    }

    public static class MsgDetailBean {
        /**
         * msg_content : 如果你无法简洁的表达你的想法，那只说明你还不够了解它
         */

        private String msg_content;

        public String getMsg_content() {
            return msg_content;
        }

        public void setMsg_content(String msg_content) {
            this.msg_content = msg_content;
        }
    }
}
