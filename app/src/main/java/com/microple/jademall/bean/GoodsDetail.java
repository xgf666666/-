package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/8/28
 * describe:
 */
public class GoodsDetail {


    /**
     * goods_info : {"goods_id":69,"cat_id":7,"goods_sn":"yjz14194","goods_name":"玉戒指","goods_price":"1288.00","goods_content":"/uploads/20181015/8f6fae656fa099ecdd5925bd25b8ac85.jpg","keywords":"戒指","goods_img":"/uploads/20181015/2940736e39f349f468231e67fe901d18.jpg","is_on_sale":0,"sort":0,"type":1,"origin_place":"云南","label":"1,2","transparency":"0.3","color":"绿色","add_time":1539603343,"is_hot":0,"parent_id":47,"supplier_id":1,"live_id":"0","estimate_price":"888.00","status":1,"is_estimate":1,"storage":"仓库","storage_charger":"邓伟","is_publish":1,"goods_video":"/uploads/20181023/a8a69135b8ce28036eb1ac3b25751df5.mp4","weight":"5.00","height":"50.0","width":"30.0","thickness":"20.0","is_collect":0,"is_shopp":0,"labels":[{"label_id":1,"label_name":"5年增值"},{"label_id":2,"label_name":"7天无理由退换、5年增加换新"}]}
     * other_sn : [{"goods_sn":"fcyhl1313","is_checked":0},{"goods_sn":"yjz14194","is_checked":1},{"goods_sn":"fcjjbz1002","is_checked":0}]
     * recomend_goods : [{"goods_id":50,"cat_id":7,"goods_sn":"fcsp1201","goods_name":"翡翠手链冰糯","goods_price":"2.00","goods_content":"/uploads/20181015/a2f0ccac1e6e69f733391e6fd44d003d.jpg,/uploads/20181015/a2f0ccac1e6e69f733391e6fd44d003d.jpg,/uploads/20181015/791923517caa8ece47535b6cf8c5ae53.jpg,/uploads/20181015/724ad8a471a77ef7958b82656d2e109b.jpg,/uploads/20181015/5e8680fa1f15bfb6a42f12e0bb31ee2f.jpg,/uploads/20181015/b9529383cae32d7b5744c30b5d9e1eb0.jpg,/uploads/20181015/b9529383cae32d7b5744c30b5d9e1eb0.jpg,/uploads/20181015/62d8528cd87f954710b5b9291ddd9f46.jpg,/uploads/20181015/62d8528cd87f954710b5b9291ddd9f46.jpg,/uploads/20181015/f27e0157b1dc9b9c42895872888518b0.jpg","keywords":"饰品","goods_img":"/uploads/20181015/1eee5b576e73d8f2e21a1aa9e8f4b4f6.jpg","is_on_sale":0,"sort":5,"type":1,"origin_place":"缅甸","label":"1,2","transparency":"不透明","color":"绿色","add_time":1539595002,"is_hot":0,"parent_id":0,"supplier_id":22,"live_id":"0","estimate_price":"1.00","status":1,"is_estimate":1,"storage":"放","storage_charger":"张三","is_publish":1,"goods_video":"","weight":"0.00"},{"goods_id":51,"cat_id":7,"goods_sn":"fcsp1202","goods_name":"翡翠运珠手链","goods_price":"110.00","goods_content":"/uploads/20181015/e9ae98ca745d6aa435cbfe2a45ecde50.jpg,/uploads/20181015/e9ae98ca745d6aa435cbfe2a45ecde50.jpg,/uploads/20181015/7fc1b2c68d5332e79892ab9519d0b910.jpg,/uploads/20181015/93cd41aaaad46c20f61d398d2c5a3706.jpg,/uploads/20181015/048e2e0c59ddb2bf6647e606fb57506a.jpg,/uploads/20181015/c2054e8c635d42ad513a0a65357cd479.jpg,/uploads/20181015/c2054e8c635d42ad513a0a65357cd479.jpg,/uploads/20181015/d0749577b4b0dc79a91d51e48b202a43.jpg,/uploads/20181015/2fb9cc29bb6062ca5470f6b185e8424a.jpg,/uploads/20181015/7788e7abe1e7b3847441ff15a7f00398.jpg,/uploads/20181015/7788e7abe1e7b3847441ff15a7f00398.jpg,/uploads/20181015/64a37858ebdced0dea7e575e8efb86d8.jpg,/uploads/20181015/075ef4da581261e011ac960c21096619.jpg","keywords":"饰品","goods_img":"/uploads/20181015/bed2aece44f99202856c73c9e20bd396.jpg","is_on_sale":0,"sort":6,"type":1,"origin_place":"缅甸","label":"1","transparency":"不透明","color":"绿色","add_time":1539595418,"is_hot":0,"parent_id":0,"supplier_id":22,"live_id":"0","estimate_price":"10.00","status":1,"is_estimate":1,"storage":"放","storage_charger":"张三","is_publish":1,"goods_video":"","weight":"0.00"},{"goods_id":61,"cat_id":7,"goods_sn":"fcae1231","goods_name":"翡翠王","goods_price":"20000.00","goods_content":"/uploads/20181015/e2dd7cdaba56a72951adf321c85bd9d0.jpg,/uploads/20181015/bbb13f17181b7a456e0baa71055d35d2.jpg","keywords":"翡翠","goods_img":"/uploads/20181015/bbb13f17181b7a456e0baa71055d35d2.jpg","is_on_sale":1,"sort":0,"type":1,"origin_place":"云南","label":"1,2","transparency":"0.5","color":"绿色","add_time":1539601601,"is_hot":0,"parent_id":50,"supplier_id":1,"live_id":"0","estimate_price":"10000.00","status":1,"is_estimate":1,"storage":"仓库","storage_charger":"邓伟","is_publish":1,"goods_video":"","weight":"0.00"},{"goods_id":63,"cat_id":7,"goods_sn":"fcyp1314","goods_name":"玉牌","goods_price":"26000.00","goods_content":"/uploads/20181015/7e2fa0a6bc0000f44ab45148ec37d989.jpg,/uploads/20181015/338122a9999254ae07398097dc9110ee.jpg","keywords":"翡翠","goods_img":"/uploads/20181015/68e062f6341b1262cb2a7d6166623238.jpg","is_on_sale":1,"sort":0,"type":1,"origin_place":"云南","label":"1,2","transparency":"0.5","color":"绿黄","add_time":1539602351,"is_hot":0,"parent_id":60,"supplier_id":1,"live_id":"37","estimate_price":"20000.00","status":1,"is_estimate":1,"storage":"仓库","storage_charger":"邓伟","is_publish":1,"goods_video":"","weight":"0.00"},{"goods_id":70,"cat_id":7,"goods_sn":"mlf1d3","goods_name":"弥勒佛","goods_price":"1888.00","goods_content":"/uploads/20181015/7b747a85e31889bf5bd4670821312ebe.jpg,/uploads/20181015/323cf54a6424ec1cc182ef435458cb78.jpg","keywords":"佛","goods_img":"/uploads/20181015/93cfea4e5448dbb7b8881d3df7cafeaa.jpg","is_on_sale":0,"sort":0,"type":1,"origin_place":"云南","label":"1,2","transparency":"0.4","color":"绿色","add_time":1539603478,"is_hot":0,"parent_id":57,"supplier_id":1,"live_id":"37,38","estimate_price":"1688.00","status":1,"is_estimate":1,"storage":"仓库","storage_charger":"邓伟","is_publish":1,"goods_video":"","weight":"0.00"}]
     */

