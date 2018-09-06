package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/9/4
 * describe:
 */
public class Note {

    /**
     * enter_protocol : {"value":"商家入驻条例"}
     */

    private EnterProtocolBean enter_protocol;

    public EnterProtocolBean getEnter_protocol() {
        return enter_protocol;
    }

    public void setEnter_protocol(EnterProtocolBean enter_protocol) {
        this.enter_protocol = enter_protocol;
    }

    public static class EnterProtocolBean {
        /**
         * value : 商家入驻条例
         */

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
