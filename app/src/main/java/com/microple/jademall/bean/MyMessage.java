package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/3
 * describe:
 */
public class MyMessage {

    private List<MessagesBean> messages;

    public List<MessagesBean> getMessages() {
        return messages;
    }

    public void setMessages(List<MessagesBean> messages) {
        this.messages = messages;
    }

    public static class MessagesBean {
        /**
         * msg_id : 2
         * user_id : 3
         * msg_content : 如果你无法简洁的表达你的想法，那只说明你还不够了解它
         * msg_time : 2018-09-03 09:30:33
         */

        private int msg_id;
        private int user_id;
        private String msg_content;
        private String msg_time;

        public int getMsg_id() {
            return msg_id;
        }

        public void setMsg_id(int msg_id) {
            this.msg_id = msg_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getMsg_content() {
            return msg_content;
        }

        public void setMsg_content(String msg_content) {
            this.msg_content = msg_content;
        }

        public String getMsg_time() {
            return msg_time;
        }

        public void setMsg_time(String msg_time) {
            this.msg_time = msg_time;
        }
    }
}