    private GoodsInfoBean goods_info;
    private List<OtherSnBean> other_sn;
    private List<RecomendGoodsBean> recomend_goods;

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

    public List<RecomendGoodsBean> getRecomend_goods() {
        return recomend_goods;
    }

    public void setRecomend_goods(List<RecomendGoodsBean> recomend_goods) {
        this.recomend_goods = recomend_goods;
    }

    public static class GoodsInfoBean {
        /**
         * goods_id : 69
         * cat_id : 7
         * goods_sn : yjz14194
         * goods_name : 玉戒指
         * goods_price : 1288.00
         * goods_content : /uploads/20181015/8f6fae656fa099ecdd5925bd25b8ac85.jpg
         * keywords : 戒指
         * goods_img : /uploads/20181015/2940736e39f349f468231e67fe901d18.jpg
         * is_on_sale : 0
         * sort : 0
         * type : 1
         * origin_place : 云南
         * label : 1,2
         * transparency : 0.3
         * color : 绿色
         * add_time : 1539603343
         * is_hot : 0
         * parent_id : 47
         * supplier_id : 1
         * live_id : 0
         * estimate_price : 888.00
         * status : 1
         * is_estimate : 1
         * storage : 仓库
         * storage_charger : 邓伟
         * is_publish : 1
         * goods_video : /uploads/20181023/a8a69135b8ce28036eb1ac3b25751df5.mp4
         * weight : 5.00
         * height : 50.0
         * width : 30.0
         * thickness : 20.0
         * is_collect : 0
         * is_shopp : 0
         * labels : [{"label_id":1,"label_name":"5年增值"},{"label_id":2,"label_name":"7天无理由退换、5年增加换新"}]
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
        private String label;
        private String transparency;
        private String color;
        private int add_time;
        private int is_hot;
        private int parent_id;
        private int supplier_id;
        private String live_id;
        private String estimate_price;
        private int status;
        private int is_estimate;
        private String storage;
        private String storage_charger;
        private int is_publish;
        private String goods_video;
        private String weight;
        private String height;
        private String width;
        private String thickness;
        private int is_collect;
        private int is_shopp;
        private List<LabelsBean> labels;

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

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
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

        public int getIs_hot() {
            return is_hot;
        }

        public void setIs_hot(int is_hot) {
            this.is_hot = is_hot;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public int getSupplier_id() {
            return supplier_id;
        }

        public void setSupplier_id(int supplier_id) {
            this.supplier_id = supplier_id;
        }

        public String getLive_id() {
            return live_id;
        }

        public void setLive_id(String live_id) {
            this.live_id = live_id;
        }

        public String getEstimate_price() {
            return estimate_price;
        }

        public void setEstimate_price(String estimate_price) {
            this.estimate_price = estimate_price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getIs_estimate() {
            return is_estimate;
        }

        public void setIs_estimate(int is_estimate) {
            this.is_estimate = is_estimate;
        }

        public String getStorage() {
            return storage;
        }

        public void setStorage(String storage) {
            this.storage = storage;
        }

        public String getStorage_charger() {
            return storage_charger;
        }

        public void setStorage_charger(String storage_charger) {
            this.storage_charger = storage_charger;
        }

        public int getIs_publish() {
            return is_publish;
        }

        public void setIs_publish(int is_publish) {
            this.is_publish = is_publish;
        }

        public String getGoods_video() {
            return goods_video;
        }

        public void setGoods_video(String goods_video) {
            this.goods_video = goods_video;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
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

        public int getIs_collect() {
            return is_collect;
        }

        public void setIs_collect(int is_collect) {
            this.is_collect = is_collect;
        }

        public int getIs_shopp() {
            return is_shopp;
        }

        public void setIs_shopp(int is_shopp) {
            this.is_shopp = is_shopp;
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
             * label_name : 5年增值
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
         * goods_sn : fcyhl1313
         * is_checked : 0
         */

