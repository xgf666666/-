package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/8/28
 * describe:
 */
public class GoodsDetail {

    /**
     * goods_info : {"goods_id":1,"cat_id":5,"goods_sn":"3h66872","goods_name":"糯冰种飘翠福瓜挂件","goods_price":"3980.00","goods_content":"1223","keywords":"翠绿","goods_img":"/uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg","is_on_sale":1,"sort":1,"type":1,"origin_place":"缅甸北部矿区","is_integral":1,"is_return":1,"transparency":"略透","color":"飘翠","add_time":1534060275,"height":"57.2","width":"21.0","thickness":"12.5"}
     * other_sn : [{"goods_sn":"3h66872","is_selected":1},{"goods_sn":"3h66875","is_checked":0},{"goods_sn":"3h66877","is_checked":0}]
     */

    private GoodsInfoBean goods_info;
    private List<OtherSnBean> other_sn;

    public GoodsInfoBean getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(GoodsInfoBean goods_info) {
        this.goods_info = goods_info;
    }

    public List<OtherSnBean> getOther_sn() {
        return other_sn;
    }

    public void setOther_sn(List<OtherSnBean> other_sn) {
        this.other_sn = other_sn;
    }

    public static class GoodsInfoBean {
        /**
         * goods_id : 1
         * cat_id : 5
         * goods_sn : 3h66872
         * goods_name : 糯冰种飘翠福瓜挂件
         * goods_price : 3980.00
         * goods_content : 1223
         * keywords : 翠绿
         * goods_img : /uploads/20180808/1a3c3ec77e6c798ace6b001e5bf3a123.jpg
         * is_on_sale : 1
         * sort : 1
         * type : 1
         * origin_place : 缅甸北部矿区
         * is_integral : 1
         * is_return : 1
         * transparency : 略透
         * color : 飘翠
         * add_time : 1534060275
         * height : 57.2
         * width : 21.0
         * thickness : 12.5
         */

        private int goods_id;
        private int cat_id;
        private String goods_sn;
        private String goods_name;
        private String goods_price;
        private String goods_content;
        private String keywords;
        private String goods_img;
        private int is_on_sale;
        private int sort;
        private int type;
        private String origin_place;
        private int is_integral;
        private int is_return;
        private String transparency;
        private String color;
        private int add_time;
        private String height;
        private String width;
        private String thickness;
        private int is_collect;
        private List<LabelsBean> labels;
        private int is_shopp;

        public int getIs_shopp() {
            return is_shopp;
        }

        public void setIs_shopp(int is_shopp) {
            this.is_shopp = is_shopp;
        }

        public int getIs_collect() {
            return is_collect;
        }

        public void setIs_collect(int is_collect) {
            this.is_collect = is_collect;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public int getCat_id() {
            return cat_id;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
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

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getGoods_content() {
            return goods_content;
        }

        public void setGoods_content(String goods_content) {
            this.goods_content = goods_content;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public int getIs_on_sale() {
            return is_on_sale;
        }

        public void setIs_on_sale(int is_on_sale) {
            this.is_on_sale = is_on_sale;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getOrigin_place() {
            return origin_place;
        }

        public void setOrigin_place(String origin_place) {
            this.origin_place = origin_place;
        }

        public int getIs_integral() {
            return is_integral;
        }

        public void setIs_integral(int is_integral) {
            this.is_integral = is_integral;
        }

        public int getIs_return() {
            return is_return;
        }

        public void setIs_return(int is_return) {
            this.is_return = is_return;
        }

        public String getTransparency() {
            return transparency;
        }

        public void setTransparency(String transparency) {
            this.transparency = transparency;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getThickness() {
            return thickness;
        }

        public void setThickness(String thickness) {
            this.thickness = thickness;
        }

        public List<LabelsBean> getLabels() {
            return labels;
        }

        public void setLabels(List<LabelsBean> labels) {
            this.labels = labels;
        }

        public static class LabelsBean {
            /**
             * label_id : 1
             * label_name : 积分返还
             */

            private int label_id;
            private String label_name;

            public int getLabel_id() {
                return label_id;
            }

            public void setLabel_id(int label_id) {
                this.label_id = label_id;
            }

            public String getLabel_name() {
                return label_name;
            }

            public void setLabel_name(String label_name) {
                this.label_name = label_name;
            }
        }
    }

    public static class OtherSnBean {
        /**
         * goods_sn : 3h66872
         * is_selected : 1
         * is_checked : 0
         */

        private String goods_sn;
        private int is_selected;
        private int is_checked;

        public String getGoods_sn() {
            return goods_sn;
        }

        public void setGoods_sn(String goods_sn) {
            this.goods_sn = goods_sn;
        }

        public int getIs_selected() {
            return is_selected;
        }

        public void setIs_selected(int is_selected) {
            this.is_selected = is_selected;
        }

        public int getIs_checked() {
            return is_checked;
        }

        public void setIs_checked(int is_checked) {
            this.is_checked = is_checked;
        }
    }
}
