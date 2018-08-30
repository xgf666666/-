package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/8/29
 * describe:
 */
public class Search {

    private List<CategorysBean> categorys;
    private List<HotKeysBean> hot_keys;

    public List<CategorysBean> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<CategorysBean> categorys) {
        this.categorys = categorys;
    }

    public List<HotKeysBean> getHot_keys() {
        return hot_keys;
    }

    public void setHot_keys(List<HotKeysBean> hot_keys) {
        this.hot_keys = hot_keys;
    }

    public static class CategorysBean {
        /**
         * cat_id : 1
         * name : 翡翠系列
         */

        private int cat_id;
        private String name;

        public int getCat_id() {
            return cat_id;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class HotKeysBean {
        /**
         * keyword : 糯冰种
         * count : 20
         */

        private String keyword;
        private int count;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
