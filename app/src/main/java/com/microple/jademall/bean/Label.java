package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/8/28
 * describe:
 */
public class Label {

    /**
     * label : {"label_desc":"如果你无法简洁的表达你的想法，那只能说明你还不够了解它"}
     */

    private LabelBean label;

    public LabelBean getLabel() {
        return label;
    }

    public void setLabel(LabelBean label) {
        this.label = label;
    }

    public static class LabelBean {
        /**
         * label_desc : 如果你无法简洁的表达你的想法，那只能说明你还不够了解它
         */

        private String label_desc;

        public String getLabel_desc() {
            return label_desc;
        }

        public void setLabel_desc(String label_desc) {
            this.label_desc = label_desc;
        }
    }
}