        private String goods_sn;
        private int is_checked;

        public String getGoods_sn() {
            return goods_sn;
        }

        public void setGoods_sn(String goods_sn) {
            this.goods_sn = goods_sn;
        }

        public int getIs_checked() {
            return is_checked;
        }

        public void setIs_checked(int is_checked) {
            this.is_checked = is_checked;
        }
    }

    public static class RecomendGoodsBean {
        /**
         * goods_id : 50
         * cat_id : 7
         * goods_sn : fcsp1201
         * goods_name : 翡翠手链冰糯
         * goods_price : 2.00
         * goods_content : /uploads/20181015/a2f0ccac1e6e69f733391e6fd44d003d.jpg,/uploads/20181015/a2f0ccac1e6e69f733391e6fd44d003d.jpg,/uploads/20181015/791923517caa8ece47535b6cf8c5ae53.jpg,/uploads/20181015/724ad8a471a77ef7958b82656d2e109b.jpg,/uploads/20181015/5e8680fa1f15bfb6a42f12e0bb31ee2f.jpg,/uploads/20181015/b9529383cae32d7b5744c30b5d9e1eb0.jpg,/uploads/20181015/b9529383cae32d7b5744c30b5d9e1eb0.jpg,/uploads/20181015/62d8528cd87f954710b5b9291ddd9f46.jpg,/uploads/20181015/62d8528cd87f954710b5b9291ddd9f46.jpg,/uploads/20181015/f27e0157b1dc9b9c42895872888518b0.jpg
         * keywords : 饰品
         * goods_img : /uploads/20181015/1eee5b576e73d8f2e21a1aa9e8f4b4f6.jpg
         * is_on_sale : 0
         * sort : 5
         * type : 1
         * origin_place : 缅甸
         * label : 1,2
         * transparency : 不透明
         * color : 绿色
         * add_time : 1539595002
         * is_hot : 0
         * parent_id : 0
         * supplier_id : 22
         * live_id : 0
         * estimate_price : 1.00
         * status : 1
         * is_estimate : 1
         * storage : 放
         * storage_charger : 张三
         * is_publish : 1
         * goods_video :
         * weight : 0.00
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
        private String label;
        private String transparency;
        private String color;
        private int add_time;
        private int is_hot;
        private int parent_id;
        private int supplier_id;
        private String live_id;
        private String estimate_price;
        private int status;
        private int is_estimate;
        private String storage;
        private String storage_charger;
        private int is_publish;
        private String goods_video;
        private String weight;

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

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
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

        public int getIs_hot() {
            return is_hot;
        }

        public void setIs_hot(int is_hot) {
            this.is_hot = is_hot;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public int getSupplier_id() {
            return supplier_id;
        }

        public void setSupplier_id(int supplier_id) {
            this.supplier_id = supplier_id;
        }

        public String getLive_id() {
            return live_id;
        }

        public void setLive_id(String live_id) {
            this.live_id = live_id;
        }

        public String getEstimate_price() {
            return estimate_price;
        }

        public void setEstimate_price(String estimate_price) {
            this.estimate_price = estimate_price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getIs_estimate() {
            return is_estimate;
        }

        public void setIs_estimate(int is_estimate) {
            this.is_estimate = is_estimate;
        }

        public String getStorage() {
            return storage;
        }

        public void setStorage(String storage) {
            this.storage = storage;
        }

        public String getStorage_charger() {
            return storage_charger;
        }

        public void setStorage_charger(String storage_charger) {
            this.storage_charger = storage_charger;
        }

        public int getIs_publish() {
            return is_publish;
        }

        public void setIs_publish(int is_publish) {
            this.is_publish = is_publish;
        }

        public String getGoods_video() {
            return goods_video;
        }

        public void setGoods_video(String goods_video) {
            this.goods_video = goods_video;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }
    }
}
